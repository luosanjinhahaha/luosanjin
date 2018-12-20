package com.smxy.healthmedical.realm;

import com.smxy.healthmedical.bean.AdminUsers;
import com.smxy.healthmedical.bean.Permission;
import com.smxy.healthmedical.bean.Role;
import com.smxy.healthmedical.service.AdminService;
import com.smxy.healthmedical.service.DoctorService;
import com.smxy.healthmedical.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class AdminShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminShiroRealm.class);

    @Autowired
    @Lazy
    private LoginService loginService;

    @Autowired
    @Lazy
    AdminService adminService;

    @Autowired
    @Lazy
    DoctorService doctorService;

    /**
     * 描述：角色授权
     * @param principalCollection ""
     * @return ""
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println(123);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        adminAuthorization(principalCollection, simpleAuthorizationInfo, adminService);
        DoctorShiroRealm.doctorAuthorization(principalCollection, simpleAuthorizationInfo, doctorService,adminService);
        return simpleAuthorizationInfo;
    }
    static void adminAuthorization(PrincipalCollection principalCollection, SimpleAuthorizationInfo simpleAuthorizationInfo, AdminService adminService){
        if(principalCollection.getPrimaryPrincipal() instanceof AdminUsers){
            AdminUsers adminUsers = (AdminUsers) principalCollection.getPrimaryPrincipal();
            for(Role role: adminService.getAdminRoleByAdminId(adminUsers.getAdminId())){
                LOGGER.info("&**&&&&&&&*&*&" + role.getRoleName());
                simpleAuthorizationInfo.addRole(role.getRoleName());
                for (Permission permission : adminService.verifyPermission(adminUsers.getAdminId())) {
                    simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
                }
            }
        }
    }


    /**
     * 描述：角色验证
     * @param authenticationToken ""
     * @return SimpleAuthenticationInfo
     * @throws AuthenticationException ""
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UserToken token = (UserToken) authenticationToken;
        String adminName = token.getUsername();
        AdminUsers dbAdminUser = loginService.getAdminByName(adminName);
        System.out.println(dbAdminUser);
        LOGGER.info(dbAdminUser.toString());
        if(dbAdminUser == null){
            return null;
        }
        return new SimpleAuthenticationInfo(dbAdminUser,dbAdminUser.getAdminPassword(),"");
    }
}
