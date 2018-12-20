package com.smxy.healthmedical.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FileTypeInterceptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		//在该方法上进行上传文件类型限制
		if(arg0 instanceof MultipartHttpServletRequest){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)arg0;
			MultipartFile file = multiRequest.getFile("file");
			String fileName = file.getOriginalFilename();
			String fileTypes = "jpg,txt,rar,png,xls";
			String fileType = fileName.substring(fileName.indexOf(".")+1);
			if(fileTypes.contains(fileType)){
				return true;
			}
			else{
				arg0.setAttribute("msg", "文件类型不允许！");
				arg0.getRequestDispatcher("/medical/admin/to_main").forward(arg0, arg1);
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
