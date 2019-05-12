/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.mod2.domain;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Interes implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String descripcion;
    private String nombreIcono;
    
    public Interes()
    {}
    
    public Interes(String descripcion, String nombreIcono)
    {
        this.descripcion = descripcion;
        this.nombreIcono = nombreIcono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreIcono() {
        return nombreIcono;
    }

    public void setNombreIcono(String nombreIcono) {
        this.nombreIcono = nombreIcono;
    }

    @Override
    public String toString() {
        return "Interes{" + "descripcion=" + descripcion + ", nombreIcono=" + nombreIcono + '}';
    }
    
    
}
