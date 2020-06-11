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
public class Course {

    private String Course_ID;
    private String CourseName;
    private String Duration;
    private Double Fee;

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

    /**
     * @return the CourseName
     */
    public String getCourseName() {
        return CourseName;
    }

    /**
     * @param CourseName the CourseName to set
     */
    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    /**
     * @return the Duration
     */
    public String getDuration() {
        return Duration;
    }

    /**
     * @param Duration the Duration to set
     */
    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    /**
     * @return the Payment
     */
    public Double getFee() {
        return Fee;
    }

    /**
     * @param Payment the Payment to set
     */
    public void setFee(Double Fee) {
        this.Fee = Fee;
    }

}
