package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/11
 * Time 16:48
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Permission {
    private Integer permissionId;
    private String permissionName;
    private String permissionDescription;
}
