/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.ch02;

import com.jsf.ch02.domain.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author PC
 */
@Named(value = "gestionProductosBean")
@SessionScoped
public class GestionProductosBean implements Serializable{
    List<Product> productos;
    private Product producto;
    
    public GestionProductosBean() {
        // Instanciamos objetos para su manipulacion
        productos = new ArrayList<Product>();
        producto = new Product();
    }
    
    public void incluir()
    {
        productos.add(producto);
        producto = new Product();
    }
    
    public void setProducto(Product producto)
    {
        this.producto = producto;
    }
    
    public Product getProducto()
    {
        return producto;
    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }
    
}
