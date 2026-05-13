package com.example.scrapchat.login.service;

import com.example.scrapchat.login.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    List<User> getUserList();
    User updateUser(User user, Long userId);
    void deleteUserById(Long userId);
}
