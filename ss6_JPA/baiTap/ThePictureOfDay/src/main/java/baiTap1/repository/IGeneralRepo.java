package baiTap1.repository;

import baiTap1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGeneralRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findAll();

    Comment deleteByAuthorAndAndDate(Comment comment);
}
