package com.pluralsight.controller;


import com.pluralsight.dao.CategoryDao;
import com.pluralsight.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao categoryDao;

    @Autowired
    CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/list")
    public List<Category> list() {
        return categoryDao.getAllCategories();
    }

    @GetMapping("/get/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryDao.getCategoryById(id).orElse(null);
    }

    @PostMapping("/add")
    public boolean addCategory(@RequestBody Category category) {
        return categoryDao.addCategory(category);
    }



    @PutMapping("/update/{id}")
    public boolean updateCategory(@PathVariable int id, @RequestBody Category category) {
        return categoryDao.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCategory(@PathVariable int id) {
        return categoryDao.deleteCategory(id);
    }
}
