package com.pluralsight.dao;

import com.pluralsight.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    List<Category> getAllCategories();
    Optional<Category> getCategoryById(int id);
    boolean addCategory(Category category);
    boolean updateCategory(int id, Category category);
    boolean deleteCategory(int id);
}
