/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author PC
 */
@Named(value = "navigationController")
@SessionScoped
public class NavigationController implements Serializable {

    private boolean authenticated = false;
    
    public NavigationController() {
    }
    
    public String pageOne()
    {
        return "PAGE_1";
    }
    
    public String pageTwo()
    {
        return "PAGE_2";
    }
    
    public String nextPage()
    {
        return "navigation3";
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
    
    public void login()
    {
        // realizamos algunas tareas y retornamos un booleano
        setAuthenticated(true);
        System.out.println("Here");
    }
}
