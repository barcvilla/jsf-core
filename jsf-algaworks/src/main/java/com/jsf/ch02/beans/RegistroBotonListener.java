/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.ch02.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author PC
 */
@Named(value = "registroBotonListener")
@SessionScoped
public class RegistroBotonListener implements Serializable, ActionListener {

    /**
     * Creates a new instance of RegistroBotonListener
     */
    public RegistroBotonListener() {
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        System.out.println("Haciendo click en el boton " + event.getComponent().getId());
    }
    
}
