package uz.pdp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Postgresql Connection
    private static final String PG_URL = "jdbc:postgresql://localhost:5432/g410";
    private static final String PG_USER = "postgres";
    private static final String PG_PASSWORD = "root";
    private static Connection pgConnection;


    public static Connection getPgConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        if (pgConnection == null || pgConnection.isClosed()) {
            pgConnection = DriverManager.getConnection(PG_URL, PG_USER, PG_PASSWORD);
        }
        return pgConnection;
    }

    public static void closeConnections() {
        try {
            if (pgConnection!=null && !pgConnection.isClosed()){
                pgConnection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}