package com.pluralsight.northwindtraders.model;

import org.springframework.context.annotation.Bean;

import java.util.Objects;

public class Product {

    private int productId;
    private String productName;
    private String description;
    private double price;

    public Product() {
    }

    public Product(int productId, String productName, String description, double price) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getProductId() == product.getProductId() && Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getDescription(), product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getDescription(), getPrice());
    }
}
