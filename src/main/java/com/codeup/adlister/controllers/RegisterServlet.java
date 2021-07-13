package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {



//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//
//        User user  = new User(username, email, password);
//        request.getSession().setAttribute("user", username);
//        DaoFactory.getUsersDao().insert(user);
//        response.sendRedirect("/profile");

//        INSTRUCTOR EXAMPLE
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPW = request.getParameter("confirm_password");
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
//        Check to make sure none of the form fields are empty
        boolean noEmpties = !username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPW.isEmpty();
        boolean passwordsMatch = password.equals(confirmPW);
        boolean actuallyAnEmail = email.contains("@") && email.contains(".");
        boolean userNotExists;
        try {
            DaoFactory.getUsersDao().findByUsername(username);
            userNotExists = false;
        } catch (Exception e) {
            userNotExists = true;
        }

        if (noEmpties && passwordsMatch && actuallyAnEmail && userNotExists) {
            User newUser = new User(username, email, password);
            DaoFactory.getUsersDao().insert(newUser);
//            Find the user just inserted by accessing the previous newuser.getusername method
            newUser = DaoFactory.getUsersDao().findByUsername(newUser.getUsername());
            HttpSession session = request.getSession();
            session.setAttribute("user", newUser);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/register");
        }


    }
}
