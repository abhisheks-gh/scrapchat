package com.example.scrapchat.user.repository;

import com.example.scrapchat.user.entity.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);
    List<User> fetchUserList();
    User updateUser(User user, Long userId);
    void deleteUserById(Long userId);
}
