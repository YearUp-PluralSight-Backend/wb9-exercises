package com.pluralsight.controller;


import com.pluralsight.dao.CategoryDao;
import com.pluralsight.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryDao categoryDao;

    @Autowired
    CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/list")
    public List<Category> list() {
        return categoryDao.getAllCategories();
    }
}
