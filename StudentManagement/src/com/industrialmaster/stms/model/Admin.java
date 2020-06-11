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
public class Admin {
    
    private int Admin_ID;
    private String FirstName;
    private String LastName;
    private String Phone_No;

    /**
     * @return the Admin_ID
     */
    public int getAdmin_ID() {
        return Admin_ID;
    }

    /**
     * @param Admin_ID the Admin_ID to set
     */
    public void setAdmin_ID(int Admin_ID) {
        this.Admin_ID = Admin_ID;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the Phone_No
     */
    public String getPhone_No() {
        return Phone_No;
    }

    /**
     * @param Phone_No the Phone_No to set
     */
    public void setPhone_No(String Phone_No) {
        this.Phone_No = Phone_No;
    }
    
    
}
