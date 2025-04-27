package com.flightbooking.servlet;

import com.flightbooking.dao.BookingDAO;
import com.flightbooking.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookingHistory")
public class BookingHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        BookingDAO bookingDAO = new BookingDAO();
        request.setAttribute("bookings", bookingDAO.getUserBookings(user.getId()));
        request.getRequestDispatcher("jsp/bookingHistory.jsp").forward(request, response);
    }
}