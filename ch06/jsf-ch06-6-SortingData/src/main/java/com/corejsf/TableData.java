/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Comparator;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

/**
 *
 * @author PC
 */
@Named(value = "tableData")
@SessionScoped
public class TableData implements Serializable {

    private SortFilterModel<Name> filterModel;
    private static final Name[] names = 
    {
        new Name("Anna", "Keeney"),
        new Name("John", "Wilson"),
        new Name("Mariko", "Randort"),
        new Name("William", "Dupont")
    };
    
    public TableData() 
    {
        filterModel = new SortFilterModel<Name>(new ArrayDataModel<Name>(names));
    }
    
    public DataModel<Name> getNames()
    {
        return filterModel;
    }
    
    public String sortByFirst()
    {
        filterModel.sortBy(new Comparator<Name>()
        {
            @Override
            public int compare(Name n1, Name n2) {
                return n1.getFirst().compareTo(n2.getFirst());
            }
        });
        return null;
    }
    
    public String sortByLast()
    {
        filterModel.sortBy(new Comparator<Name>() {
            @Override
            public int compare(Name n1, Name n2) {
                return n1.getLast().compareTo(n2.getLast());
            }
        });
        return null;
    }
    
}
