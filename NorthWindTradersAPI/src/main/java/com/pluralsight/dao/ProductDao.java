package com.pluralsight.dao;

import com.pluralsight.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Product> getAllProducts();
    Optional<Product> getProductById(int id);
    boolean addProduct(Product product);
    boolean updateProduct(int id, Product product);
    boolean deleteProduct(int id);
}
