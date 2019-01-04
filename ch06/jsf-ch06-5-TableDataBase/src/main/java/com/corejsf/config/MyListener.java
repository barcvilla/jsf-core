/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.config;

import com.corejsf.db.UtilDB;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author PC
 */
@WebListener
public class MyListener implements ServletContextListener{
    //Leemos la info del web.xml y los parametros
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String servidor = sce.getServletContext().getInitParameter("servidor");
        String puerto = sce.getServletContext().getInitParameter("puerto");
        String basededatos = sce.getServletContext().getInitParameter("basededatos");
        String usuariobd = sce.getServletContext().getInitParameter("usuario");
        String passwordbd = sce.getServletContext().getInitParameter("password");
        
        Properties propiedadesConexion = new Properties();
        propiedadesConexion.setProperty("servidor", servidor);
        propiedadesConexion.setProperty("puerto", puerto);
        propiedadesConexion.setProperty("basededatos", basededatos);
        propiedadesConexion.setProperty("usuario", usuariobd);
        propiedadesConexion.setProperty("password", passwordbd);
        
        // Llamamos al metodo configuraBaseDeDatos() de la unica instancia que existe de Utilidades
        UtilDB.getInstance().configDataBase(propiedadesConexion);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
