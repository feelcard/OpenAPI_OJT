package com.test.tutorial.spring.service;

import java.util.List;

import com.test.tutorial.spring.entity.User;

public interface UserService {
    void add(User user);
    List<User> listUsers();
}