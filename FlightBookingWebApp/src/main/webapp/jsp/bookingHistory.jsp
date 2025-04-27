<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.flightbooking.dao.BookingDAO, com.flightbooking.model.Booking, com.flightbooking.model.User, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Booking History</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="navbar">
        <a href="customerDashboard">Dashboard</a>
        <a href="searchFlights">Search Flights</a>
        <a href="logout">Logout</a>
    </div>
    <div class="container">
        <h2>Booking History</h2>
        <table>
            <tr>
                <th>Booking ID</th>
                <th>Flight ID</th>
                <th>Booking Date</th>
            </tr>
            <% 
                User user = (User) session.getAttribute("user");
                BookingDAO bookingDAO = new BookingDAO();
                List<Booking> bookings = bookingDAO.getUserBookings(user.getId());
                for (Booking booking : bookings) {
            %>
                <tr>
                    <td><%= booking.getBookingId() %></td>
                    <td><%= booking.getFlightId() %></td>
                    <td><%= booking.getBookingDate() %></td>
                </tr>
            <% } %>
        </table>
    </div>
</body>
</html>