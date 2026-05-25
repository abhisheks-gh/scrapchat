package com.example.scrapchat.login.service;

import com.example.scrapchat.login.entity.User;
import com.example.scrapchat.login.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepositoryImpl userRepositoryImpl;

    public UserServiceImpl(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    @Override
    public User addUser(User user) {
        return userRepositoryImpl.saveUser(user);
    }

    @Override
    public List<User> getUserList() {
        return userRepositoryImpl.fetchUserList();
    }

    @Override
    public User updateUser(User user, Long userId) {
        return userRepositoryImpl.updateUser(user, userId);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepositoryImpl.deleteUserById(userId);
    }
}
