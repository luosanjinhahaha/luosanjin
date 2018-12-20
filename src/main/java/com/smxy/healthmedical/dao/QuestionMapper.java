package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Questions;

import java.util.List;

/**
 *
 * 功能描述:
 * @author luoxin
 */
public interface QuestionMapper {
    /**
     * 查出所有话题
     * @return List<Questions>
     */
    List<Questions> getQuestionsAll();

    /**
     * 通过Id查出话题的评论
     * @param id 参数
     * @return Questions
     */
    Questions getQuestionsCommentById(Integer id);
}
