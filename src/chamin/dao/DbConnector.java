/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chamin.dao;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malith
 */
public class DbConnector {
    private final Connection myConn;

    public DbConnector() throws IOException, SQLException {
         // get db properties from properties file (inside the project)
        Properties prop = new Properties();
        prop.load(new FileInputStream("user.properties"));

        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String dburl = prop.getProperty("dburl");

        try {
            //connect to database
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        myConn = DriverManager.getConnection(dburl, user, password);
        System.out.println("DB connection successful to : " + dburl);
    }

    public Connection getMyConn() {
        return myConn;
    }
    
    
}



