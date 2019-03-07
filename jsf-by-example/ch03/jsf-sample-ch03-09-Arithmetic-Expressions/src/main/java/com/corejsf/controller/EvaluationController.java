/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "evaluationController")
@RequestScoped
public class EvaluationController {

    private boolean field1 = true;
    
    public EvaluationController() {
    }
    
    public boolean expr1()
    {
        return true;
    }
    
    public boolean expr2()
    {
        return false;
    }
    
    public boolean isField1()
    {
        return field1;
    }
    
    public void setField1(boolean field1)
    {
        this.field1 = field1;
    }
}
