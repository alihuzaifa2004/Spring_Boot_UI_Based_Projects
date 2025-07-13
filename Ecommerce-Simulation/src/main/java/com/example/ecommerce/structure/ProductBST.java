package com.example.ecommerce.structure;

import com.example.ecommerce.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductBST {
    private class Node {
        Product product;
        Node left, right;

        Node(Product product) {
            this.product = product;
        }
    }

    private Node root;

    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private Node insertRec(Node root, Product product) {
        if (root == null) return new Node(product);

        // Use getter for price here:
        if (product.getPrice() < root.product.getPrice()) {
            root.left = insertRec(root.left, product);
        } else {
            root.right = insertRec(root.right, product);
        }
        return root;
    }

    public List<Product> getSortedProducts() {
        List<Product> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node node, List<Product> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.product);
            inOrder(node.right, list);
        }
    }
}
