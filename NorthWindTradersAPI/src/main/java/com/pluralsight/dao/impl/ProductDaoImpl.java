package com.pluralsight.dao.impl;

import com.pluralsight.dao.ProductDao;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl implements ProductDao {

    private final DataSource dataSource;

    @Autowired
    public ProductDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();
        try(Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    Product product = new Product();
                    product.setProductId(resultSet.getInt("id"));
                    product.setProductName(resultSet.getString("name"));
                    product.setCategoryId(resultSet.getInt("category_id"));
                    product.setUnitPrice(resultSet.getDouble("price"));
                    products.add(product);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    @Override
    public Optional<Product> getProductById(int id) {

        try(Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE ProductID = ?")) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    Product product = new Product();
                    product.setProductId(resultSet.getInt("id"));
                    product.setProductName(resultSet.getString("name"));
                    product.setCategoryId(resultSet.getInt("category_id"));
                    product.setUnitPrice(resultSet.getDouble("price"));
                    return Optional.of(product);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }
}
