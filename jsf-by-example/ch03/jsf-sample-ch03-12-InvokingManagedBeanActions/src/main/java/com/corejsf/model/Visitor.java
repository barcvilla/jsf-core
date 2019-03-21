/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.model;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Visitor implements Serializable{
    private boolean admin = false;
    
    public Visitor(){}

    /**
     * @return the isAdmin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setAdmin(boolean isAdmin) {
        this.admin = isAdmin;
    }
}
