package com.flightbooking.servlet;

import com.flightbooking.dao.BookingDAO;
import com.flightbooking.model.Booking;
import com.flightbooking.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/bookFlight")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int flightId = Integer.parseInt(request.getParameter("flightId"));

        Booking booking = new Booking();
        booking.setUserId(user.getId());
        booking.setFlightId(flightId);

        BookingDAO bookingDAO = new BookingDAO();
        if (bookingDAO.bookFlight(booking)) {
            request.setAttribute("message", "Booking confirmed!");
            request.getRequestDispatcher("jsp/bookingConfirmation.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Booking failed");
            request.getRequestDispatcher("jsp/flightSearch.jsp").forward(request, response);
        }
    }
}