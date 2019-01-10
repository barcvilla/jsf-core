/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Name implements Serializable {

    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public void setFirst(String newValue) {
        first = newValue;
    }

    public String getFirst() {
        return first;
    }

    public void setLast(String newValue) {
        last = newValue;
    }

    public String getLast() {
        return last;
    }
}
