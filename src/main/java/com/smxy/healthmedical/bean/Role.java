package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/12
 * Time 10:46
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDescription;
    private List<RolePermission> RolePermissions;
}
