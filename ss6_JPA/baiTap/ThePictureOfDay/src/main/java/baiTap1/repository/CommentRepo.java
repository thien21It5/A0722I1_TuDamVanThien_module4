package baiTap1.repository;

import baiTap1.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class CommentRepo implements ICommentRepo {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Comment> findAll() {
        return entityManager.createQuery("select c from Comment c").getResultList();
    }

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public void remove(Integer id) {
        entityManager.remove(finById(id));
    }

    @Override
    public Comment finById(Integer id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public void update(Comment comment) {
        entityManager.merge(comment);
    }

    @Override
    public List<Comment> findToDay() {
        return entityManager.createQuery("select c from Comment c where c.date = :today").setParameter("today", LocalDate.now()).getResultList();
    }

    @Override
    public void like(Integer id) {
        Comment comment = finById(id);
        comment.setLikes(comment.getLikes() + 1);
        update(comment);
    }
}
