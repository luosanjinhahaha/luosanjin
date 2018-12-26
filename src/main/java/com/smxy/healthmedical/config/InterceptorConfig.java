package com.smxy.healthmedical.config;

import com.smxy.healthmedical.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IDEA
 * @author luoxin
 * Date:2018/10/19
 * Time:21:34
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/user/**")
                .excludePathPatterns("/user/index","/user/to_login","/user/mailsender","/user/to_reg","/user/reg","/user/userlogin","/user/havesession");
    }
}
