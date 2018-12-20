package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/11
 * Time 19:13
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolePermission implements Serializable {
    private Integer rolePermissionId;
    private Integer roleId;
    private Integer permissionId;
    private Role role;
    private Permission permission;
}
