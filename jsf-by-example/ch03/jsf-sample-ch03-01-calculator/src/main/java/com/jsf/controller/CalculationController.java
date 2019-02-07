/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author PC
 */
@Named(value = "calculationController")
@SessionScoped
public class CalculationController implements Serializable {

    private int num1;
    private int num2;
    private int result;
    private String calculationType;
    private static String ADDITION = "Addition";
    private static String SUBTRACTION = "Subtraction";
    private static String MULTIPLICATION = "Multiplication";
    private static String DIVISION = "Division";
    List<SelectItem> calculationList;
    
    public CalculationController() {
        //Inicializamos las variables
        num1 = 0;
        num2 = 0;
        result = 0;
        calculationType = null;
        //Inicializamos la lista de valores para el SelectOneMenu
        populateCalculationList();
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
    
    public String getCalculationType()
    {
        return calculationType;
    }
    
    public void setCalculationType(String calculationType)
    {
        this.calculationType = calculationType;
    }
    
    public List<SelectItem> getCalculationList()
    {
        return calculationList;
    }
    
    private void populateCalculationList()
    {
        calculationList = new ArrayList<SelectItem>();
        calculationList.add(new SelectItem(ADDITION));
        calculationList.add(new SelectItem(SUBTRACTION));
        calculationList.add(new SelectItem(MULTIPLICATION));
        calculationList.add(new SelectItem(DIVISION));
    }
    
    public void performCalculation()
    {
        if(getCalculationType().equals(ADDITION))
        {
            setResult(num1 + num2);
        }
        else if(getCalculationType().equals(SUBTRACTION))
        {
            setResult(num1 - num2);
        }
        else if(getCalculationType().equals(MULTIPLICATION))
        {
            setResult(num1 * num2);
        }
        else if(getCalculationType().equals(DIVISION))
        {
            try
            {
                setResult(num1 / num2);
            }
            catch(Exception ex)
            {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid calculation", "Invalid Calculation");
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            }
        }
    }
}
