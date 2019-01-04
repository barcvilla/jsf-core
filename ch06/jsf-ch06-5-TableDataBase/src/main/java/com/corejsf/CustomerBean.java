/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "customerBean")
@RequestScoped
public class CustomerBean {

    CustomerDAO customerDAO = new CustomerDAO();

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        try 
        {
            customers = customerDAO.getAllCustomers();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return customers;
    }
}
