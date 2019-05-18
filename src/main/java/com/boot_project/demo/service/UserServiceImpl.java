package com.boot_project.demo.service;

import com.boot_project.demo.dao.UserDao;
import com.boot_project.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    @Override
    public User getUserByName(String name) {

        return userDao.getUserByName(name);
    }

    @Override
    public User getUserById(Long id) {

        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {

        userDao.addUser(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);

    }

    @Override
    public void remove(Long id) {
        userDao.remove(id);
    }
}
