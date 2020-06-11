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
public class TeachCourses {
    
    private int Teacher_ID;
    private String Course_ID;

    /**
     * @return the Teacher_ID
     */
    public int getTeacher_ID() {
        return Teacher_ID;
    }

    /**
     * @param Teacher_ID the Teacher_ID to set
     */
    public void setTeacher_ID(int Teacher_ID) {
        this.Teacher_ID = Teacher_ID;
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
