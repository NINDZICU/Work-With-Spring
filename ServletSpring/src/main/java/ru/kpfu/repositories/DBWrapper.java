package ru.kpfu.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Anatoly on 10.04.2017.
 */
public class DBWrapper {
    private final static String DRIVER = "org.postgresql.Driver";
    private final static String CONNECTION_URI = "jdbc:postgresql://localhost:5432/proga_database";
    private final static String LOGIN = "admin";
    private final static String PASSWORD = "12345678";

    private static Connection conn;

    public static Connection getConection() {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(CONNECTION_URI, LOGIN, PASSWORD);

            } catch (ClassNotFoundException e) {
                System.out.println("Can't find DB driver.");
            } catch (SQLException ex) {
                System.out.println("Can't connect to DB (" + ex.getErrorCode() + ": " + ex.getMessage() + ").");
            }

        }
        return conn;

    }
}