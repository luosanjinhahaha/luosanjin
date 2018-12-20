package com.smxy.healthmedical.realm;

import com.smxy.healthmedical.bean.Doctor;
import com.smxy.healthmedical.bean.Permission;
import com.smxy.healthmedical.bean.Role;
import com.smxy.healthmedical.service.AdminService;
import com.smxy.healthmedical.service.DoctorRoleService;
import com.smxy.healthmedical.service.DoctorService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/9
 * Time 22:19
 */
public class DoctorShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorShiroRealm.class);

    @Autowired
    @Lazy
    DoctorService doctorService;

    @Autowired
    @Lazy
    AdminService adminService;
    /**
     * 医师授权
     * @param principalCollection principalCollection
     * @return simpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        doctorAuthorization(principalCollection, simpleAuthorizationInfo, doctorService, adminService);
        AdminShiroRealm.adminAuthorization(principalCollection, simpleAuthorizationInfo, adminService);
        return simpleAuthorizationInfo;
    }
    static void doctorAuthorization(PrincipalCollection principalCollection, SimpleAuthorizationInfo simpleAuthorizationInfo, DoctorService doctorService, AdminService adminService){
        if (principalCollection.getPrimaryPrincipal() instanceof Doctor){
            Doctor doctor = (Doctor) principalCollection.getPrimaryPrincipal();
            for (Role role : doctorService.getDoctorRoles(doctor.getDoctorId()) ) {
                simpleAuthorizationInfo.addRole(role.getRoleName());
                for (Permission doctorPermission : doctorService.verifyDoctorPermission(doctor.getDoctorId())) {
                    simpleAuthorizationInfo.addStringPermission(doctorPermission.getPermissionName());
                }
            }
        }
    }

    /**
     * 医师身份验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        LOGGER.info("开始Doctor身份认证...");

        UserToken userToken = (UserToken) authenticationToken;

        /*获取用户名，默认和login.html中的adminName对应*/
        String doctorName = userToken.getUsername();

        return null;
    }
}
