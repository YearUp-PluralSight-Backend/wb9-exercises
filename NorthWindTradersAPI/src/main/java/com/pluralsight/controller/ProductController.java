package com.pluralsight.controller;


import com.pluralsight.dao.impl.ProductDaoImpl;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
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

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDao.getProductById(id).isPresent() ? productDao.getProductById(id).get() : null;
    }

    @PostMapping("/add")
    public Boolean addProduct(@RequestBody Product product) {
        return productDao.addProduct(product);
    }

    @PutMapping("/update/{id}")
    public Boolean updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productDao.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable int id) {
        return productDao.deleteProduct(id);
    }
}
