package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        System.out.println("Extracting user");
        User user1 = new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
        System.out.println("User1" + user1);
        return user1;
    }

//    private List<User> usersByUsername(ResultSet rs) throws SQLException {
//        List<User> users = new ArrayList<>();
//        while (rs.next()) {
//            users.add(extractUser(rs));
//        }
//        return users;
//    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username LIKE ?;";
        String searchByUsername = "%" + username + "%";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchByUsername);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Before extract user");
            return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all users.", e);
        }
    }

    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }
}
