/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.controller;

import com.corejsf.model.Author;
import com.corejsf.model.Visitor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
@Named(value = "authorTableController")
@SessionScoped
public class AuthorTableController implements Serializable {
    
    private List<Author> authorList = null;
    private final String juneauBio = "This is Josh Juneau's Bio and all his life events";
    private final String deaBio = "This is Carl Dea's Bio";
    private final String beatyBio = "This is Mark Beaty's Bio";
    private final String oConnerBio = "This is John O'Connor's Bio";
    private final String guimeBio = "This is Freddy Guime's Bio";
    private Author current;
    private String authorLast;
    private Visitor visitor;
    
    public AuthorTableController() 
    {
        super();
        authorLast = null;
        populateAuthorList();
        visitor = new Visitor();
    }
    
    private void populateAuthorList()
    {
        if(authorList == null)
        {
            System.out.println("initilizing authors list");
            authorList = new ArrayList<>();
            authorList.add(new Author("Josh", "Juneau", juneauBio));
            authorList.add(new Author("Carl", "Dea", deaBio));
            authorList.add(new Author("Mark", "Beaty", beatyBio));
            authorList.add(new Author("John", "O'Conner", oConnerBio));
            authorList.add(new Author("Freddy", "Guime", guimeBio));
        }
    }
    
    public String displayAuthor(String last)
    {
        for(Author author : authorList)
        {
            if(author.getLast().equals(last))
            {
                current = author;
                break;
            }
        }
        return "passingParameters2";
    }

    public List<Author> getAuthorList() {
        System.out.println("Getting the author list =>" + authorList.size());
        return authorList;
    }

    public Author getCurrent() {
        return current;
    }

    public void setCurrent(Author current) {
        this.current = current;
    }

    public String getAuthorLast() {
        return authorLast;
    }

    public void setAuthorLast(String authorLast) {
        this.authorLast = authorLast;
    }
    
    public String validateUser()
    {
        String viewName;
        System.out.println("Look in the server log to see this message");
        /**
         * Aqui realizamos una validacion basados en la visita del usuario al sitio para asegurarnos que tiene 
         * los permisos apropiados para ver la vista seleccionada. Para el proposito de este ejemplo, esta logica
         * condicional es solo un prototipo
         */
        if(visitor.isAdmin())
        {
            // visita la pagina actual
            viewName = null;
            System.out.println("Usuario actual es un Admin");
        }
        else
        {
            viewName = "notAdmin";
            System.out.println("Usuario actual no es un Admin");
        }
        return viewName;
    }
}
