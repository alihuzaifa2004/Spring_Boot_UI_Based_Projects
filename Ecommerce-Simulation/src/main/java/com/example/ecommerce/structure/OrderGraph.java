package com.example.ecommerce.structure;

import com.example.ecommerce.model.Order;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OrderGraph {
    private Map<Integer, List<Order>> graph = new HashMap<>();

    public void addOrder(int userId, Order order) {
        graph.computeIfAbsent(userId, k -> new LinkedList<>()).add(order);
    }

    public List<Order> getOrders(int userId) {
        return graph.getOrDefault(userId, new LinkedList<>());
    }

    public void removeUser(int userId) {
        graph.remove(userId);
    }
}