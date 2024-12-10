package com.pluralsight.northwindtraders.service.imple;

import com.pluralsight.northwindtraders.model.Product;
import com.pluralsight.northwindtraders.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiciImple implements ProductService {

    /**
     * @param product
     * @return
     */
    @Override
    public boolean createProduct(Product product) {
        return false;
    }

    /**
     * @param id
     * @param product
     * @return
     */
    @Override
    public Optional<Product> updateProduct(int id, Product product) {
        return Optional.empty();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Product> deleteProduct(int id) {
        return Optional.empty();
    }

    /**
     * @return
     */
    @Override
    public List<Product> listProducts() {
        return List.of();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Product> getProductById(int id) {
        return Optional.empty();
    }
}
