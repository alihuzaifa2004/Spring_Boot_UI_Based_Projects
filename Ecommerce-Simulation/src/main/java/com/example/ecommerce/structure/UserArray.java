package com.example.ecommerce.structure;

import com.example.ecommerce.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserArray {

    private User[] users = new User[100];
    private int size = 0;

    public void addUser(User user) {
        users[size++] = user;
    }

    public void removeUser(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    users[j] = users[j + 1];
                }
                users[--size] = null;
                break;
            }
        }
    }

    public User getUser(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        return null;
    }

    public User[] getUsers() {
        User[] result = new User[size];
        System.arraycopy(users, 0, result, 0, size);
        return result;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(Arrays.asList(getUsers()));
    }
}

