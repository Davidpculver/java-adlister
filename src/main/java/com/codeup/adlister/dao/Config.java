package com.codeup.adlister.dao;

public class Config {
    public String getUrl() {
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }

    //        getUser() was for the jdbc lecture
    public String getUser() {
        return "root";
    }

//    This would change to what ever user you're using
    public String getUsername() {
        return "root";
    }

    public String getPassword() {
        return "codeup";
    }
}
