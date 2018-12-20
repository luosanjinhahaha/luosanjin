package com.smxy.healthmedical.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smxy.healthmedical.bean.*;
import com.smxy.healthmedical.bean.Permission;
import com.smxy.healthmedical.realm.UserToken;
import com.smxy.healthmedical.realm.UserType;
import com.smxy.healthmedical.service.*;
import com.smxy.healthmedical.utils.MyFastDfsApi;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 功能描述:
 * @author luoxin
 */

@Controller
@RequestMapping("/admin")
public class BackStageController {
	private final AdminService adminService;
	private final ReadFileService readFileService;
	private final InfoService infoService;
	private final DeptService deptService;
	private final FamdoctorService famdoctorService;
	private final GetImgPathService getImgPathService;
	private final DoctorService doctorService;
	private final RolePermissionService rolePermissionService;
	private final PermissionService permissionService;

	@Autowired
	public BackStageController(AdminService adminService,ReadFileService readFileService,InfoService infoService,
							   DeptService deptService,FamdoctorService famdoctorService,GetImgPathService getImgPathService,
							   DoctorService doctorService,RolePermissionService rolePermissionService,PermissionService permissionService){
		this.adminService = adminService;
		this.readFileService = readFileService;
		this.infoService = infoService;
		this.deptService = deptService;
		this.famdoctorService = famdoctorService;
		this.getImgPathService = getImgPathService;
		this.doctorService = doctorService;
		this.rolePermissionService = rolePermissionService;
		this.permissionService = permissionService;
	}
	private final String http = "http://106.14.160.207:8888/";

    private static final Logger logger = LoggerFactory.getLogger(BackStageController.class);

    private static final String ADMIN_USER_TYPE = UserType.ADMIN.toString();

    private static final Logger LOGGER = LoggerFactory.getLogger(BackStageController.class);

	@RequestMapping("/background")
	public String background(){
		return "frontdesk/adminlogin";
	}

	/**
	 *后台登录页面
	 */
	@PostMapping("/adminlogin")
	@ResponseBody
	public Msg adminLogin(AdminUsers adminUsers, HttpServletRequest request){

		/*获取subject对象*/
		Subject subject = SecurityUtils.getSubject();

		/*将用户名和密码封装到继承自定义的UsernamePasswordToken的子类userToken中*/
		UserToken token = new UserToken(adminUsers.getAdminName(),adminUsers.getAdminPassword(),ADMIN_USER_TYPE);
		token.setRememberMe(false);

		LOGGER.info(token.getUsername() + "-------->" + token.getPassword());
		try {
            /*执行认证:传到ModularRealmAuthenticator类中，然后根据ADMIN_USER_TYPE传到AdminShiroRealm的方法进行认证*/
            subject.login(token);
            AdminUsers adminUserName = (AdminUsers) subject.getPrincipal();
			request.getSession().setAttribute("admin", adminUserName.getAdminRealname());
			return Msg.success();
		} catch (AuthenticationException e) {
			return Msg.fail();
		}
	}

