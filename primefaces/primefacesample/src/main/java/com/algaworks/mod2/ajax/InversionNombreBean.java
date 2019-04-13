/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.mod2.ajax;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author PC
 */
@Named(value = "inversionNombreBean")
@RequestScoped
public class InversionNombreBean implements Serializable{

    private String nombre;
    private String nombreInvertido;
    private int cantidadPalabras;
    
    public InversionNombreBean() {
    }
    
    public void invertir()
    {
        this.nombreInvertido = "";
        this.cantidadPalabras = 0;
        if(nombre != null && !nombre.isEmpty())
        {
            cantidadPalabras = 1;
        }
        for(int i = nombre.length() -1; i >= 0; i--)
        {
            char letra = nombre.charAt(i);
            nombreInvertido += letra;
            if(letra == ' ')
            {
                cantidadPalabras++;
            }
        }
        System.out.println("Nombre invertido: " + nombreInvertido);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreInvertido() {
        return nombreInvertido;
    }

    public int getCantidadPalabras() {
        return cantidadPalabras;
    }
    
}
