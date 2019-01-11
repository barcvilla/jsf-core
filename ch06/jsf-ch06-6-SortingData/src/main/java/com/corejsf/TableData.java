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
 * Cuando Usamos Java Objects como: array, List, ResultSet o JSTL result object representa table data.
 * h:dataTable envuelte estos objetos en un modelo que extiende de la clase javax.faces.model.DataModel. Todos estos
 * model classes pueden ser:
 * ArrayDataModel
 * ListDataModel
 * ResultDataModel
 * ResultSetDataModel
 * ScalarDataModel
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
        // Creamos una instancia del ArrayDataModel y le pasamos un array de elementos. Luego envolvemos el modelo
        // en un sorting model. 
        filterModel = new SortFilterModel<Name>(new ArrayDataModel<Name>(names));
    }
    
    /**
     * Metodo llamado para poblar el Data table. 
     * @return - retorna el sroting model
     */
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