    /**
     * 退出后台管理的管理员信息
     */
    @PostMapping("/logout")
    @ResponseBody
    public Msg adminLoginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Msg.success();
    }

	/*管理员登录成功去后台管理主页*/
	@GetMapping("/to_main")
	public String toMain(){
		return "backendsystem/main";
	}

	/**在index页查出所有患者信息**/
	@GetMapping("/details")
	@ResponseBody
	public Msg toDetails(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
		List<AdminUsers> admin = adminService.getadmin();
		List<Info> patients1 = infoService.getAll();
		/*患者分页查询*/
		PageHelper.startPage(pn,10);
		List<Info> patients = infoService.getAll();
		PageInfo<Info> page = new PageInfo<>(patients,6);
		return Msg.success().add("PageInfo",page).add("sum",patients1.size()).add("adminsum",admin.size());
	}

    /**
     * 根据医师id获取医师的角色权限
     * @param roleId 医师id
     * @return Msg
     */
	@GetMapping("/getRolePermission/{roleId}")
    @ResponseBody
	public Msg getRolePermission(@PathVariable("roleId") Integer roleId){
		List<RolePermission> doctorPermissions =  rolePermissionService.getDoctorPermissionByRoleId(roleId);
		List<Permission> permissions = permissionService.getPermissionAll();
		LOGGER.info("所有权限为：" + permissions.toString());
        LOGGER.info(doctorPermissions.toString());
        return Msg.success().add("doctorPermissions",doctorPermissions).add("permissions",permissions);
    }

	/**
	 * 添加医师权限
	 * @param doctorRoleId 医师角色id
	 * @param addPermissionId 权限id
	 * @return Msg
	 */
    @PostMapping("/addDoctorPermission")
	@ResponseBody
    public Msg addDoctorPermission(@RequestParam("doctorRoleId") Integer doctorRoleId,
								   @RequestParam("addPermissionId") String addPermissionId){
    	LOGGER.info(doctorRoleId + "------>" + addPermissionId);
    	if(addPermissionId.contains("-")){
    		List<Integer> permissionId = new ArrayList<>();
    		String[] permissionIds = addPermissionId.split("-");
			for (String ids : permissionIds) {
				permissionId.add(Integer.parseInt(ids));
			}
			/*批量添加*/
			rolePermissionService.addDoctorPermissions(doctorRoleId, permissionId);
			return Msg.success();
		}else {
    		/*单个添加*/
			RolePermission rolePermission = new RolePermission();
			rolePermission.setRoleId(doctorRoleId);
			rolePermission.setPermissionId(Integer.parseInt(addPermissionId));
			rolePermissionService.addDoctorPermission(rolePermission);
			return Msg.success();
		}
	}

	/**
	 * 通过角色id权限id删除医师权限
	 * @param removePermissionId 要移除的权限id
	 * @param doctorRoleId 医师角色id
	 * @return Msg
	 */
	@PostMapping("/removeDoctorPermission")
	@ResponseBody
	public Msg removeDoctorPermission(@RequestParam("removePermissionId") String removePermissionId,
									  @RequestParam("doctorRoleId") Integer doctorRoleId){
    	if(removePermissionId.contains("-")){
    		List<Integer> permissionId = new ArrayList<>();
			String[] permissionIds = removePermissionId.split("-");
			for (String ids : permissionIds) {
				permissionId.add(Integer.parseInt(ids));
			}
			/*批量删除*/
			rolePermissionService.deleteDoctorPermissions(doctorRoleId,permissionId);
			return Msg.success();

		}else {
    		/*单个删除*/
			RolePermission rolePermission = new RolePermission();
			rolePermission.setRoleId(doctorRoleId);
			rolePermission.setPermissionId(Integer.parseInt(removePermissionId));
			LOGGER.info(rolePermission.toString());
			rolePermissionService.deleteDoctorPermission(rolePermission);
			return Msg.success();
		}
	}

	/**
	 * 点击权限管理获取管理员
	 */
	@GetMapping("/useradmin")
	public String getAdmin(Model model){
		List<AdminUsers> admin = adminService.getadmin();
		model.addAttribute("admininfo", admin);
		return "backendsystem/adminuser";
	}

	/**
	 * @return role角色管理页面
	 * @author luoxin
	 * @date 2018/11/30 19:34
	 */
	@GetMapping("/roleManager")
	public String authority(Model model){
		List<Doctor> doctorList = doctorService.getDoctorsAll();
		model.addAttribute("doctorList", doctorList);
		System.out.println(doctorList);
		return "backendsystem/roleManager";
	}

	/**
	 * 功能描述:医师主页
	 * @return 医师主页
	 * @author luoxin
	 * @date 2018/12/1 12:36
	 */
	@RequiresRoles("superAdmin")
