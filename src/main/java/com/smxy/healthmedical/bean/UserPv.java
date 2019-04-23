package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/24
 * Time 16:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPv {
    private Integer pvId;
    private String pvIp;
    private String pvHomeLocation;
    private String pvUserName;
    private String pvTime;
    private Integer pvBaojianSum;
    private Integer pvYangShengSum;
    private Integer pvYufangSum;
    private Integer pvCustomizationSum;
    private Integer pvChatSum;
    private Integer pvConsultSum;
    private Integer pvCommunitySum;
    private Integer pvXinxueSum;
    private Integer pvXiaohuaSum;
    private Integer pvZhongyiSum;
    private Integer pvYiliaobaojianSum;
    private Integer pvXueyeSum;
    private Integer pvGandanSum;
    private Integer pvPuwaiSum;
    private Integer pvXinxiongSum;
    private Integer pvMiniaoSum;
    private Integer pvJiaoxingSum;
    private Integer pvShenjingSum;
    private Integer pvZhongliuSum;
    private Integer num;
}
