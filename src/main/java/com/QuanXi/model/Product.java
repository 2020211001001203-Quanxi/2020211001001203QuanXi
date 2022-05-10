package com.QuanXi.model;

import java.io.InputStream;

public class Product {
    private int productId;
    private String productName;
    private String getProductName;
    private InputStream picture;
    private double price;
    private int categoryId;
    private String productDescription;

    public Product() {

    }

    public Product(int productId, String productName, String getProductName, InputStream picture, double price, int categoryId, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.getProductName = getProductName;
        this.picture = picture;
        this.price = price;
        this.categoryId = categoryId;
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", getProductName='" + getProductName + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", categoryId=" + categoryId +
                ", productDescription='" + productDescription + '\'' +
                '}';
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

    public String getGetProductName() {
        return getProductName;
    }

    public void setGetProductName(String getProductName) {
        this.getProductName = getProductName;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
