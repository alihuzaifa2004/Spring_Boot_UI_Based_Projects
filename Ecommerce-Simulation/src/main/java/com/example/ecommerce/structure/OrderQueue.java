package com.example.ecommerce.structure;

import com.example.ecommerce.model.Order;
import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> queue = new LinkedList<>();

    public void enqueue(Order order) {
        queue.add(order);
    }

    public Order dequeue() {
        return queue.poll();
    }

    public Queue<Order> getQueue() {
        return queue;
    }
}
