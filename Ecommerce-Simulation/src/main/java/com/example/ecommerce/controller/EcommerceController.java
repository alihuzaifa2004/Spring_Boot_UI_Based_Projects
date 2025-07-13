package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class EcommerceController {

    @Autowired
    private SimulationService service;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(required = false) String message,
                        @RequestParam(required = false) String alertClass,
                        HttpSession session) {
        model.addAttribute("products", service.getAllProducts());
        model.addAttribute("users", service.getAllUsers());
        model.addAttribute("suggested", service.getSortedProducts());

        if (message != null) model.addAttribute("message", message);
        if (alertClass != null) model.addAttribute("alertClass", alertClass);
        model.addAttribute("session", session);

        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, RedirectAttributes redirectAttributes) {
        User user = service.addUser(name);
        redirectAttributes.addAttribute("message", "User added successfully with ID: " + user.getId());
        redirectAttributes.addAttribute("alertClass", "alert-success");
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            session.setAttribute("admin", true);
            return "redirect:/";
        } else {
            redirectAttributes.addAttribute("message", "Invalid admin credentials.");
            redirectAttributes.addAttribute("alertClass", "alert-danger");
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        if (session.getAttribute("admin") == null) {
            redirectAttributes.addAttribute("message", "Access denied: Admin login required.");
            redirectAttributes.addAttribute("alertClass", "alert-danger");
            return "redirect:/";
        }
        Product product = service.addProduct(name, price);
        redirectAttributes.addAttribute("message", "Product added with ID: " + product.getId());
        redirectAttributes.addAttribute("alertClass", "alert-success");
        return "redirect:/";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestParam int userId,
                             @RequestParam int productId,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false) String phone,
                             RedirectAttributes redirectAttributes) {
        if ((email == null || email.isEmpty()) && (phone == null || phone.isEmpty())) {
            redirectAttributes.addAttribute("message", "Contact info required (email or phone).");
            redirectAttributes.addAttribute("alertClass", "alert-danger");
            return "redirect:/";
        }
        boolean success = service.placeOrder(userId, productId, email, phone);
        if (success) {
            redirectAttributes.addAttribute("message", "Order placed! Invoice generated.");
            redirectAttributes.addAttribute("alertClass", "alert-success");
        } else {
            redirectAttributes.addAttribute("message", "Order failed: Invalid IDs.");
            redirectAttributes.addAttribute("alertClass", "alert-danger");
        }
        return "redirect:/";
    }

    @PostMapping("/removeUser")
    public String removeUser(@RequestParam int userId, RedirectAttributes redirectAttributes) {
        boolean success = service.removeUser(userId);
        if (success) {
            redirectAttributes.addAttribute("message", "User removed successfully.");
            redirectAttributes.addAttribute("alertClass", "alert-success");
        } else {
            redirectAttributes.addAttribute("message", "Failed to remove user: ID not found.");
            redirectAttributes.addAttribute("alertClass", "alert-danger");
        }
        return "redirect:/";
    }

    @GetMapping("/orders")
    public String userOrders(@RequestParam int userId, Model model) {
        List<Order> orders = service.getUserOrders(userId);
        model.addAttribute("orders", orders);
        return "orders";
    }
}
