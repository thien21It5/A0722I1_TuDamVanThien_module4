package codegym.blogApp.service;

import codegym.blogApp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T>{
    Page<T> findAll(Pageable pageable);

    void save(T t);

    T findById(int id);

    void delete(int id);
}
