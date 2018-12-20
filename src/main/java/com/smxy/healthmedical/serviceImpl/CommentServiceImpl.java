package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Comment;
import com.smxy.healthmedical.dao.CommentMapper;
import com.smxy.healthmedical.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * @author:Luoxin
 * Date:2018/10/23
 * Time:19:03
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> getAllComment(int id) {
        return commentMapper.getCommentAll(id);
    }

    @Override
    public void InsertComments(Comment comment) {
        commentMapper.InsertComment(comment);
    }

//    @Override
//    public int getNum(Integer id) {
//        return commentMapper.getCommentNum(id);
//    }
}
