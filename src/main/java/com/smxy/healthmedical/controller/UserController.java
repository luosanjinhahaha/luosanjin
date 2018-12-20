package com.smxy.healthmedical.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smxy.healthmedical.bean.*;
import com.smxy.healthmedical.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 * @author luoxin
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private final RegService regService;
	private final MailService mailService;
	private final FamdoctorService famdoctorService;
	private final DeptService deptService;
	private final AppointService appointService;
	private final CustomizationService customizationService;
	private final QuestionService questionService;
	private final CommentService commentService;
	private final AppointDoctorWithDeptService appointDoctorWithDeptService;
	private final DoctorService doctorService;

	@Autowired
	public UserController(RegService regService,MailService mailService,FamdoctorService famdoctorService,
						  DeptService deptService,AppointService appointService, CustomizationService customizationService,
						  QuestionService questionService,CommentService commentService,
						  AppointDoctorWithDeptService appointDoctorWithDeptService, DoctorService doctorService){
		this.regService = regService;
		this.mailService = mailService;
		this.famdoctorService = famdoctorService;
		this.deptService = deptService;
		this.appointService = appointService;
		this.customizationService = customizationService;
		this.questionService = questionService;
		this.commentService = commentService;
		this.appointDoctorWithDeptService = appointDoctorWithDeptService;
		this.doctorService = doctorService;

	}

	@GetMapping("/havesession")
	@ResponseBody
	public Msg getSession(){
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		if(session.getAttribute("realname") == null){
			return Msg.fail();
		}
		return Msg.success();
	}

	/**
	 * 医师团队
	 * @param model model
	 * @return String
	 */
	@GetMapping("/doctorlist")
	public String doctorList(Model model){
		List<Famous_Doctor> famousDoctors = famdoctorService.getAll();
		String http = "http://127.0.0.1:8082";
		for (Famous_Doctor famousDoctor : famousDoctors) {
			famousDoctor.setDrphotosrc(http + famousDoctor.getDrphotosrc());
		}
		model.addAttribute("famousdoctors",famousDoctors);
		return "frontdesk/doctorlist";
	}

	@GetMapping("/to_customization")
	public String toCustomization(Model model){
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String username = (String) session.getAttribute("realname");
		User user = regService.queryuserbyid(username);
		System.out.println(user);
		model.addAttribute("customizationInfo",user);
		return "frontdesk/customization";
	}

	@PostMapping("/customization")
	@ResponseBody
	public Msg customization(Customization customization){
		customizationService.insertCustomizationInfo(customization);
		System.out.println(customization);
		return Msg.success();
	}

	/**
	 * 发送邮箱验证码
	 * @param email 收件人邮箱
	 * @return Msg
	 */
	@ResponseBody
	@RequestMapping("/mailsender")
	public Msg mailSender(String email) {
		String code = mailService.send(email);
		return Msg.success().add("code", code);
	}

	@GetMapping("/index")
	public String userIndex(Model model){
		List<Department> list = deptService.getDepts();
		List<Famous_Doctor> famdoctorlist = famdoctorService.getAll();
		model.addAttribute("famdoctor",famdoctorlist);
		model.addAttribute("dept",list);
		return "frontdesk/homepage";
	}

	@GetMapping("/consult")
	public String userAppointconsult( Model model){
		List<Department> list = deptService.getDepts();
		model.addAttribute("dept",list);
		return "frontdesk/consult";
	}

	@GetMapping("/consult/{id}")
	@ResponseBody
	public Msg userConsult(@PathVariable("id") Integer id,@RequestParam(value = "pn",defaultValue = "1") Integer pn){
		List<Department> list = deptService.getDepts();
		PageHelper.startPage(pn,3);
		Department departmentList = appointDoctorWithDeptService.getDeptAll(id);
		String http = "http://127.0.0.1:8082";
		for (Doctor deptList : departmentList.getDoctors()) {
			deptList.setDoctorPhotoSrc(http + deptList.getDoctorPhotoSrc());
		}
		List<Department> list1 = new LinkedList<>();
		list1.add(departmentList);
		PageInfo<Department> page = new PageInfo<>(list1, 5);
		System.out.println(list1);
		return Msg.success().add("departmentList",page).add("dept",list);
	}

	@GetMapping("/deptWithDoct/{id}")
	public String deptWithDoct(@PathVariable("id") Integer id, Model model){
		List<Doctor> doctors = doctorService.getDoctorsByDoctorId(id);
		model.addAttribute("doctors", doctors);
		return "frontdesk/consultDoct";
	}

