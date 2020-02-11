package com.metacube.parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Harshit
 *This is connection class which connect mysql database to java servlet
 */
public class javaConnection {
    
    // This class can be used to initialize the database connection
    
    public static Connection initializeDatabase() throws SQLException,
    ClassNotFoundException {
        
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        
        // Database name to access
        String dbName = "parking";
        String dbUsername = "root";
        String dbPassword = "admin";
        
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername, dbPassword);
        return con;
    }
}