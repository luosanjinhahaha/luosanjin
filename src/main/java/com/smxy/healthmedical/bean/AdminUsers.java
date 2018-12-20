package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminUsers {
    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private String adminRealname;

    private List<AdminUserRole> adminUserRoles;
}
