package baiTap1.service;

import baiTap1.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> show();

    void create(Product product);

    void delete(Product product);

    void update(Product product);

    Product detail(int id);

    List<Product> search(String name);
}
