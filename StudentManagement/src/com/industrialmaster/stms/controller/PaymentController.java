/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.controller;

import com.industrialmaster.stms.model.Course;
import com.industrialmaster.stms.model.Payment;
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
public class PaymentController {
    
    
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
    
      public static Course getCourseFee(String id) throws ClassNotFoundException, SQLException
    {
    
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from Courses where Course_ID=?";
         
         Course cs=new Course();
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setString(1, id);
           
           
           ResultSet rst=pstm.executeQuery();
           
           while(rst.next()){
               
               String Cname=rst.getString("CourseName");
               String duration=rst.getString("Duration");
               Double fee=rst.getDouble("Fee");
               
               
               cs.setCourse_ID(id);
               cs.setCourseName(Cname);
               cs.setDuration(duration);
               cs.setFee(fee);
              }
        
              return cs;
    } 
    
    
    public static boolean Save(Payment pay) throws ClassNotFoundException, SQLException{
    
         Connection conn=DB.getConnection();
        
            String sql="Insert into Payment_details (Student_ID,CourseID,PaidAmount) values(?,?,?)";
        
             PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, pay.getStudent_ID());
            pstm.setString(2, pay.getCourseID());
            pstm.setDouble(3, pay.getPaidAmount());
            
           
            if(pstm.executeUpdate()>0)
               return true;
            else
                return false;
            
           
        
    }
    
    public static List<Payment> selectAll() throws ClassNotFoundException, SQLException
    {
    
        List<Payment> list=new ArrayList<Payment>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from Payment_details";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               int pid=rst.getInt("Payment_ID");
               int sid=rst.getInt("Student_ID");
               String cid=rst.getString("CourseID");
               Double paid=rst.getDouble("PaidAmount");
               
            Payment pay = new Payment();
            pay.setPayment_ID(pid);
            pay.setStudent_ID(sid);
            pay.setCourseID(cid);
            pay.setPaidAmount(paid);
               list.add(pay);
               
              }
        
              return list;
    }
    
    public static Payment get(int id) throws SQLException, ClassNotFoundException{
        
        Payment pay=new Payment();
        Connection conn=DB.getConnection();
            String sql="select* from Payment_details where Payment_ID=?";
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, id);
            ResultSet rst=pstm.executeQuery();
            
            while(rst.next()){
            
               int pid=rst.getInt("Payment_ID");
               int sid=rst.getInt("Student_ID");
               String cid=rst.getString("CourseID");
               Double paid=rst.getDouble("PaidAmount");
               
               pay.setPayment_ID(pid);
               pay.setCourseID(cid);
               pay.setStudent_ID(sid);
               pay.setPaidAmount(paid);
               
                
            }
    
                return pay;
    }
    
    public static boolean Delete(int id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        String sql="Delete from Payment_details where Payment_ID=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        
        pstm.setInt(1, id);
       
        return pstm.executeUpdate()>0;
        
    }
    
    
    public static boolean Update(Payment pay) throws ClassNotFoundException, SQLException{
        
       Connection conn=DB.getConnection();
       
       String sql="Update Payment_details SET PaidAmount=? where Payment_ID=?";
       
       PreparedStatement pstm=conn.prepareStatement(sql);
       pstm.setDouble(1, pay.getPaidAmount());
       pstm.setDouble(2, pay.getPayment_ID());
       
       return pstm.executeUpdate()>0;
        
    }
    
    
    
    
    
}
