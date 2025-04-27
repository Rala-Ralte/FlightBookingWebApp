<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.flightbooking.model.Flight, com.flightbooking.util.XMLParser, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Flights</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/validation.js"></script>
</head>
<body>
    <div class="navbar">
        <a href="adminDashboard">Dashboard</a>
        <a href="logout">Logout</a>
    </div>
    <div class="container">
        <h2>Manage Flights</h2>
        <h3>Add Flight</h3>
        <form action="adminFlight" method="post" onsubmit="return validateFlightForm()">
            <input type="hidden" name="action" value="add">
            <label>Flight No:</label>
            <input type="text" name="flightNo" id="flightNo" required><br>
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
            <input type="date" name="flightDate" id="flightDate" required><br>
            <label>Time:</label>
            <input type="time" name="flightTime" id="flightTime" required><br>
            <label>Class:</label>
            <select name="classType" id="classType">
                <% 
                    path = application.getRealPath("/WEB-INF/classes.xml");
                    List<String> classes = XMLParser.parseXML(path, "class");
                    for (String classType : classes) {
                %>
                    <option value="<%= classType %>"><%= classType %></option>
                <% } %>
            </select><br>
            <label>Price:</label>
            <input type="number" name="price" id="price" step="0.01" required><br>
            <button type="submit">Add Flight</button>
        </form>

        <h3>Existing Flights</h3>
        <table>
            <tr>
                <th>Flight No</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Date</th>
                <th>Time</th>
                <th>Class</th>
                <th>Price</th>
                <th>Actions</th>
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
                        <form action="adminFlight" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="flightId" value="<%= flight.getFlightId() %>">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </table>
        <% if (request.getAttribute("message") != null) { %>
            <p class="success"><%= request.getAttribute("message") %></p>
        <% } %>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
    </div>
</body>
</html>