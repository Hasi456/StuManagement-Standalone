/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.stms.model;

/**
 *
 * @author Hasi CP
 */
public class Student {
    
    private int Stu_ID;
    private String FirstName;
    private String LastName;
    private String Address;
    private String Phone_No;

    public int getStu_ID() {
        return Stu_ID;
    }

    public void setStu_ID(int Stu_ID) {
        this.Stu_ID = Stu_ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone_No() {
        return Phone_No;
    }

    public void setPhone_No(String Phone_No) {
        this.Phone_No = Phone_No;
    }
    
    
}
