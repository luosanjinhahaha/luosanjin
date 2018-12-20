package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IDEA
 * @author Luoxin
 * Date:2018/10/18
 * Time:13:58
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor {
    private Integer doctorId;
    private String doctorName;
    private String doctorGender;
    private String doctorPhotoSrc;
    private String doctorIntro;
    private String dId;
    private String dTipsDoctorId;
    private Department department;
    private List<DoctorRole> doctorRoles;
    private List<DoctorTips> doctorTips;
}
