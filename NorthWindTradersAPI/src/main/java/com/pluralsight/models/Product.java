package com.pluralsight.models;

import java.util.Objects;

public class Product {

    private int productId;
    private String productName;
    private int categoryId;
    private double unitPrice;

    public Product() {
    }

    public Product(int productId, String productName, int categoryId, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getProductId() == product.getProductId() && getCategoryId() == product.getCategoryId() && Double.compare(getUnitPrice(), product.getUnitPrice()) == 0 && Objects.equals(getProductName(), product.getProductName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getCategoryId(), getUnitPrice());
    }
}
