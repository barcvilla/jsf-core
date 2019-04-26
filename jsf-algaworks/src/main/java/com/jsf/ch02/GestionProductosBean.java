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
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 * @ViewScoped tiene un tiempo de vida menor al @SessionScoped
 * @RequestScoped cada vez que realiza un request se inicializa y finaliza el managedbean
 * @PostConstruct cuando un metodo tiene esta anotacion una vez que se construye una instancia del bean, este metodo
 * es ejecutado
 * @PreDestroy el metodo con la anotacion @PreDestroy se ejecuta momentos antes de que el scope del managed bean se termine
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
    
    @PostConstruct
    public void initialization()
    {
        System.out.println("ManagedBean inicializado");
    }
    
    @PreDestroy
    public void finalizar()
    {
        System.out.println("ManagedBean finalizado");
    }
    
    public String obtenerAyuda()
    {
        if(productos.isEmpty())
        {
            return "AyudaGestionProductos?faces-redirect=true";
        }
        else
        {
            return "AyudaGestionProductosTelefono?faces-redirect=true";
        }
    }
    
    public void incluir()
    {
        System.out.println("Incluyendo");
        productos.add(producto);
        producto = new Product();
    }
    
    public void verificarInclusion(ActionEvent event)
    {
        System.out.println("Verificando");
        //evitamos el nullpointerexception
        if(producto.getFabricante().equals(""))
        {
            producto.setFabricante("Sin fabricante");
        }
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
