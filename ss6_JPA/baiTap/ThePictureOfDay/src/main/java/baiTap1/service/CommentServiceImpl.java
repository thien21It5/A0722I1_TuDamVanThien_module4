package baiTap1.service;

import baiTap1.entity.Comment;
import baiTap1.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    private ICommentRepo iCommentRepo;

    @Autowired
    public CommentServiceImpl(ICommentRepo iCommentRepo) {
        this.iCommentRepo = iCommentRepo;
    }

    @Override
    public List<Comment> findAll() {
        return iCommentRepo.findAll();
    }

    @Override
    public void save(Comment comment) {
        iCommentRepo.save(comment);
    }

    @Override
    public void remove(Integer id) {
        iCommentRepo.remove(id);
    }

    @Override
    public Comment finById(Integer id) {
        return iCommentRepo.finById(id);
    }

    @Override
    public void update(Comment comment) {
        iCommentRepo.update(comment);
    }

    @Override
    public List<Comment> findToDay() {
        return iCommentRepo.findToDay();
    }

    @Override
    public void like(Integer id) {
        iCommentRepo.like(id);
    }
}
