package codegym.blogApp.service.impl;

import codegym.blogApp.entity.Category;
import codegym.blogApp.repository.ICategoryRepo;
import codegym.blogApp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }
}
