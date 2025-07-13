package com.example.ecommerce.model;

import com.example.ecommerce.model.Product;

public class Order {
    public int userId;
    public Product product;
    public String email;
    public String phone;

    public Order(int userId, Product product, String email, String phone) {
        this.userId = userId;
        this.product = product;
        this.email = email;
        this.phone = phone;
    }
}
