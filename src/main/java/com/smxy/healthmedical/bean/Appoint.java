package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IDEA
 * @author:Luoxin
 * Date:2018/10/18
 * Time:14:02
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Appoint {
    private Integer appointId;
    private String appointDeptname;
    private String appointDrname;
    private String appointDate;
    private String appointTime;
    private String appointName;
    private String appointPhone;
    private String appointEmail;
    private String appointContent;
    private Department department;
    private Doctor doctor;
}
