package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Questions;

import java.util.List;

public interface QuestionService {
    List<Questions> getAllQuestions();
    Questions QuestionsCommentById(Integer id);
}
