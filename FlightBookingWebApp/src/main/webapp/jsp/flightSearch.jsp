<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.flightbooking.model.Flight, com.flightbooking.util.XMLParser, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/validation.js"></script>
</head>
<body>
    <div class="navbar">
        <a href="customerDashboard">Dashboard</a>
        <a href="bookingHistory">Booking History</a>
        <a href="logout">Logout</a>
    </div>
    <div class="container">
        <h2>Search Flights</h2>
        <form action="${pageContext.request.contextPath}/searchFlights" method="post" onsubmit="return validateSearch()">
            <label>Source:</label>
            <select name="source" id="source">
                <% 
                    String path = application.getRealPath("/WEB-INF/locations.xml");
                    List<String> locations = XMLParser.parseXML(path, "location");
                    for (String location : locations) {
                %>
                    <option value="<%= location %>"><%= location %></option>
                <% } %>
            </select><br>
            <label>Destination:</label>
            <select name="destination" id="destination">
                <% for (String location : locations) { %>
                    <option value="<%= location %>"><%= location %></option>
                <% } %>
            </select><br>
            <label>Date:</label>
            <input type="date" name="date" id="date" required><br>
            <button type="submit">Search</button>
        </form>

        <% if (request.getAttribute("flights") != null) { %>
            <h3>Available Flights</h3>
            <table>
                <tr>
                    <th>Flight No</th>
                    <th>Source</th>
                    <th>Destination</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Class</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <% for (Flight flight : (List<Flight>) request.getAttribute("flights")) { %>
                    <tr>
                        <td><%= flight.getFlightNo() %></td>
                        <td><%= flight.getSource() %></td>
                        <td><%= flight.getDestination() %></td>
                        <td><%= flight.getFlightDate() %></td>
                        <td><%= flight.getFlightTime() %></td>
                        <td><%= flight.getClassType() %></td>
                        <td>$<%= flight.getPrice() %></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/bookFlight" method="post">
                                <input type="hidden" name="flightId" value="<%= flight.getFlightId() %>">
                                <button type="submit">Book</button>
                            </form>
                        </td>
                    </tr>
                <% } %>
            </table>
        <% } %>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
    </div>
</body>
</html>