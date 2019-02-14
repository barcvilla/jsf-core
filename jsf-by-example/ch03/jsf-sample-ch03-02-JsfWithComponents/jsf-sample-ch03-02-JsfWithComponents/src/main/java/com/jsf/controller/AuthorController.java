/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.controller;

import com.jsf.domain.Author;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
@Named(value = "authorController")
@SessionScoped
public class AuthorController implements Serializable {

    private String newAuthorFirst;
    private String newAuthorLast;
    private String bio;
    private List<Author> authorList;
    
    public void populateAuthorList()
    {
        System.out.println("Inicializando lista de autores");
        authorList = new ArrayList<>();
        authorList.add(new Author("Johs", "Juneau", null));
        authorList.add(new Author("Cari", "Dea", null));
        authorList.add(new Author("Freddy", "Guime", null));
    }
    
    public AuthorController() {
        populateAuthorList();
    }
    
    public List<Author> getAuthorList()
    {
        return authorList;
    }
    
    public void setAuthorList(List<Author> authorList)
    {
        this.authorList = authorList;
    }

    public String getNewAuthorFirst() {
        return newAuthorFirst;
    }

    public void setNewAuthorFirst(String newAuthorFirst) {
        this.newAuthorFirst = newAuthorFirst;
    }

    public String getNewAuthorLast() {
        return newAuthorLast;
    }

    public void setNewAuthorLast(String newAuthorLast) {
        this.newAuthorLast = newAuthorLast;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public void addAuthor()
    {
        getAuthorList().add(new Author(this.getNewAuthorFirst(), this.getNewAuthorLast(), this.getBio()));
    }
    
}
