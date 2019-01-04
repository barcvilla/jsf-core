/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.db;

import java.util.Properties;

/**
 *
 * @author PC
 */
public final class UtilDB {
    private static final UtilDB instance = new UtilDB();
    private Properties propertiesDB; // guardamos en el objeto propiedadesDB de tipo Peroperties la info del archivo web.xml
    
    private UtilDB(){}
    
    public static UtilDB getInstance()
    {
        return instance;
    }
    
    public void configDataBase(Properties properties)
    {
        this.propertiesDB = properties;
    }
    
    public Properties getConfigDataBase()
    {
        return this.propertiesDB;
    }
}
