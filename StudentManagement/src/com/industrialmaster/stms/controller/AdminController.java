/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.controller;

import com.industrialmaster.stms.model.Admin;
import com.industrialmaster.stms.util.DB;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hasi CP
 */
public class AdminController {
    
    
    public static boolean Save(Admin admin) throws ClassNotFoundException, SQLException{
    
         Connection conn=DB.getConnection();
        
            String sql="Insert into Admins values(?,?,?,?)";
        
             PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, admin.getAdmin_ID());
            pstm.setString(2, admin.getFirstName());
            pstm.setString(3, admin.getLastName());
            pstm.setString(4, admin.getPhone_No());
            
           
            if(pstm.executeUpdate()>0)
               return true;
            else
                return false;
            
           
        
    }
    
    public static List<Admin> selectAll() throws ClassNotFoundException, SQLException
    {
    
        List<Admin> list=new ArrayList<Admin>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from Admins";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               int id=rst.getInt("Admin_ID");
               String Fname=rst.getString("FirstName");
               String Lname=rst.getString("LastName");
               String Phone_no=rst.getString("Phone_No");
               
               Admin admin=new Admin();
               admin.setAdmin_ID(id);
               admin.setFirstName(Fname);
               admin.setLastName(Lname);
               admin.setPhone_No(Phone_no);
               
               list.add(admin);
               
              }
        
              return list;
    }
    
    public static Admin get(int id) throws SQLException, ClassNotFoundException{
        
        Admin admin=new Admin();
        Connection conn=DB.getConnection();
            String sql="select* from admins where Admin_ID=?";
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, id);
            ResultSet rst=pstm.executeQuery();
            
            while(rst.next()){
            
               String Fname=rst.getString("FirstName");
               String Lname=rst.getString("LastName");
               String Phone_no=rst.getString("Phone_No");
               
               
               admin.setFirstName(Fname);
               admin.setLastName(Lname);
               admin.setPhone_No(Phone_no);
                
            }
    
                return admin;
    }
    
    
    public static boolean Update(Admin admin) throws ClassNotFoundException, SQLException{
        
              Connection conn=DB.getConnection();
        
            String sql="Update Admins SET FirstName=?, LastName=?,Phone_No=? where Admin_ID=? ";
        
            PreparedStatement pstm=conn.prepareStatement(sql);
            
            pstm.setString(1, admin.getFirstName());
            pstm.setString(2, admin.getLastName());
            pstm.setString(3, admin.getPhone_No());
            pstm.setInt(4, admin.getAdmin_ID());
            
           return pstm.executeUpdate()>0;
        
        
    }
    
    public static boolean Delete(int id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        String sql="Delete from Admins where Admin_ID=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        
        pstm.setInt(1, id);
       
        return pstm.executeUpdate()>0;
        
    }
    
    
    
    
}
