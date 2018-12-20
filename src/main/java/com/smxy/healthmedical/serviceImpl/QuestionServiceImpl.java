package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Questions;
import com.smxy.healthmedical.dao.QuestionMapper;
import com.smxy.healthmedical.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * @author:Luoxin
 * Date:2018/10/23
 * Time:13:19
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Override
    public List<Questions> getAllQuestions() {
        return questionMapper.getQuestionsAll();
    }

    @Override
    public Questions QuestionsCommentById(Integer id) {
        return questionMapper.getQuestionsCommentById(id);
    }

}
