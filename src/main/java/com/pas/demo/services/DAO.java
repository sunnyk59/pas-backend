package com.pas.demo.services;

import java.sql.*;

public class DAO {

    private String url = "jdbc:postgresql://localhost:5432/pas";
    private String user = "postgres";
    private String password = "password";
    private Connection conn = null;

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false); // Optional
        } catch (SQLException ex) {
            conn = null;
            ex.printStackTrace();
            System.out.println("\n Unable to make connection to DB, Please contact Administrator ");
        }
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } 

    // Generic method to execute an update (INSERT, UPDATE, DELETE)
    public void executeQuery(String query) {
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            connection.commit(); // Commit the transaction
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(); // Ensure the connection is closed
        }
    }

    // Generic method to execute a query (SELECT)
    public ResultSet executeFetch(String query) {
        ResultSet resultSet = null;
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);
            // Note: Connection is not closed here to allow ResultSet to be used
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet; // Caller should close the connection and result set
    }

    public static void main(String[] args) {
        //DAO dao = new DAO(); 
    }

}
