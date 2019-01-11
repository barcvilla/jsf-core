/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.util.Arrays;
import java.util.Comparator;
import javax.faces.model.DataModel;

/**
 * Sorting model que contiene un regular model y un array de integers rows, donde rows[i] indica el indice del
 * indice del modelo de dato que deberia ser mostrado en la fila ith. Para ordenar el array en diferentes formas
 * ordenamos los indices de fila.
 * 
 * @author PC
 */
public class SortFilterModel<E> extends DataModel<E> {
    private DataModel<E> model;
    private Integer[] rows;
    
    //Obligatorio por la especificacion JSF
    public SortFilterModel()
    {
        setWrappedData(null);
    }
    
    //recomendado por la especificacion JSF
    public SortFilterModel(E[] names)
    {
        setWrappedData(names);
    }
    
    public SortFilterModel(DataModel<E> model)
    {
        this.model = model;
        initializeRows();
    }
    
    private E getData(int row)
    {
        int originalIndex = model.getRowIndex();
        model.setRowIndex(row);
        E thisRowData = model.getRowData();
        model.setRowIndex(originalIndex);
        return thisRowData;
    }
    
    public void sortBy(final Comparator<E> dataComp)
    {
        Comparator<Integer> rowComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer r1, Integer r2) 
            {
                E e1 = getData(r1);
                E e2 = getData(r2);
                return dataComp.compare(e1, e2);
            }
        };
        Arrays.sort(rows, rowComp);
    }
    
    // Retorna true si hay una dato valido en el indice de fila actual
    @Override
    public boolean isRowAvailable() {
        return model.isRowAvailable();
    }
    
    /**
     * retorna el numero total de filas, si se conoce, de lo contrario retorna -1. el ResultSetDataModel siempre
     * retorna -1 de este metodo.
     * @return 
     */
    @Override
    public int getRowCount() {
        return model.getRowCount();
    }
    
    // retorna el dato asociado con la fila actual
    @Override
    public E getRowData() {
        return model.getRowData();
    }
    
    // obtenemos el indice de la fila actual
    @Override
    public int getRowIndex() {
        return model.getRowIndex();
    }
    
    /**
     * Establecemos el indice de la fila actual
     * @param rowIndex 
     */
    @Override
    public void setRowIndex(int rowIndex) {
        if(0 <= rowIndex && rowIndex < rows.length)
        {
            model.setRowIndex(rows[rowIndex]);
        }
        else
        {
            model.setRowIndex(rowIndex);
        }
    }
    
    // retorna el dato envuelto del data model
    @Override
    public Object getWrappedData() {
        return model.getWrappedData();
    }
    
    // Establece el objeto que un data model envuelve
    @Override
    public void setWrappedData(Object data) {
        model.setWrappedData(data);
        initializeRows();
    }
    
    private void initializeRows()
    {
        int rowCnt = model.getRowCount();
        if(rowCnt != -1)
        {
            rows = new Integer[rowCnt];
            for(int i = 0; i < rowCnt; i++)
            {
                rows[i] = i;
            }
        }
    }
}
    