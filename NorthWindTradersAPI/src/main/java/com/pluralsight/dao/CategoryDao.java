package com.pluralsight.dao;

import com.pluralsight.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    List<Category> getAllCategories();
    Optional<Category> getCategoryById(int id);
}
