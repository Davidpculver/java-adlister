package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        System.out.println(username);
//        System.out.println(password);

        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database


try{
    User foundUser = DaoFactory.getUsersDao().findByUsername(username);
    if (foundUser.getPassword().equals(password) && foundUser.getUsername().equals(username)){
        request.getSession().setAttribute("user", foundUser);
        response.sendRedirect("/profile");
    } else {
        response.sendRedirect("/login");
    }
} catch (Exception e){
    response.sendRedirect("/register");
}




//        request.getSession().setAttribute("username", foundUser.getUsername());
////        request.getRequestDispatcher("WEB-INF/profile").forward(request, response);
//        response.sendRedirect("/profile");


//        boolean validAttempt = password.equals(foundUser.getPassword());
//
//        if (validAttempt) {
//            // TODO: store the logged in user object in the session, instead of just the username
//            request.getSession().setAttribute("user", foundUser);
//            response.sendRedirect("/profile");
//        } else {
//            response.sendRedirect("/login");
//        }
    }
}
