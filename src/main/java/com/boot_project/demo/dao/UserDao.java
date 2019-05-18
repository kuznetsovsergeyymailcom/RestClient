package com.boot_project.demo.dao;

import com.boot_project.demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserByName(String name);
    User getUserById(Long id);

    void addUser(User user);
    void update(User user);
    void remove(Long id);

}
