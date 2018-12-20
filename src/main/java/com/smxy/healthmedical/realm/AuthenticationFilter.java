package com.smxy.healthmedical.realm;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/11
 * Time 11:11
 */
public class AuthenticationFilter extends FormAuthenticationFilter {

    private static final String ADMIN_USERTYPE = UserType.ADMIN.toString();

    private static final String DOCTOR_USERTYPE = UserType.DOCTOR.toString();

    protected UserToken createToken(ServletRequest request, ServletResponse response){
        String username = getUsername(request);
        String password = getPassword(request);
        String userType = request.getParameter("userType");
        if(ADMIN_USERTYPE.equals(userType)){
            return new UserToken(username,password,ADMIN_USERTYPE);
        }else{
            return new UserToken(username,password,DOCTOR_USERTYPE);
        }
    }

}
