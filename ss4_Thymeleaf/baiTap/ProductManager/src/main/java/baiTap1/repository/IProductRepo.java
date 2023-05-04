package baiTap1.repository;

import baiTap1.entity.Product;

import java.util.List;

public interface IProductRepo {

    List<Product> showProduct();

    void createProduct(Product product);

    void deleteProduct(Product product);

    void updateProduct(Product product);

    Product showProductById(int id);

    List<Product> searchProduct(String name);
}
