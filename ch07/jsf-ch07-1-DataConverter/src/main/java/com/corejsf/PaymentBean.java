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

/**
 * Conversion de Numeros y Fechas
 * Una app web almancena muchos tipos de datos, pero las interfaces de usuario web trata exclusivamente con strings.
 * Por ejemplo, supongamos qe el usuario necesita editar un objeto Date que es almacenado en la logica de negocio.
 * Primero, el objeto Date es convertido a String que es enviado al client browser para ser mostrado en el input text
 * El usuario luego edita el text field. El string resultante es retornado al server y debe ser convertido a tipo Date  
 * @author PC
 */
@Named(value = "payment")
@SessionScoped
public class PaymentBean implements Serializable {
    
    private double amount;
    private String card = "";
    private Date date = new Date();
    
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
