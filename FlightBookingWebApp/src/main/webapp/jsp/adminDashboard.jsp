<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.flightbooking.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="navbar">
        <a href="manageFlights">Manage Flights</a>
        <a href="logout">Logout</a>
    </div>
    <div class="container">
        <h2>Welcome, <%= ((User) session.getAttribute("user")).getEmail() %></h2>
        <p>Use the navigation bar to manage flights.</p>
    </div>
</body>
</html>