package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
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
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

//              MY METHOD
//    @Override
//    public User findByUsername(String username) {
//        String sql = "SELECT * FROM users WHERE username LIKE ?;";
//        String searchByUsername = "%" + username + "%";
//        PreparedStatement stmt = null;
//        try {
//            stmt = connection.prepareStatement(sql);
//            stmt.setString(1, searchByUsername);
//            ResultSet rs = stmt.executeQuery();
//            System.out.println("Before extract user");
//            return extractUser(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all users.", e);
//        }
//    }

    //    INSTRUCTOR EXAMPLE
//    Want to use this for the login servlet. Want to make sure typing in username correctly. So want to make sure value coming in is username typed in. DO NOT want to use like with wildcards in sql search
    @Override
    public User findByUsername(String username) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE username = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
//            the stmt replaces the ? with username - so we dont need to pass it into executequery
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                users.add(new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Since an arraylist was created, just return the first instance
        return users.get(0);
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
            e.printStackTrace();
            throw new RuntimeException("Error inserting user", e);
        }
    }
}
