/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.controller;

import com.industrialmaster.stms.model.Course;
import com.industrialmaster.stms.model.TeachCourses;
import com.industrialmaster.stms.model.Student;
import com.industrialmaster.stms.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasi CP
 */
public class TeachCourseController {
    
    
    public static ArrayList<String> getAllTeacher_ID() throws ClassNotFoundException, SQLException
    {
    
        ArrayList<String> list=new ArrayList<>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select Teacher_ID from Teachers";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               String id=rst.getString("Teacher_ID");
               
            
               list.add(id);
               
              }
        
              return list;
    } 
    
     public static ArrayList<String> getAllCourse_ID() throws ClassNotFoundException, SQLException
    {
    
          ArrayList<String> list=new ArrayList<>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select Course_ID from Courses";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               String id=rst.getString("Course_ID");
               
            
               list.add(id);
               
              }
        
              return list;
    } 
    
    
    
    public static boolean Save(TeachCourses teachCourses) throws ClassNotFoundException, SQLException{
    
         Connection conn=DB.getConnection();
        
            String sql="Insert into TeachCourse values(?,?)";
        
             PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, teachCourses.getTeacher_ID());
            pstm.setString(2, teachCourses.getCourse_ID());
           
            
           
            if(pstm.executeUpdate()>0)
               return true;
            else
                return false;
            
           
        
    }
    
    public static List<TeachCourses> selectAll() throws ClassNotFoundException, SQLException
    {
    
        List<TeachCourses> list=new ArrayList<TeachCourses>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from TeachCourse";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               int tid=rst.getInt("Teacher_ID");
               String cid=rst.getString("Course_ID");
               
            TeachCourses teachCourses = new TeachCourses();
            teachCourses.setTeacher_ID(tid);
            teachCourses.setCourse_ID(cid);
               list.add(teachCourses);
               
              }
        
              return list;
    }
    
    public static TeachCourses get(int id) throws SQLException, ClassNotFoundException{
        
        TeachCourses stucourse=new TeachCourses();
        Connection conn=DB.getConnection();
            String sql="select* from teachCourse where Teacher_ID=?";
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, id);
            ResultSet rst=pstm.executeQuery();
            
            while(rst.next()){
            
               
               int tid=rst.getInt("Teacher_ID");
               String cid=rst.getString("Course_ID");
               
               
               stucourse.setCourse_ID(cid);
               stucourse.setTeacher_ID(tid);
               
                
            }
    
                return stucourse;
    }
    
    public static boolean Delete(int id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        String sql="Delete from TeachCourse where Teacher_ID=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        
        pstm.setInt(1, id);
       
        return pstm.executeUpdate()>0;
        
    }
    
    
    
    
    
    
}
