/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import com.corejsf.db.CConnection;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author PC
 */
public class CustomerDAO 
{
    /*
    @Resource(name = "jdbc/jsfcore")
    private DataSource ds;
    */
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    private Customer convert(ResultSet rs) throws SQLException
    {
        Customer customer = new Customer();
        customer.setId(rs.getInt("cust_id"));
        customer.setName(rs.getString("name"));
        customer.setPhone(rs.getString("phone_number"));
        customer.setAddress(rs.getString("street_address"));
        customer.setCity(rs.getString("city"));
        customer.setState(rs.getString("state"));
        return customer;
    }
    
    public List<Customer> getAllCustomers()throws SQLException
    {
        List<Customer> customers = new ArrayList<Customer>();
        try
        {
            //conn = ds.getConnection();
            conn = new CConnection().connect();
            pstmt = conn.prepareStatement("select * from customers");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Customer cust = convert(rs);
                customers.add(cust);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeResources();
        }
        return customers;
    }
    
    private void closeResources()
    {
        try
        {
            if(rs != null)
            {
                rs.close();
            }
            if(pstmt != null)
            {
                pstmt.close();
            }
            if(conn != null)
            {
                conn.close();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
