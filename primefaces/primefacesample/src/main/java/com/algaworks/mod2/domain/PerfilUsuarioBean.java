/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.mod2.domain;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC
 */
@Named(value = "perfilUsuarioBean")
@SessionScoped
public class PerfilUsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    private String password;
    private Date nacimiento;
    private String comentarios;
    private String nombre;
    private String profesion;
    private Interes interes;
    
    public static final List<Interes> INTERESES = new ArrayList<Interes>();
    
    public PerfilUsuarioBean() {
        
    }
    
    static
    {
        INTERESES.add(new Interes("Futbol", "futbol"));
        INTERESES.add(new Interes("Atletismo", "atletismo"));
        INTERESES.add(new Interes("Ciclismo", "ciclismo"));
        INTERESES.add(new Interes("Tenis", "tenis"));
    }
    
    public void actualizar()
    {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("Nombre: " + nombre);
        System.out.println("Profesion: " + profesion);
        System.out.println("Comentarios: " + comentarios);
        System.out.println("Nacimiento: " + nacimiento);
        System.out.println("Intereses: " + interes.getDescripcion());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil actualizado"));
    }
    
    public List<String> completarTexto(String texto)
    {
        List<String> resultados = new ArrayList<String>();
        if(texto.startsWith("Ca"))
        {
            resultados.add("Carlos");
            resultados.add("Carla");
            resultados.add("Camilo");
        }
        return resultados;
    }
    
    public List<Interes> getIntereses()
    {
        return INTERESES;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date birth) {
        //nacimiento = (LocalDate)LocalDate.of(birth.getDay(), birth.getMonth(), birth.getYear());
        nacimiento = birth;
    }

    public Interes getInteres() {
        return interes;
    }

    public void setInteres(Interes interes) {
        this.interes = interes;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
}
