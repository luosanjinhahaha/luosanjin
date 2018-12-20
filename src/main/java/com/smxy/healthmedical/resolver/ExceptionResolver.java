package com.smxy.healthmedical.resolver;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IDEA
 * shiro异常解析处理器
 * @author Luoxin
 * Date 2018/12/15
 * Time 23:42
 */
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if(e instanceof UnauthorizedException || e instanceof UnauthenticatedException){
            ModelAndView mv = new ModelAndView("error/unauthorized");
            return mv;
        }
        e.printStackTrace();
        ModelAndView mv = new ModelAndView("error/unauthorized");
        mv.addObject("exception", e.toString().replaceAll("\n", "<br/>"));
        return mv;
    }
}
