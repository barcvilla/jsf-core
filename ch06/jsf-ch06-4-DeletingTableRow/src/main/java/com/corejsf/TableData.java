/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author PC
 */
@Named(value = "tableData")
@SessionScoped
public class TableData implements Serializable {

    private ArrayList<Name> names = new ArrayList<Name>(Arrays.asList(
      new Name("Anna", "Keeney"),
      new Name("John", "Wilson"),
      new Name("Mariko", "Randor"),
      new Name("William", "Dupont")
   ));
    
    public ArrayList<Name> getNames()
    {
        return names;
    }
    
    public String deleteRow(Name nameToDelete)
    {
        names.remove(nameToDelete);
        return null;
    }
}
