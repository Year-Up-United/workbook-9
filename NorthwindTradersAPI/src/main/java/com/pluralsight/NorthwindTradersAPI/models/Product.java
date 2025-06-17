package com.pluralsight.NorthwindTradersAPI.models;

import java.io.Serializable;

public class Product implements Serializable {

    private int ProductId;
    private String productName;
    private int categoryId;
    private  double price;

    public Product(){
        // do nothing
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", productName='" + productName + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                '}';
    }

    public Product(int productId, String productName, int categoryId, double price) {
        ProductId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;



    }
}
