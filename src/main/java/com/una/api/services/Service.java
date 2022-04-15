package com.una.api.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Service {

    protected Connection connection = null;
    protected final String Host = "localhost:3306";
    protected final String DB = "matricula";
    protected final String User = "root";
    protected final String Password = "1234";

    protected void connect()
    {
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            //String url = String.format("jdbc:oracle:thin:@%s:XE", host);
            String url = String.format("jdbc:mysql://%s/%s", Host, DB);
            connection = DriverManager.getConnection(url, User, Password);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void disconnect() {
        try {
            if(!connection.isClosed()) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}