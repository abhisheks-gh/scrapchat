package com.example.scrapchat.login.repository;

import com.example.scrapchat.login.entity.User;
import lombok.extern.java.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User saveUser(User user) {
        String addUser = "INSERT INTO users(username, password) VALUES " +
                "('" + user.getUsername() + "', '" + user.getPassword() + "');";

        jdbcTemplate.execute(addUser);
        return user;
    }

    @Override
    public List<User> fetchUserList() {
        String fetchAllUsers = "select username, password from users;";
        return jdbcTemplate.query(fetchAllUsers, (rs, rowNum) -> {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }

    @Override
    public User updateUser(User user, Long userId) {
        String updateUserById = "update users set username = " + user.getUsername() + ", password = " +
                user.getPassword() + " where user_id = " + userId + ";";
        jdbcTemplate.execute(updateUserById);
        return user;
    }

    @Override
    public void deleteUserById(Long userId) {
        String deleteByUserId = "delete from users where user_id = " + userId + ";";
        jdbcTemplate.execute(deleteByUserId);
    }
}
