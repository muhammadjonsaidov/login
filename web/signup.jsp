<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="form-container">
    <form action="RegisterServlet" method="POST">
        <h1>Create Account</h1>
        <input type="text" name="username" placeholder="Username" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Sign Up</button>
        <p>Already have an account? <a href="login.jsp">Sign In</a></p>
        <p><a href="home.html">Back to Home</a></p>

        <%
            PrintWriter writer = response.getWriter();
            String error = request.getParameter("error");

            if ("database".equals(error)) {
                writer.println("<p class='error'>PostgreSQL error occurred</p>");
            }
        %>
    </form>

</div>
</body>
</html>