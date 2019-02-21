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
public class Employee implements Serializable{
    private String employeeFirst;
    private String employeeLast;
    private String employeeTitle;
    
    public Employee()
    {
        employeeFirst = null;
        employeeLast = null;
        employeeTitle = null;
    }
    
    public Employee(String first, String last, String title)
    {
        employeeFirst = first;
        employeeLast = last;
        employeeTitle = title;
    }

    public String getEmployeeFirst() {
        return employeeFirst;
    }

    public void setEmployeeFirst(String employeeFirst) {
        this.employeeFirst = employeeFirst;
    }

    public String getEmployeeLast() {
        return employeeLast;
    }

    public void setEmployeeLast(String employeeLast) {
        this.employeeLast = employeeLast;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }
    
}
