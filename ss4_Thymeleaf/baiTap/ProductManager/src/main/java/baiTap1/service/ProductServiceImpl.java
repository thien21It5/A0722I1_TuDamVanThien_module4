package baiTap1.service;

import baiTap1.entity.Product;
import baiTap1.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public List<Product> show() {
        return productRepo.showProduct();
    }

    @Override
    public void create(Product product) {
        productRepo.createProduct(product);
    }

    @Override
    public void delete(Product product) {
        productRepo.deleteProduct(product);
    }

    @Override
    public void update(Product product) {
        productRepo.updateProduct(product);
    }

    @Override
    public Product detail(int id) {
        return productRepo.showProductById(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepo.searchProduct(name);
    }
}
