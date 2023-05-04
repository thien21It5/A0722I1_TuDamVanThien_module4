package baiTap1.repository;

import baiTap1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ICommentRepo {
    List<Comment> findAll();
    void save(Comment comment);
    void remove(Integer id);
    Comment finById(Integer id);
    void update(Comment comment);
    List<Comment> findToDay();
    void like(Integer id);
}
