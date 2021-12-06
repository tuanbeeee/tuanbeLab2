package DTO;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuanb
 */
public class Student implements Serializable {

    private String studentName;
    private String studentID;

    public Student(String studentID, String studentName) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String toString() {
        return studentID + "-" + studentName;
    }

}
