package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorAppoint {
    private int dAId;
    private String appintName;
    private String age;
    private String sex;
    private String appointTime;
    private String weekend;
    private String dId;
    private Integer doctorId;
    private String dockerName;
    {
        appointTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
