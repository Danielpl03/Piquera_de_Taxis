package org.example.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgres {
    private static final String url = "jdbc:postgresql://localhost:5432/Piquera_de_Taxis";
    private static final String user = "postgres";
    private static final String password = "sasa";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