//	@PostMapping("/appointFinish/${id}")
//	@ResponseBody
//	public Msg appointFinish(@PathVariable("id") Integer id){
//
//	}

//	@GetMapping("/doctAppoint/{id}}")
//	public String doctAppoint(){
//		return "frontdesk/consultDoct";
//	}

	@GetMapping("/chat")
	public String userchat(Model model){
		List<Department> deptList = deptService.getDepts();
		model.addAttribute("deptLists",deptList);
		return "frontdesk/chat";
	}

	@GetMapping("/community")
	public String usercommunity(Model model){
		List<Department> list = deptService.getDepts();
		List<Questions> questionsList = questionService.getAllQuestions();
		model.addAttribute("dept",list);
		model.addAttribute("question",questionsList);
		System.out.println(questionsList);
		return "frontdesk/community";
	}

	@GetMapping("/communityDetails/{id}")
	public String communityDetails(@PathVariable("id") Integer id, Model model){
		Questions questions = questionService.QuestionsCommentById(id);
		model.addAttribute("questions",questions);

		/*同步锁*/
//		int num=1;
//		synchronized (this){
//			num--;
//		}

		System.out.println(questions);
		return "frontdesk/CommunityDetails";
	}

	@PostMapping("/commentMessage")
	@ResponseBody
	public Msg commentMessage(String content,String qid, String date,Comment comment){
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String username = (String) session.getAttribute("realname");
		User user = regService.queryuserbyid(username);
		comment.setCommentQuestionId(qid);
		comment.setCommentUserId(String.valueOf(user.getId()));
		comment.setCommentContent(content);
		comment.setCommentTime(date);
		System.out.println(comment);
		commentService.InsertComments(comment);
		return Msg.success().add("comment",comment);
	}

	@PostMapping("/flashComment")
	@ResponseBody
	public Msg flashComment(@RequestParam int qid){
		Questions comment = questionService.QuestionsCommentById(qid);
		return Msg.success().add("comment",comment);
	}

	@PostMapping("/appoint")
    @ResponseBody
	public Msg addAppoint(Appoint appoint){
	    appointService.insert(appoint);
	    return Msg.success();
    }


	/**
	 * 主页上的名医简介
	 * @return Msg
	 */
	@RequestMapping(value="/famous_dr",method=RequestMethod.GET)
	@ResponseBody
	public Msg famDr(){
		List<Famous_Doctor> famdoctorlist = famdoctorService.getAll();
		String http = "http://127.0.0.1:8082";
		for (Famous_Doctor famousDoctor : famdoctorlist) {
			famousDoctor.setDrphotosrc(http+famousDoctor.getDrphotosrc());
		}
		return Msg.success().add("famdoctor", famdoctorlist);
	}


	/**
	 * 用户注册页面
	 * @return String
	 */
	@RequestMapping("/to_reg")
	public String toReg(){
		return "frontdesk/userreg";
	}

    /**
     * 用户注册过程
     * @param user 用户
     * @return Msg
     */
	@RequestMapping("/reg")
	@ResponseBody
	public Msg userReg(User user){
		regService.reg(user);
		return Msg.success();
	}

    /**
     * 用户注册成功去登录页面
     * @return String
     */
	@RequestMapping("/to_login")
	public String toLogin(){
		return "frontdesk/userlogin";
	}

    /**
     * 用户登录过程
     * @param user 用户
     * @return Msg
     */
	@ResponseBody
	@PostMapping("/userlogin")
	public Msg userlogin(User user){
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		user = regService.queryuser(user);
		if(user != null){
			session.setAttribute("realname", user.getRealname());
			return Msg.success();
		}else{
			return Msg.fail();
		}
	}

	@PostMapping("/logout")
	@ResponseBody
	public Msg logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return Msg.success();
	}
}
