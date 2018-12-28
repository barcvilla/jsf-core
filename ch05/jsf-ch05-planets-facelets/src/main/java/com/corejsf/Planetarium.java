/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "planetarium")
@RequestScoped
public class Planetarium implements Serializable{
    
    private String selectedPlanet;
    
    public Planetarium() {
    }
    
    public String getSelectedPlanet()
    {
        return selectedPlanet;
    }
    
    public String changePlanet(String newValue)
    {
        selectedPlanet = newValue;
        return selectedPlanet;
    }
}
