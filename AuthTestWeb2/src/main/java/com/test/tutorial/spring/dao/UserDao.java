package com.test.tutorial.spring.dao;

import java.util.List;

import com.test.tutorial.spring.entity.User;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
}