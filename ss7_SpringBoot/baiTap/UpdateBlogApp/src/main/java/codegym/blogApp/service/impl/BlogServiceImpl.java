package codegym.blogApp.service.impl;

import codegym.blogApp.entity.Blog;
import codegym.blogApp.repository.IBlogRepo;
import codegym.blogApp.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public Page<Blog> findByTitleContainingOrderByPublicDate(String title, Pageable pageable) {
        return blogRepo.findByTitleContainingOrderByPublicDate(title, pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        blogRepo.deleteById(id);
    }
}
