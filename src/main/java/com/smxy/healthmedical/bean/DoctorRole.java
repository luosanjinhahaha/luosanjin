package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/11/30
 * Time 20:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorRole implements Serializable {
    private Integer doctorRoleId;
    private Integer doctorId;
    private Integer roleId;
    private Doctor doctor;
    private Role role;
}
