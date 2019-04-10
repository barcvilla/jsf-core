/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.domain;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author PC
 */
@Named(value = "registroAlumno")
@ViewScoped
public class RegistroAlumno implements Serializable{

    private String nombre;
    private String email;
    
    public RegistroAlumno() 
    {
        
    }
    
    public void registrar()
    {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Email: " + this.email);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
