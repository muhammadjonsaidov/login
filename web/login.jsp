<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="form-container">
    <form action="LoginServlet" method="POST">
        <h1>Sign In</h1>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Sign In</button>
        <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
        <p><a href="home.html">Back to Home</a></p>
        <br>
        <%
            PrintWriter writer = response.getWriter();
            String error = request.getParameter("error");
            if ("invalid".equals(error)) {
                writer.println("<p class='error'>Invalid email or password</p>");
            } else if ("database".equals(error)) {
                writer.println("<p class='error'>PostgreSQL error occurred</p>");
            }
        %>
    </form>
</div>
</body>
</html>