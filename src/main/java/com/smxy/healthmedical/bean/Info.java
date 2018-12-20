package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pinfoId;

    private String pinfoName;
    
    private String pinfoAge;

    private String pinfoGender;

    private String ppinfoIllname;

    private String pinfoInfo;

    private Integer piId;
    
    private Department department;
}