package blog.repository;

import blog.entity.Blog;

import java.util.List;

public interface IBlogRepo {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void delete(int id);
}
