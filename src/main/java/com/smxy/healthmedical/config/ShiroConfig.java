package com.smxy.healthmedical.config;

import com.smxy.healthmedical.realm.AuthenticationFilter;
import com.smxy.healthmedical.realm.DoctorShiroRealm;
import com.smxy.healthmedical.realm.AdminShiroRealm;
import com.smxy.healthmedical.realm.UserModularRealmAuthenticator;
import com.smxy.healthmedical.resolver.ExceptionResolver;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     * @param securityManager ""
     * @return shiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //关联SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        Map<String, Filter> filters = new LinkedHashMap<>();

        /*管理员认证过滤器*/
        AuthenticationFilter adminAuthenticationFilter = new AuthenticationFilter();
        adminAuthenticationFilter.setUsernameParam("adminName");
        adminAuthenticationFilter.setPasswordParam("adminPassword");
        adminAuthenticationFilter.setLoginUrl("/admin/background");
        filters.put("admin",adminAuthenticationFilter);

        /*医师认证过滤器*/
        AuthenticationFilter doctorAuthenticationFilter = new AuthenticationFilter();
        doctorAuthenticationFilter.setUsernameParam("doctorName");
        doctorAuthenticationFilter.setPasswordParam("doctorPassword");
        doctorAuthenticationFilter.setLoginUrl("/admin/background");
        filters.put("doctor",doctorAuthenticationFilter);

        /*认证过滤器*/
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/index","anon");
        filterMap.put("/admin/adminlogin","anon");
        filterMap.put("/admin/**","admin");
        filterMap.put("/doctor/**","doctor");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        shiroFilterFactoryBean.setFilters(filters);
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/unauthorized");
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     * @return securityManager
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        /*设置realm*/
        securityManager.setAuthenticator(modularRealmAuthenticator());

        /*关联Realm*/
        List<Realm> realms = new ArrayList<>();

        /*添加多个Realm*/
        realms.add(adminShiroRealm());
        realms.add(doctorShiroRealmRealm());
        securityManager.setRealms(realms);
        return securityManager;
    }

    /**
     * 系统自带的realm管理，主要针对realm
     * @return userModularRealmAuthenticator
     */
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){

        /*自己重写的ModularRealmAuthenticator*/
        UserModularRealmAuthenticator userModularRealmAuthenticator = new UserModularRealmAuthenticator();
        userModularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return userModularRealmAuthenticator;
    }

    @Bean
    public HandlerExceptionResolver handlerExceptionResolver(){
        ExceptionResolver exceptionResolver = new ExceptionResolver();
        return exceptionResolver;
    }

    /**
     * 配置shiro生命周期处理器
     * @return LifecycleBeanPostProcessor的实例;
     */
    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 自动创建代理类，若不添加，Shiro的注解可能不会生效。
     * @return defaultAdvisorAutoProxyCreator
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * 开启Shiro的注解
     * 如果不生效可能是AOP配置的问题
     * @return authorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 创建Realm
     * @return adminShiroRealm
     */
    @Bean
    public AdminShiroRealm adminShiroRealm(){
        AdminShiroRealm adminShiroRealm = new AdminShiroRealm();
        return adminShiroRealm;
    }

    /**
     * 医师自定义realm
     */
    @Bean
    public DoctorShiroRealm doctorShiroRealmRealm(){
        DoctorShiroRealm doctorShiroRealm = new DoctorShiroRealm();
        return doctorShiroRealm;
    }
}
