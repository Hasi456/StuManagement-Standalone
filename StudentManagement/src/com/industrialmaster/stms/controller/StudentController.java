/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.controller;

import com.industrialmaster.stms.model.StuCourses;
import com.industrialmaster.stms.model.Student;
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
public class StudentController {
    
    
    public static boolean Save(Student student) throws ClassNotFoundException, SQLException{
    
         Connection conn=DB.getConnection();
        
            String sql="Insert into Students values(?,?,?,?,?)";
        
             PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, student.getStu_ID());
            pstm.setString(2, student.getFirstName());
            pstm.setString(3, student.getLastName());
            pstm.setString(4, student.getAddress());
            pstm.setString(5, student.getPhone_No());
            
           
            if(pstm.executeUpdate()>0)
               return true;
            else
                return false;
            
           
        
    }
    
    public static List<Student> selectAll() throws ClassNotFoundException, SQLException
    {
    
        List<Student> list=new ArrayList<Student>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from Students";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               int id=rst.getInt("Stu_ID");
               String Fname=rst.getString("FirstName");
               String Lname=rst.getString("LastName");
               String Addr=rst.getString("Address");
               String Phone_no=rst.getString("Phone_No");
               
               Student student=new Student();
               student.setStu_ID(id);
               student.setFirstName(Fname);
               student.setLastName(Lname);
               student.setAddress(Addr);
               student.setPhone_No(Phone_no);
               
               list.add(student);
               
              }
        
              return list;
    }
    
    
    public static Student get(int id) throws SQLException, ClassNotFoundException{
        
        Student student=new Student();
        Connection conn=DB.getConnection();
            String sql="select* from students where Stu_ID=?";
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, id);
            ResultSet rst=pstm.executeQuery();
            
            while(rst.next()){
            
               String Fname=rst.getString("FirstName");
               String Lname=rst.getString("LastName");
               String Addr=rst.getString("Address");
               String Phone_no=rst.getString("Phone_No");
               
               
               student.setFirstName(Fname);
               student.setLastName(Lname);
               student.setAddress(Addr);
               student.setPhone_No(Phone_no);
                
            }
    
                return student;
                
    }
    
    
    
    public static boolean Update(Student student) throws ClassNotFoundException, SQLException{
        
              Connection conn=DB.getConnection();
        
            String sql="Update Students SET FirstName=?, LastName=?, Address=?, Phone_No=? where Stu_ID=? ";
        
            PreparedStatement pstm=conn.prepareStatement(sql);
            
            pstm.setString(1, student.getFirstName());
            pstm.setString(2, student.getLastName());
            pstm.setString(3, student.getAddress());
            pstm.setString(4, student.getPhone_No());
            pstm.setInt(5, student.getStu_ID());
            
           return pstm.executeUpdate()>0;
        
        
    }
    
    public static boolean Delete(int id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        String sql="Delete from Students where Stu_ID=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        
        pstm.setInt(1, id);
       
        return pstm.executeUpdate()>0;
        
    }
    
    public static List<StuCourses> getCourses(int id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        List<StuCourses> list = new ArrayList<StuCourses>();
        
        String sql="select * from StuCourses where Stu_ID=?";
        
        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.setObject(1, id);
        ResultSet rst=pstm.executeQuery();
        
        StuCourses stuc=new StuCourses();
        
        while(rst.next()){
        int StId=rst.getInt("Stu_ID");
        String Cid=rst.getString("Course_ID");
        
        stuc.setStu_ID(StId);
        stuc.setCourse_ID(Cid);
        list.add(stuc);
        
        }
        return list;
        }
    
    
    
}
