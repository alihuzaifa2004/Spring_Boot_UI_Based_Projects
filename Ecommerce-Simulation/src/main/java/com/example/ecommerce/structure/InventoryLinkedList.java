package com.example.ecommerce.structure;

import com.example.ecommerce.model.Product;

public class InventoryLinkedList {
    private class Node {
        Product product;
        Node next;
        Node(Product product) {
            this.product = product;
        }
    }

    private Node head;

    public void addProduct(Product product) {
        Node newNode = new Node(product);
        if (head == null) head = newNode;
        else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
    }

    public Product[] getAllProducts() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        Product[] result = new Product[count];
        current = head;
        for (int i = 0; i < count; i++) {
            result[i] = current.product;
            current = current.next;
        }
        return result;
    }

    // ✅ Add this method to support product lookup by ID
    public Product getProductById(int id) {
        Node current = head;
        while (current != null) {
            if (current.product.getId() == id) {
                return current.product;
            }
            current = current.next;
        }
        return null; // product not found
    }
}
