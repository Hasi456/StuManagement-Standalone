/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.controller;

import com.industrialmaster.stms.model.Notice;
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
public class NoticeController {
    
    
    public static boolean Save(Notice notice) throws ClassNotFoundException, SQLException{
    
         Connection conn=DB.getConnection();
        
            String sql="Insert into notices values(?,?,?)";
        
             PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, notice.getID());
            pstm.setString(2, notice.getTitle());
            pstm.setString(3, notice.getDescription());
      
            
           
            if(pstm.executeUpdate()>0)
               return true;
            else
                return false;
            
           
        
    }
    
    public static List<Notice> selectAll() throws ClassNotFoundException, SQLException
    {
    
        List<Notice> list=new ArrayList<Notice>();
        
        Connection conn=DB.getConnection();
        
         String sql="Select* from notices";
            
           Statement stm=conn.createStatement();
           
           ResultSet rst=stm.executeQuery(sql);
           
           while(rst.next()){
               
               int id=rst.getInt("ID");
               String title=rst.getString("Title");
               String description=rst.getString("Description");
               
               Notice notice=new Notice();
               notice.setID(id);
               notice.setTitle(title);
               notice.setDescription(description);
               
               list.add(notice);
               
              }
        
              return list;
    }
    
    public static Notice get(int id) throws SQLException, ClassNotFoundException{
        
        Notice notice=new Notice();
        Connection conn=DB.getConnection();
            String sql="select* from notices where ID=?";
            
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, id);
            ResultSet rst=pstm.executeQuery();
            
            while(rst.next()){
            
               
         
               String title=rst.getString("Title");
               String description=rst.getString("Description");
               
               
               notice.setID(id);
               notice.setTitle(title);
               notice.setDescription(description);
               
                
            }
    
                return notice;
    }
    
    
    public static boolean Update(Notice notice) throws ClassNotFoundException, SQLException{
        
              Connection conn=DB.getConnection();
        
            String sql="Update notices SET Title=?, Description=? where ID=? ";
        
            PreparedStatement pstm=conn.prepareStatement(sql);
            
            pstm.setString(1, notice.getTitle());
            pstm.setString(3, notice.getDescription());
            pstm.setInt(4, notice.getID());
            
           return pstm.executeUpdate()>0;
        
        
    }
    
    public static boolean Delete(int id) throws ClassNotFoundException, SQLException{
        
        Connection conn=DB.getConnection();
        
        String sql="Delete from notices where ID=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        
        pstm.setInt(1, id);
       
        return pstm.executeUpdate()>0;
        
    }
    
    
    
    
}
