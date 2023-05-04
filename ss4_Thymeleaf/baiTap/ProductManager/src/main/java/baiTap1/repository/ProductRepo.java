package baiTap1.repository;

import baiTap1.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepo implements IProductRepo {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Car", 10000, "Nice", "Toyota"));
        products.put(2, new Product(2, "Bike", 20000, "Nice", "Giant"));
        products.put(3, new Product(3, "Train", 30000, "Nice", "German"));
        products.put(4, new Product(4, "Plane", 40000, "Nice", "VietNam Airline"));
        products.put(5, new Product(5, "Ship", 50000, "Nice", "Titanic"));
    }


    @Override
    public List<Product> showProduct() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void createProduct(Product product) {
        if (!products.containsKey(product.getId())) {
            products.put(product.getId(), product);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        if (products.containsKey(product.getId())) {
            products.remove(product.getId(), product);
        }
    }

    @Override
    public void updateProduct(Product product) {
        if (products.containsKey(product.getId())) {
            products.put(product.getId(), product);
        }
    }

    @Override
    public Product showProductById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> searchProduct(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
