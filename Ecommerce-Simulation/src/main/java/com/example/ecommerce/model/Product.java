package com.example.ecommerce.model;

public class Product {
    private int id;
    private String name;
    private double price;

    // Constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // ✅ Add this getter
    public int getId() {
        return id;
    }

    // Optional: Add other getters if needed
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
