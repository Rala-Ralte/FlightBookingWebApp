package com.flightbooking.servlet;

import com.flightbooking.dao.FlightDAO;
import com.flightbooking.model.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/adminFlight")
public class AdminFlightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        FlightDAO flightDAO = new FlightDAO();

        if ("add".equals(action)) {
            Flight flight = new Flight();
            flight.setFlightNo(request.getParameter("flightNo"));
            flight.setSource(request.getParameter("source"));
            flight.setDestination(request.getParameter("destination"));
            flight.setFlightDate(Date.valueOf(request.getParameter("flightDate")));
            flight.setFlightTime(Time.valueOf(request.getParameter("flightTime") + ":00"));
            flight.setClassType(request.getParameter("classType"));
            flight.setPrice(Double.parseDouble(request.getParameter("price")));

            if (flightDAO.addFlight(flight)) {
                request.setAttribute("message", "Flight added successfully");
            } else {
                request.setAttribute("error", "Failed to add flight");
            }
        } else if ("update".equals(action)) {
            Flight flight = new Flight();
            flight.setFlightId(Integer.parseInt(request.getParameter("flightId")));
            flight.setFlightNo(request.getParameter("flightNo"));
            flight.setSource(request.getParameter("source"));
            flight.setDestination(request.getParameter("destination"));
            flight.setFlightDate(Date.valueOf(request.getParameter("flightDate")));
            flight.setFlightTime(Time.valueOf(request.getParameter("flightTime") + ":00"));
            flight.setClassType(request.getParameter("classType"));
            flight.setPrice(Double.parseDouble(request.getParameter("price")));

            if (flightDAO.updateFlight(flight)) {
                request.setAttribute("message", "Flight updated successfully");
            } else {
                request.setAttribute("error", "Failed to update flight");
            }
        } else if ("delete".equals(action)) {
            int flightId = Integer.parseInt(request.getParameter("flightId"));
            if (flightDAO.deleteFlight(flightId)) {
                request.setAttribute("message", "Flight deleted successfully");
            } else {
                request.setAttribute("error", "Failed to delete flight");
            }
        }

        request.setAttribute("flights", flightDAO.getAllFlights());
        request.getRequestDispatcher("jsp/manageFlights.jsp").forward(request, response);
    }
}