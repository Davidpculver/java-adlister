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

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        User user = DaoFactory.getUsersDao().findByUsername(username);
//        request.getSession().getAttribute("user");

//        User signedIn = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user"));
//        if (signedIn = username) {
//            System.out.println("signed in");
//        }

        if (request.getSession().getAttribute("user") != null) {
//            System.out.println("signed in");
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/login");
        }





    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Casting as User: when we set value into session its stored as simple object (think about it as interface - instantiated, but not define unique features defined from other classes). "Now that im a User, i know how to getId()".
        User loggedInUser = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                loggedInUser.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }
}
