package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPreference {
    private Integer uPId;
    private String username;
    private String preferenceNum;
    private UserPv userPv;
}
