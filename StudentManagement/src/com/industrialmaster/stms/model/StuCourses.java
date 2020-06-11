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
public class StuCourses {
    
    private int Stu_ID;
    private String Course_ID;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    /**
     * @return the Stu_ID
     */
    public int getStu_ID() {
        return Stu_ID;
    }

    /**
     * @param Stu_ID the Stu_ID to set
     */
    public void setStu_ID(int Stu_ID) {
        this.Stu_ID = Stu_ID;
    }

    /**
     * @return the Course_ID
     */
    public String getCourse_ID() {
        return Course_ID;
    }

    /**
     * @param Course_ID the Course_ID to set
     */
    public void setCourse_ID(String Course_ID) {
        this.Course_ID = Course_ID;
    }
}
