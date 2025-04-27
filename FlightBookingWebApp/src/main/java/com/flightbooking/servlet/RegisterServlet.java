package com.flightbooking.servlet;

import com.flightbooking.dao.UserDAO;
import com.flightbooking.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = "CUSTOMER";

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        UserDAO userDAO = new UserDAO();
        if (userDAO.registerUser(user)) {
            response.sendRedirect("login");
        } else {
            request.setAttribute("error", "Registration failed");
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
        }
    }
}