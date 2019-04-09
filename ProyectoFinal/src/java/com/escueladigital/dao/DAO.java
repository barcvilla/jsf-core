package com.escueladigital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private static final Logger LOG = Logger.getLogger(DAO.class.getName());
    
    public static Connection conectar(){
        Connection conexion = null;
        String url = "jdbc:postgresql://127.0.0.1/escueladigital";
        String user = "escueladigital";
        String pass = "escueladigital";
        try {
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException sqle) {
            LOG.log(Level.SEVERE, "Ocurrió un error en: {0}", sqle.getMessage());
        }
        return conexion;
    }
    
    public static void cerrar(Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null) {
                r.close();
            }
            if (p != null) {
                p.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException sqle) {}
    }
}
