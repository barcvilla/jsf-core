/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@Named(value = "messageController")
@SessionScoped
public class MessageController implements Serializable {

    private int hitCounter = 0;
    private String javaText;
    
    public MessageController() {
        javaText = null;
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Managed Bean Initialized", null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public int getHitCounter() {
        return hitCounter;
    }

    public void setHitCounter(int hitCounter) {
        this.hitCounter = hitCounter;
    }

    public String getJavaText() {
        return javaText;
    }

    public void setJavaText(String javaText) {
        this.javaText = javaText;
    }
    
    public void newMessage()
    {
        String hitMessage = null;
        setHitCounter(hitCounter++);
        hitMessage = getHitCounter() > 1 ? getHitCounter() + " times" : getHitCounter() + " time";
        Date currDate = new Date();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
        "You have pressed that button " + hitMessage + "! the current date and time: " + currDate, null);
        if(getJavaText().equalsIgnoreCase("java"))
        {
            FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
            "Good job, that is the corret text", null);
            FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
        }
        else
        {
            FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Sorry, that is Not the correct text", null);
            FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
        }
    }
}
