package blog.repository;

import blog.entity.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class BlogRepo implements IBlogRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        return entityManager.createQuery("select b from Blog b").getResultList();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            entityManager.persist(blog);
        } else {
            entityManager.merge(blog);
        }
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void delete(int id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }

}
