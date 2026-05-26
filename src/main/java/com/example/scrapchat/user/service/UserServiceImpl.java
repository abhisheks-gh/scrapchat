package com.example.scrapchat.user.service;

import com.example.scrapchat.user.entity.User;
import com.example.scrapchat.user.repository.UserRepositoryImpl;
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
