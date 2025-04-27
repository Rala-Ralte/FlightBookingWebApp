package com.flightbooking.servlet;

import com.flightbooking.dao.FlightDAO;
import com.flightbooking.model.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchFlights")
public class FlightSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the flight search form
        request.getRequestDispatcher("jsp/flightSearch.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String date = request.getParameter("date");

        FlightDAO flightDAO = new FlightDAO();
        List<Flight> flights = flightDAO.searchFlights(source, destination, date);

        request.setAttribute("flights", flights);
        request.getRequestDispatcher("jsp/flightSearch.jsp").forward(request, response);
    }
}