package com.pluralsight.dao.impl;

import com.pluralsight.dao.CategoryDao;
import com.pluralsight.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryDaoImpl implements CategoryDao {


    private final DataSource dataSource;

    @Autowired
    public CategoryDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {

        List<Category> categories = new ArrayList<>();
        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM categories")) {
            try (var resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    Category category = new Category();
                    category.setCategoryId(resultSet.getInt("id"));
                    category.setCategoryName(resultSet.getString("name"));
                    categories.add(category);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return categories;
    }

    @Override
    public Optional<Category> getCategoryById(int id) {

        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM categories WHERE CategoryID" +
                " = ?")) {
            preparedStatement.setInt(1, id);
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Category category = new Category();
                    category.setCategoryId(resultSet.getInt("id"));
                    category.setCategoryName(resultSet.getString("name"));
                    return Optional.of(category);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();

    }

}
