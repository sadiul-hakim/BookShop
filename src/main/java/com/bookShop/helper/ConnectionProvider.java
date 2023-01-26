package com.bookShop.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Hakim
 */
public class ConnectionProvider {
    private static final Logger logger=LoggerFactory.getLogger(ConnectionProvider.class);
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bookshop?useSSL=false","Hakim","hakim@123");
            System.out.println("Database connected...");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Could not create connection class.Error :"+e.getMessage());
            throw new RuntimeException("Can not connect database");
        }
    }
}
