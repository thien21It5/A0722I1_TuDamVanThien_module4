package codegym.blogApp.service;

import codegym.blogApp.entity.Category;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    List<Category> findAll();
}
