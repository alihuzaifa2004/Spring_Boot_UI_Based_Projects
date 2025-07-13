package com.example.ecommerce.service;

import com.example.ecommerce.model.*;
import com.example.ecommerce.structure.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationService {

    private final UserArray users = new UserArray();
    private final InventoryLinkedList inventory = new InventoryLinkedList();
    private final OrderQueue orders = new OrderQueue();
    private final ProductBST bst = new ProductBST();
    private final OrderGraph graph = new OrderGraph();

    // Auto-increment counters
    private int userIdCounter = 1;
    private int productIdCounter = 1;

    public User addUser(String name) {
        User newUser = new User(userIdCounter++, name);
        users.addUser(newUser);
        return newUser;
    }

    public Product addProduct(String name, double price) {
        Product newProduct = new Product(productIdCounter++, name, price);
        inventory.addProduct(newProduct);
        bst.insert(newProduct);
        return newProduct;
    }

    public boolean placeOrder(int userId, int productId, String email, String phone) {
        if (users.getUser(userId) == null || inventory.getProductById(productId) == null) {
            return false;
        }
        Product product = inventory.getProductById(productId);
        Order order = new Order(userId, product, email, phone);
        orders.enqueue(order);
        graph.addOrder(userId, order);
        return true;
    }

    public List<Order> getUserOrders(int userId) {
        return graph.getOrders(userId);
    }

    public Product[] getAllProducts() {
        return inventory.getAllProducts();
    }

    public List<Product> getSortedProducts() {
        return bst.getSortedProducts();
    }

    public boolean removeUser(int userId) {
        if (users.getUser(userId) == null) return false;
        users.removeUser(userId);
        graph.removeUser(userId);
        return true;
    }

    public List<User> getAllUsers() {
        return users.getAllUsers();
    }
}
