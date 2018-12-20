package com.smxy.healthmedical.realm;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created with IDEA
 *创建一个UsernamePasswordToken的子类，用来标识登录的用户类型
 * @author Luoxin
 * Date 2018/12/10
 * Time 13:39
 */
@Getter
@Setter
public class UserToken extends UsernamePasswordToken {

    /*登录类型，判断是医师登录还是管理员登录*/
    private String userType;

    public UserToken(final String username,final String password, String userType){
        super(username, password);
        this.userType = userType;
    }
}
