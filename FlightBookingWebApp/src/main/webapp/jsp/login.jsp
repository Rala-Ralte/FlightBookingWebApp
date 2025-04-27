<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/validation.js"></script>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
        <form action="login" method="post" onsubmit="return validateLogin()">
            <label>Email:</label>
            <input type="email" name="email" id="email" required><br>
            <label>Password:</label>
            <input type="password" name="password" id="password" required><br>
            <button type="submit">Login</button>
        </form>
        <p>Don't have an account? <a href="register">Register</a></p>
    </div>
</body>
</html>