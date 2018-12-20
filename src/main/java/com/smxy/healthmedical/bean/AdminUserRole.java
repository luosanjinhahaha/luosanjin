package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/14
 * Time 21:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminUserRole implements Serializable {
    private int adminRoleId;
    private int adminId;
    private int roleId;
    private AdminUsers adminUsers;
    private Role role;
}
