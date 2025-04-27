package com.flightbooking.dao;

import com.flightbooking.model.Flight;
import com.flightbooking.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    public boolean addFlight(Flight flight) {
        String sql = "INSERT INTO flights (flight_no, source, destination, flight_date, flight_time, class_type, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, flight.getFlightNo());
            stmt.setString(2, flight.getSource());
            stmt.setString(3, flight.getDestination());
            stmt.setDate(4, flight.getFlightDate());
            stmt.setTime(5, flight.getFlightTime());
            stmt.setString(6, flight.getClassType());
            stmt.setDouble(7, flight.getPrice());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateFlight(Flight flight) {
        String sql = "UPDATE flights SET flight_no = ?, source = ?, destination = ?, flight_date = ?, flight_time = ?, class_type = ?, price = ? WHERE flight_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, flight.getFlightNo());
            stmt.setString(2, flight.getSource());
            stmt.setString(3, flight.getDestination());
            stmt.setDate(4, flight.getFlightDate());
            stmt.setTime(5, flight.getFlightTime());
            stmt.setString(6, flight.getClassType());
            stmt.setDouble(7, flight.getPrice());
            stmt.setInt(8, flight.getFlightId());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFlight(int flightId) {
        String sql = "DELETE FROM flights WHERE flight_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, flightId);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Flight> searchFlights(String source, String destination, String date) {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights WHERE source = ? AND destination = ? AND flight_date = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, source);
            stmt.setString(2, destination);
            stmt.setString(3, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setFlightNo(rs.getString("flight_no"));
                flight.setSource(rs.getString("source"));
                flight.setDestination(rs.getString("destination"));
                flight.setFlightDate(rs.getDate("flight_date"));
                flight.setFlightTime(rs.getTime("flight_time"));
                flight.setClassType(rs.getString("class_type"));
                flight.setPrice(rs.getDouble("price"));
                flights.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setFlightNo(rs.getString("flight_no"));
                flight.setSource(rs.getString("source"));
                flight.setDestination(rs.getString("destination"));
                flight.setFlightDate(rs.getDate("flight_date"));
                flight.setFlightTime(rs.getTime("flight_time"));
                flight.setClassType(rs.getString("class_type"));
                flight.setPrice(rs.getDouble("price"));
                flights.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }
}