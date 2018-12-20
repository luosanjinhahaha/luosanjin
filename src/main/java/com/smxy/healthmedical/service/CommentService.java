package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Comment;

import java.util.List;

/**
 * Created with IDEA
 * @author:Luoxin
 * Date:2018/10/23
 * Time:19:01
 */
public interface CommentService {
    public List<Comment> getAllComment(int id);
    void InsertComments(Comment comment);
}
