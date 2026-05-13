package com.example.scrapchat.repository;

import com.example.scrapchat.login.entity.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);
    List<User> fetchUserList();
    User updateUser(User user, Long userId);
    void deleteUserById(Long userId);
}
