package blog.service;

import blog.entity.Blog;
import blog.repository.IBlogRepo;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void delete(int id);
}
