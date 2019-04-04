/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.controller;

import com.corejsf.domain.Author;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Bean usado que contiene la logica del negocio usado para el componente
 * @author PC
 */
@Named(value = "searchController")
@RequestScoped
public class SearchController implements Serializable{

    private String searchText;
    private String errorText;
    
    @Inject
    private AuthorController authorController;
    
    public SearchController() {
    }
    
    public String searchAuthors(List<Author> authorList)
    {
        String fullName = null;
        String returnString = null;
        
        for(Author author : authorList)
        {
            fullName = author.getFirst() + " " + author.getLast();
            if(author.getFirst().equalsIgnoreCase(searchText))
            {
                returnString = getAuthorController().displayAuthor(author.getLast());
            }
            else if(author.getLast().equalsIgnoreCase(searchText))
            {
                returnString = getAuthorController().displayAuthor(author.getLast());
            }
            else if(fullName.equalsIgnoreCase(searchText))
            {
                returnString = getAuthorController().displayAuthor(author.getLast());
            }
        }
        if(returnString == null)
        {
            setErrorText("No author found");
            returnString = "example04_04a";
        }
        return returnString;
    }
    
    public String getSearchText()
    {
        return searchText;
    }
    
    public void setSearchText(String searchText)
    {
        this.searchText = searchText;
    }
    
    public AuthorController getAuthorController()
    {
        return authorController;
    }
    
    public void setAuthorController(AuthorController authorController)
    {
        this.authorController = authorController;
    }
    
    public String getErrorText()
    {
        return errorText;
    }
    
    public void setErrorText(String errorText)
    {
        this.errorText = errorText;
    }
}
