package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/29
 * Time 10:02
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PushContent {
    private Integer pushId;
    private String pushTitle;
    private String pushContent;
    private Integer pushTypeId;
}
