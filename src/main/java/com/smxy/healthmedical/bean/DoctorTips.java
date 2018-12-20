package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/7
 * Time 10:34
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorTips {
    private Integer doctorTipsId;
    private String doctorTipsDoctorId;
    private String doctorTipsTime;
    private String doctorTipsName;
    private String doctorTipsDescription;
    private String doctorTipsLike;
}
