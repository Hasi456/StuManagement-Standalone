/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.controller;

import com.industrialmaster.stms.model.Course;
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
public class CourseController {
    
    
    public static boolean Save(Course course) throws ClassNotFoundException, SQLException{
    
         Connection conn=DB.getConnection();
        
            String sql="Insert into Courses values(?,?,?,?)";
        
             PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setString(1, course.getCourse_ID());
            pstm.setString(2, course.getCourseName());
            pstm.setString(3, course.getDuration());
            pstm.setDouble(4, course.getFee());
      
            
           
            if(pstm.executeUpdate()>0)
               return true;
            else
                return false;
            
           
        
    }
    
    public static List<Course> selectAll() throws ClassNotFoundException, SQLException
    {
    
        List<Course> list=new ArrayList<Course>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from Courses";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               String id=rst.getString("Course_ID");
               String Cname=rst.getString("CourseName");
               String duration=rst.getString("Duration");
               Double fee=rst.getDouble("Fee");
               
               Course course=new Course();
               course.setCourse_ID(id);
               course.setCourseName(Cname);
               course.setDuration(duration);
               course.setFee(fee);
               
               list.add(course);
               
              }
        
              return list;
    }
    
    public static Course get(String id) throws SQLException, ClassNotFoundException{
        
        Course course=new Course();
        Connection conn=DB.getConnection();
            String sql="select* from courses where Course_ID=?";
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setString(1, id);
            ResultSet rst=pstm.executeQuery();
            
            while(rst.next()){
            
               
               String Cname=rst.getString("CourseName");
               String duration=rst.getString("Duration");
               Double fee=rst.getDouble("Fee");
               
               
               course.setCourse_ID(id);
               course.setCourseName(Cname);
               course.setDuration(duration);
               course.setFee(fee);
               
                
            }
    
                return course;
    }
    
    
    public static boolean Update(Course course) throws ClassNotFoundException, SQLException{
        
              Connection conn=DB.getConnection();
        
            String sql="Update Courses SET CourseName=?, Duration=?, Fee=? where Course_ID=? ";
        
            PreparedStatement pstm=conn.prepareStatement(sql);
            
            pstm.setString(1, course.getCourseName());
            pstm.setString(2, course.getDuration());
            pstm.setDouble(3, course.getFee());
            pstm.setString(4, course.getCourse_ID());
            
           return pstm.executeUpdate()>0;
        
        
    }
    
    public static boolean Delete(String id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        String sql="Delete from Courses where Course_ID=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        
        pstm.setString(1, id);
       
        return pstm.executeUpdate()>0;
        
    }
    
    
    
    
}
