package com.pluralsight.controller;


import com.pluralsight.dao.impl.ProductDaoImpl;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductDaoImpl productDao;

    @Autowired
    ProductController(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/list")
    public List<Product> list() {
        return productDao.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDao.getProductById(id).isPresent() ? productDao.getProductById(id).get() : null;
    }
}
