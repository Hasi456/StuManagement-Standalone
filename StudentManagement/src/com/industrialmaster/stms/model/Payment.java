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
public class Payment {
    
    private int Payment_ID;
    private int Student_ID;
    private String CourseID;
    private Double PaidAmount;

    /**
     * @return the Payment_ID
     */
    public int getPayment_ID() {
        return Payment_ID;
    }

    /**
     * @param Payment_ID the Payment_ID to set
     */
    public void setPayment_ID(int Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    /**
     * @return the Student_ID
     */
    public int getStudent_ID() {
        return Student_ID;
    }

    /**
     * @param Student_ID the Student_ID to set
     */
    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    /**
     * @return the CourseID
     */
    public String getCourseID() {
        return CourseID;
    }

    /**
     * @param CourseID the CourseID to set
     */
    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    /**
     * @return the PaidAmount
     */
    public Double getPaidAmount() {
        return PaidAmount;
    }

    /**
     * @param PaidAmount the PaidAmount to set
     */
    public void setPaidAmount(Double PaidAmount) {
        this.PaidAmount = PaidAmount;
    }
}
