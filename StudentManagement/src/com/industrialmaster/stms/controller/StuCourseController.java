/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.controller;

import com.industrialmaster.stms.model.Course;
import com.industrialmaster.stms.model.StuCourses;
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
public class StuCourseController {
    
    
    public static ArrayList<String> getAllStu_ID() throws ClassNotFoundException, SQLException
    {
    
        ArrayList<String> list=new ArrayList<>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select Stu_ID from Students";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               String id=rst.getString("Stu_ID");
               
            
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
    
    
    
    public static boolean Save(StuCourses stuCourses) throws ClassNotFoundException, SQLException{
    
         Connection conn=DB.getConnection();
        
            String sql="Insert into StuCourses values(?,?,?)";
        
             PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, stuCourses.getStu_ID());
            pstm.setString(2, stuCourses.getCourse_ID());
            pstm.setInt(3, stuCourses.getID());
            
           
            if(pstm.executeUpdate()>0)
               return true;
            else
                return false;
            
           
        
    }
    
    public static List<StuCourses> selectAll() throws ClassNotFoundException, SQLException
    {
    
        List<StuCourses> list=new ArrayList<StuCourses>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from StuCourses";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               int sid=rst.getInt("Stu_ID");
               String cid=rst.getString("Course_ID");
               int id=rst.getInt("ID");
               
            StuCourses stuCourses = new StuCourses();
            stuCourses.setStu_ID(sid);
            stuCourses.setCourse_ID(cid);
            stuCourses.setID(id);
               list.add(stuCourses);
               
              }
        
              return list;
    }
    
    public static StuCourses get(int id) throws SQLException, ClassNotFoundException{
        
        StuCourses stucourse=new StuCourses();
        Connection conn=DB.getConnection();
            String sql="select* from stuCourses where ID=?";
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, id);
            ResultSet rst=pstm.executeQuery();
            
            while(rst.next()){
            
               
               int sid=rst.getInt("Stu_ID");
               String cid=rst.getString("Course_ID");
               
               
               stucourse.setCourse_ID(cid);
               stucourse.setStu_ID(sid);
               stucourse.setID(id);
               
                
            }
    
                return stucourse;
    }
    
    public static boolean Delete(int id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        String sql="Delete from StuCourses where ID=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        
        pstm.setInt(1, id);
       
        return pstm.executeUpdate()>0;
        
    }
    
    
    
    
    
    
}
