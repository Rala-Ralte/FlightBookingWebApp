package com.flightbooking.servlet;

import com.flightbooking.dao.FlightDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manageFlights")
public class ManageFlightsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightDAO flightDAO = new FlightDAO();
        request.setAttribute("flights", flightDAO.getAllFlights());
        request.getRequestDispatcher("jsp/manageFlights.jsp").forward(request, response);
    }
}