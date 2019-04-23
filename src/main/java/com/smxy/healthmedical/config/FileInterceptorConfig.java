package com.smxy.healthmedical.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class FileInterceptorConfig implements HandlerInterceptor {
    /**
     *
     * @param request 拦截的请求
     * @param response 请求的相应
     * @param handler 拦截
     * @return false拦截，true通过
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("executor....");

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartHttpServletRequest.getFile("file");
            if (file.getSize() == 0L) {
                response.sendError(400, "文件为空文件请重新上传");
                return false;
            }else if (file.getSize() > 1048576L || file.getSize() == 1048576L) {
                response.sendError(400, "文件过大上传失败");
                return false;
            }
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
