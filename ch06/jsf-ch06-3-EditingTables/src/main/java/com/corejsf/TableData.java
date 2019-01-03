/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author PC
 */
@Named(value = "tableData")
@SessionScoped
public class TableData implements Serializable {

    private static final Name[] names = new Name[]{
        new Name("William", "Dupont"),
        new Name("Anna", "Keeney"),
        new Name("Mariko", "Randor"),
        new Name("John", "Wilson")
    };
    
    public Name[] getNames()
    {
        return names;
    }
    
    public String save()
    {
        for(Name name : names)
        {
            name.setEditable(false);
        }
        return null;
    }
    
}
