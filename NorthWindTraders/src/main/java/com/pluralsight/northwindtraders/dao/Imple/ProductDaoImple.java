package com.pluralsight.northwindtraders.dao.Imple;

import com.pluralsight.northwindtraders.dao.ProductDao;
import com.pluralsight.northwindtraders.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoImple implements ProductDao {

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
