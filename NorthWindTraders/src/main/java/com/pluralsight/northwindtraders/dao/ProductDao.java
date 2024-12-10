package com.pluralsight.northwindtraders.dao;

import com.pluralsight.northwindtraders.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    boolean createProduct(Product product);
    Optional<Product> updateProduct(int id, Product product);
    Optional<Product> deleteProduct(int id);
    List<Product> listProducts();
    Optional<Product>  getProductById(int id);
}
