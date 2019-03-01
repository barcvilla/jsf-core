/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import com.corejsf.domain.Author;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
@Named(value = "authorController")
@SessionScoped
public class AuthorController implements Serializable {

    private List<Author> authorList = null;
    private String juneauBio
            = "Josh Juneau has been developing software"
            + " since the mid-1990s. PL/SQL development and database programming"
            + " was the focus of his career in the beginning, but as his skills developed,"
            + " he began to use Java and later shifted to it as a primary base for his"
            + " application development. Josh has worked with Java in the form of graphical"
            + " user interface, web, and command-line programming for several years. "
            + "During his tenure as a Java developer, he has worked with many frameworks"
            + " such as JSF, EJB, and JBoss Seam. At the same time, Josh has extended his"
            + " knowledge of the Java Virtual Machine (JVM) by learning and developing applications"
            + " with other JVM languages such as Jython and Groovy. His interest in learning"
            + " new languages that run on the JVM led to his interest in Jython. Since 2006,"
            + " Josh has been the editor and publisher for the Jython Monthly newsletter. "
            + "In late 2008, he began a podcast dedicated to the Jython programming language.";

    private String deaBio = "This is Carl Dea's Bio";
    private String beatyBio = "This is Mark Beaty's Bio";
    private String oConnerBio = "This is John O'Connor's Bio";
    private String guimeBio = "This is Freddy Guime's Bio";
    private Author current;

    public AuthorController() 
    {
        populateAuthorList();
    }
    
    private void populateAuthorList()
    {
        if(authorList == null)
        {
            System.out.println("initializing");
            authorList = new ArrayList<Author>();
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
        return "showAuthorBio";
    }
    
    public List<Author> getAuthorList()
    {
        System.out.println("Getting the author list => " + authorList.size());
        return authorList;
    }
    
    public Author getCurrent()
    {
        return current;
    }
    
    public void setCurrent(Author author)
    {
        this.current = author;
    }
}
