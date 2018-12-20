package com.smxy.healthmedical.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.sf.jsqlparser.statement.select.Pivot;

import java.util.List;

/**
 * Created with IDEA
 * author:Luoxin
 * Date:2018/10/23
 * Time:12:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Questions {
    private String questionId;
    private String questionName;
    private String questionContent;
    private String questionTime;
    private String userId;
    private User user;
    private List<Comment> comment;
}
