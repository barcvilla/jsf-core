/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.ch02.domain;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Product implements Serializable{
    private String nombre;
    private String fabricante;
    private String categoria;
    
    public Product(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Product{" + "nombre=" + nombre + ", fabricante=" + fabricante + ", categoria=" + categoria + '}';
    }
}
