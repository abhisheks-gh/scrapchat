package com.example.scrapchat.user.controller;

import com.example.scrapchat.user.entity.User;
import com.example.scrapchat.user.service.UserServiceImpl;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
@CrossOrigin(originPatterns = "http://localhost:5173")
@Log
public class UserController {

    UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping(path = "/users")
    public User addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }

    @GetMapping(path = "/users")
    public List<User> getUserList() {
        return userServiceImpl.getUserList();
    }

    @PutMapping(path = "/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long userId) {
        return userServiceImpl.updateUser(user, userId);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@PathVariable("id") Long userId) {
        userServiceImpl.deleteUserById(userId);
    }
}
