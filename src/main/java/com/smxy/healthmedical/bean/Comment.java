package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created with IDEA
 * author:Luoxin
 * Date:2018/10/23
 * Time:15:05
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Comment {
    private String commentId;
    private String commentQuestionId;
    private String commentUserId;
    private String commentContent;
    private String commentTime;
    private User user;
}
