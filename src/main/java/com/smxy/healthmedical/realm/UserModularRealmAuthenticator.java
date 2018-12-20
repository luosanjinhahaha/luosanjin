package com.smxy.healthmedical.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IDEA
 * 当配置了多个Realm时，我们通常使用的认证器是shiro自带的org.apache.shiro.authc.pam.ModularRealmAuthenticator，
 * 其中决定使用的Realm的是doAuthenticate()方法
 * @author Luoxin
 * Date 2018/12/10
 * Time 14:05
 */
public class UserModularRealmAuthenticator extends ModularRealmAuthenticator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserModularRealmAuthenticator.class);

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("UserModularRealmAuthenticator:method doAuthenticate() execute ");

        /*判断getRealms()是否返回为空*/
        assertRealmsConfigured();

        /*强制转换回自定义的CustomizedToken*/
        UserToken userToken = (UserToken) authenticationToken;

        /*登录类型*/
        String userType = userToken.getUserType();
        LOGGER.info(userType + "------>" + userType);

        /*所有的realm*/
        Collection<Realm> realms = getRealms();
        LOGGER.info(realms.toString());

        /*登录类型对应的所有Realm*/
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            LOGGER.info(realm.getName());
            if (realm.getName().contains(userType)){
                typeRealms.add(realm);
            }
        }
        /*判断是单Realm还是多Realm*/
        if (typeRealms.size() == 1){
            LOGGER.info("doSingleRealmAuthentication() execute ");
            return doSingleRealmAuthentication(typeRealms.iterator().next(), userToken);
        }else{
            LOGGER.info("doMultiRealmAuthentication() execute ");
            LOGGER.info(typeRealms.toString());
            return doMultiRealmAuthentication(typeRealms, userToken);
        }
    }
}
