/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.mod2.ajax;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@Named(value = "registroUsuario")
@SessionScoped
public class RegistroUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    private String nombre;
    
    public RegistroUsuario() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void registrar()
    {
        System.out.println("Login: " + login);
        System.out.println("Nombre: " + nombre);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro efectuado"));
    }
    
    public void verificicarDisponibilidadLogin()
    {
        FacesMessage msg = null;
        System.out.println("Verificando disponibilidad: " + this.login);
        if("joao".equalsIgnoreCase(this.login))
        {
            msg = new FacesMessage("Login esta en uso");
            msg.setSeverity(FacesMessage.SEVERITY_WARN);
        }
        else
        {
            msg = new FacesMessage("Login disponible");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