//	@RequiresRoles("dasdsa")
	@GetMapping("/doctorProfile/{doctorId}")
	public String doctorProfile(@PathVariable("doctorId") Integer doctorId,Model model){
        List<Doctor> doctorInfoList = doctorService.getDoctorsByDoctorId(doctorId);
		for (Doctor doctorInfo : doctorInfoList) {
			doctorInfo.setDoctorPhotoSrc(http + doctorInfo.getDoctorPhotoSrc());
		}
        model.addAttribute("doctorInfoList",doctorInfoList);
        System.out.println(doctorInfoList);
        return "backendsystem/doctor-profile";
	}

	@GetMapping("/subordinate/{piId}")
	@ResponseBody
	public Msg subordinate(@PathVariable("piId") Integer piId){
		List<Info> infoList = infoService.getInfoByPiId(piId);
		return Msg.success().add("infoList",infoList);
	}

	/**
	 * 功能描述:医师总览
	 * @return 医师总览
	 * @author luoxin
	 * @date 2018/12/1 14:25
	 */
	@GetMapping("/doctorOverview")
	public String doctorOverview(Model model){
		List<Doctor> doctorOverviewList = doctorService.getDoctorsAll();
		for (Doctor doctordoctorOverviewLists : doctorOverviewList) {
			doctordoctorOverviewLists.setDoctorPhotoSrc(http + doctordoctorOverviewLists.getDoctorPhotoSrc());
		}
		model.addAttribute("doctorOverviewList",doctorOverviewList);
		System.out.println(doctorOverviewList);
		return "backendsystem/doctorOverview";
	}


	/**
	 * 保存管理员修改信息
	 */
	@ResponseBody
	@PostMapping("/save_admin/{adminId}")
	public Msg getLimitadmin(AdminUsers adminUsers){
		adminService.updatelimitadmin(adminUsers);
		return Msg.success();
	}

	/**
	 * 后台管理的文件上传
	 */
	@PostMapping(value = "/upload")
	@ResponseBody
	public Msg upload(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException{
		String realpath = "C:\\Users\\luoxin\\AppData\\Local\\Temp\\tomcat-docbase.7421224295315167926.8080\\upload"+"/"+file.getOriginalFilename();
//		String path=request.getServletContext().getRealPath("/")+"/upload/file/2.jpg";
		if(file.getSize() != 0){
			file.transferTo(new File(realpath));
			System.out.println(realpath);
			readFileService.javaPoi(realpath);
			return Msg.success();
		}
		else{
			return Msg.fail();
		}
	}

	/**
	 * 后台管理的患者删除
	 */
	@DeleteMapping("/delpatients/{ids}")
	@ResponseBody
	public Msg delPatients(@PathVariable("ids")String ids){
		String reg = "-";
		if(ids.contains(reg)){
			List<Integer> delIds = new ArrayList<>();
			String[] strIds = ids.split("-");
			for (String string : strIds) {
				delIds.add(Integer.parseInt(string));
			}
			infoService.deleteBatch(delIds);
		}else{
			Integer id = Integer.parseInt(ids);
			infoService.delPatientsById(id);
			return Msg.success();
		}
		return Msg.success();
	}
	/**
	 * 患者更新信息保存
	 */
	@PostMapping("/updatepatients/{pinfoId}")
	@ResponseBody
	public Msg updatePatients(Info info){
		infoService.UpdatePatients(info);
		return Msg.success();
	}
	/**
	 * 患者更新的信息查询
	 */
	@GetMapping("/patients/{id}")
	public ModelAndView getUpdatePatients(@PathVariable("id")Integer id){
		ModelAndView mv = new ModelAndView();
		Info info = infoService.getPatients(id);
		List<Department> list = deptService.getDepts();
		mv.addObject("departments",list);
		mv.addObject("info",info);
		System.out.println(info.getDepartment().getDeptName());
		mv.setViewName("backendsystem/editpatients");
		return mv;
	}

	/**
	 * 检验患者姓名是否重复
	 */
	@RequestMapping("/checkpatients")
	@ResponseBody
	public Msg checkpatients(@RequestParam("pinfoName")String pinfoName){
		String regx = "(^[a-zA-Z0-9_-]{4,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!pinfoName.matches(regx)){
			return Msg.fail().add("va_msg","患者名必须是2-5位中文或4-16位英文数字的组合");
		}
		boolean b = infoService.checkpatients(pinfoName);
		if(b){
			return Msg.success().add("va_msg","患者名可用");
		}else{
			return Msg.fail().add("va_msg","患者名不可用");
		}
	}

	/**
	 * 新增患者
	 */
	@PutMapping("/savepatients")
	@ResponseBody
	public Msg savePatients(Info info){
		infoService.savePatients(info);
		return Msg.success();
	}

	/**
	 * 查出所有患者及数量
	 */
	@RequestMapping("/allpatients")
	public String getAllPatients(Model model) {
		List<Info> patients = infoService.getAll();
		List<AdminUsers> admin = adminService.getadmin();
		model.addAttribute("adminsum",admin.size());
		model.addAttribute("patients",patients);
		model.addAttribute("sum",patients.size());
		return "backendsystem/main";
	}

	@GetMapping("/filemanager")
	public String filemanager(){
		return "backendsystem/fileManager";
	}

	/**
	 * 功能描述:上传图片到fastDFS
	 * @return map
	 * @author luoxin
	 * @date 2018/11/14 20:40
	 */
	@PostMapping("/fastDFS_upload")
	@ResponseBody
	public Msg fastDFSUpload(MultipartFile file) throws Exception {
		MyFastDfsApi myFastDfsApi = new MyFastDfsApi();
		System.out.println("-------->" + file.getSize());
		String path = "";
		if(!"".equals(file.getSize())){
			path = myFastDfsApi.uploadImg(file);
			System.out.println(path);
		}
		FastDfsImg fastDfsImg = new FastDfsImg();
		fastDfsImg.setImgPath(path);
		System.out.println(fastDfsImg);
		getImgPathService.ImgPath(fastDfsImg);
		return Msg.success().add("path",path);
	}

	@PostMapping("/fastDFS_delete")
	@ResponseBody
	public Msg fastDFSDelete(String oldPath) throws Exception {
		System.out.println(oldPath);
		MyFastDfsApi myFastDfsApi = new MyFastDfsApi();
		if(!"".equals(oldPath)){
			myFastDfsApi.deleteImg(oldPath);
			getImgPathService.deleteImgByPath(oldPath);
		}else{
			return Msg.fail();
		}
		return Msg.success();
	}

	/**
	 * 功能描述:回显fastDFS文件于页面
	 * @return 返回fastDFS对象
	 * @author luoxin
	 * @date 2018/11/15 20:43
	 */
	@GetMapping("/showFastDfsImg")
	@ResponseBody
	public Msg showFastDfsImgAll(){
		List<FastDfsImg> fastDfsImgs = getImgPathService.getImgPathAll();
		for(FastDfsImg fastDfsImg : fastDfsImgs){
			fastDfsImg.setImgPath(http + fastDfsImg.getImgPath());
		}
//        fastDfsImgs.forEach(item -> {
//            System.out.println(item);
//        });
		logger.info(String.valueOf(fastDfsImgs));
		return Msg.success().add("fastDfsImg",fastDfsImgs);
	}

	/**
	 * 患者全部查询
	 */
	@RequestMapping("/patients")
	@ResponseBody
	public Msg getPatients(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 7);
		List<Info> patients = infoService.getAll();
		PageInfo page = new PageInfo(patients, 5);
		return Msg.success().add("PageInfo", page);
	}

	/**
	 * 患者添加页并查出所有部门
	 */
	@GetMapping(value = "/add_patients")
	public String savePatients(Model model) {
		List<Department> list = deptService.getDepts();
		model.addAttribute("departments", list);
		return "backendsystem/addpatients";
	}

	/**
	 * 名医简介
	 */
	@GetMapping("/famous_dr")
	public String famousDr(Model model){
		List<Famous_Doctor> famdoctorlist = famdoctorService.getAll();
		for (Famous_Doctor famousDoctor : famdoctorlist) {
			famousDoctor.setDrphotosrc(http+famousDoctor.getDrphotosrc());
		}
		model.addAttribute("famdoctor", famdoctorlist);
		return "backendsystem/Dr/drs";
	}

	/**
	 * 患者分析
	 */
	@RequestMapping("/analyze")
	public String analyze(){
		return "backendsystem/analyze/analyze";
	}

	/**
	 * 得到患者所在部门及患病类型人数
	 * @return Map
	 */
	@GetMapping("/illtypenum")
	@ResponseBody
	public Map<String, Object[]> illtypenum(){
		List<Department> deptlist = deptService.getDepts();
		Integer[] count = infoService.getAllInfoPiId();
		String categories = "";
		String deptData[] = {};
		String regex = "&";
		for (Department department : deptlist) {
			categories += department.getDeptName() + "&";
		}
		categories = categories.trim();
		deptData = categories.split(regex);
		Map<String,Object[]> map = new HashMap<String, Object[]>();
		map.put("dept", deptData);
		map.put("num", count);
		return map;
	}
}
