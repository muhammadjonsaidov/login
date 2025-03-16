package uz.pdp;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean pgSuccess = false;

        // Postgresql
        try (Connection conn = DBConnection.getPgConnection()) {
            Class.forName("org.postgresql.Driver");
            String sql = "INSERT INTO servlet_users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            pgSuccess = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("signup.jsp?error=database");
        }
        if (pgSuccess) {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {
        DBConnection.closeConnections(); // Server to‘xtatilganda ulanishlarni yopish
    }
}