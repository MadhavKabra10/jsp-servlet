package org.IIITP.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/project?useSSL=false";
        String dbUsername = "root";
        String dbpassword = "Madhav@c$e10";
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Attempt to establish a database connection
            con = DriverManager.getConnection(dbURL, dbUsername, dbpassword);
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException separately
            e.printStackTrace();
            throw new Exception("JDBC driver class not found", e);
        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
            throw new Exception("Error establishing database connection", e);
        }

        if (con == null) {
            throw new Exception("Connection object is null");
        }
        return con;
    }
}
