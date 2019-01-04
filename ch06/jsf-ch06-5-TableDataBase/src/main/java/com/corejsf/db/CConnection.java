/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author PC
 */
public class CConnection {
    // Metodo que retorna un objeto Connection, sin modificador de acceso lo cual hace accesible unicamente a clases dentro del mismo paquete
    public Connection connect()
    {
        Connection conn = null;
        Properties properties = UtilDB.getInstance().getConfigDataBase();
        String url = "jdbc:postgresql://" + properties.getProperty("servidor") + ":" + properties.getProperty("puerto") + "/" 
                + properties.getProperty("basededatos");
        String user = properties.getProperty("usuario");
        String pass = properties.getProperty("password");
        
        try
        {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
