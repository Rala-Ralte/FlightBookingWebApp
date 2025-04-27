<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="navbar">
        <a href="customerDashboard">Dashboard</a>
        <a href="searchFlights">Search Flights</a>
        <a href="bookingHistory">Booking History</a>
        <a href="logout">Logout</a>
    </div>
    <div class="container">
        <h2>Booking Confirmation</h2>
        <p><%= request.getAttribute("message") %></p>
        <a href="customerDashboard">Back to Dashboard</a>
    </div>
</body>
</html>