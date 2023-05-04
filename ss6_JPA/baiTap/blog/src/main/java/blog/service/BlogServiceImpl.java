package blog.service;

import blog.entity.Blog;
import blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id);
    }

    @Override
    public void delete(int id) {
        blogRepo.delete(id);
    }

}
