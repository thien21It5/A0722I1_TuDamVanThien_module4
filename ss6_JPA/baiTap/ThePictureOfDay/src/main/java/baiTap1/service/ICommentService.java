package baiTap1.service;

import baiTap1.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void save(Comment comment);
    void remove(Integer id);
    Comment finById(Integer id);
    void update(Comment comment);
    List<Comment> findToDay();
    void like(Integer id);
}
