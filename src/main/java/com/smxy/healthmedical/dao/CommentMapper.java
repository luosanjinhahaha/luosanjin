package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Comment;

import java.util.List;

/**
 * Created with IDEA
 * @author:Luoxin
 * Date:2018/10/23
 * Time:15:04
 */
public interface CommentMapper {
    List<Comment> getCommentAll(int id);
    void InsertComment(Comment comment);
}
