/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Named(value = "payment")
@SessionScoped
public class PaymentBean implements Serializable {
    
    @Min(10)
    @Max(10000)
    private double amount;
    
    @Size(min=13, message = "{com.corejsf.creditCardLength}")
    @LuhnCheck
    private String card = "";
    
    @Future
    private Date date = new Date();

    /**
     * Creates a new instance of PaymentBean
     */
    public PaymentBean() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
