/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.model;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Author implements Serializable{
    private String first;
    private String last;
    private String bio;
    
    public Author()
    {
        this.first = null;
        this.last = null;
        this.bio = null;
    }
    
    public Author(String first, String last, String bio)
    {
        this.first = first;
        this.last = last;
        this.bio = bio;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
    
}
