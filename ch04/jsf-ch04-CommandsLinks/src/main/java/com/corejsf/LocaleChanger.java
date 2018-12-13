/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author PC
 */
@Named // or @ManagedBean
@SessionScoped
public class LocaleChanger implements Serializable{
    
    public String germanAction()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.GERMAN);
        return null;
    }
    
    public String englishAction()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.ENGLISH);
        return null;
    }
}
