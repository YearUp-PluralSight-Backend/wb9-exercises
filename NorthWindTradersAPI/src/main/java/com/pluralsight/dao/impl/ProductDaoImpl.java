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
                    product.setProductId(resultSet.getInt("ProductID"));
                    product.setProductName(resultSet.getString("ProductName"));
                    product.setCategoryId(resultSet.getInt("CategoryID"));
                    product.setUnitPrice(resultSet.getDouble("UnitPrice"));
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
                    product.setProductId(resultSet.getInt("ProductID"));
                    product.setProductName(resultSet.getString("ProductName"));
                    product.setCategoryId(resultSet.getInt("CategoryID"));
                    product.setUnitPrice(resultSet.getDouble("UnitPrice"));
                    return Optional.of(product);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public boolean addProduct(Product product) {

            try(Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?)")) {
                preparedStatement.setString(1, product.getProductName());
                preparedStatement.setInt(2, product.getCategoryId());
                preparedStatement.setDouble(3, product.getUnitPrice());
                return preparedStatement.executeUpdate() > 0;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return false;
    }

    @Override
    public boolean updateProduct(int id, Product product) {

        try(Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET ProductName = ?, CategoryID = ?, UnitPrice = ? WHERE ProductID = ?")) {

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.setDouble(3, product.getUnitPrice());
            preparedStatement.setInt(4, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean deleteProduct(int id) {

            try(Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE ProductID = ?")) {

                preparedStatement.setInt(1, id);
                return preparedStatement.executeUpdate() > 0;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return false;
    }
}
