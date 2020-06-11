/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.controller;

import com.industrialmaster.stms.model.Teacher;
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
public class TeacherController {
    
    
    public static boolean Save(Teacher teacher) throws ClassNotFoundException, SQLException{
    
         Connection conn=DB.getConnection();
        
            String sql="Insert into Teachers values(?,?,?,?,?)";
        
             PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, teacher.getTeacher_ID());
            pstm.setString(2, teacher.getFirstName());
            pstm.setString(3, teacher.getLastName());
            pstm.setString(4, teacher.getAddress());
            pstm.setString(5, teacher.getPhone_No());
            
           
            if(pstm.executeUpdate()>0)
               return true;
            else
                return false;
            
           
        
    }
    
    public static List<Teacher> selectAll() throws ClassNotFoundException, SQLException
    {
    
        List<Teacher> list=new ArrayList<Teacher>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from Teachers";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               int id=rst.getInt("Teacher_ID");
               String Fname=rst.getString("FirstName");
               String Lname=rst.getString("LastName");
               String Addr=rst.getString("Address");
               String Phone_no=rst.getString("Phone_No");
               
               Teacher teacher=new Teacher();
               teacher.setTeacher_ID(id);
               teacher.setFirstName(Fname);
               teacher.setLastName(Lname);
               teacher.setAddress(Addr);
               teacher.setPhone_No(Phone_no);
               
               list.add(teacher);
               
              }
        
              return list;
    }
    
    public static Teacher get(int id) throws SQLException, ClassNotFoundException{
        
        Teacher teacher=new Teacher();
        Connection conn=DB.getConnection();
            String sql="select* from teachers where Teacher_ID=?";
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, id);
            ResultSet rst=pstm.executeQuery();
            
            while(rst.next()){
            
               String Fname=rst.getString("FirstName");
               String Lname=rst.getString("LastName");
               String Addr=rst.getString("Address");
               String Phone_no=rst.getString("Phone_No");
               
               
               teacher.setFirstName(Fname);
               teacher.setLastName(Lname);
               teacher.setAddress(Addr);
               teacher.setPhone_No(Phone_no);
                
            }
    
                return teacher;
    }
    
    
    public static boolean Update(Teacher teacher) throws ClassNotFoundException, SQLException{
        
              Connection conn=DB.getConnection();
        
            String sql="Update Teachers SET FirstName=?, LastName=?, Address=?, Phone_No=? where Teacher_ID=? ";
        
            PreparedStatement pstm=conn.prepareStatement(sql);
            
            pstm.setString(1, teacher.getFirstName());
            pstm.setString(2, teacher.getLastName());
            pstm.setString(3, teacher.getAddress());
            pstm.setString(4, teacher.getPhone_No());
            pstm.setInt(5, teacher.getTeacher_ID());
            
           return pstm.executeUpdate()>0;
        
        
    }
    
    public static boolean Delete(int id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        String sql="Delete from Teachers where Teacher_ID=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        
        pstm.setInt(1, id);
       
        return pstm.executeUpdate()>0;
        
    }
    
    
    
    
}
