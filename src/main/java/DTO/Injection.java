package DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuanb
 */
public class Injection implements Serializable {

    private String injectionID;
    private String injectionPlace1;
    private String injectionPlace2;
    private Date injectionDate1;
    private String injectionDate2;
    private String studentName;
    private String studentID;
    private String vaccineID;
    private String vaccineName;

    public Injection(String injectionID, String studentID, String studentName, String vaccineID, String vaccineName, String injectionPlace1, Date injectionDate1, String injectionPlace2, String injectionDate2) {
        this.injectionID = injectionID;
        this.injectionPlace1 = injectionPlace1;
        this.injectionPlace2 = injectionPlace2;
        this.injectionDate1 = injectionDate1;
        this.injectionDate2 = injectionDate2;
        this.studentName = studentName;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID1) {
        this.injectionID = injectionID1;
    }

    public String getInjectionPlace1() {
        return injectionPlace1;
    }

    public void setInjectionPlace1(String injectionPlace1) {
        this.injectionPlace1 = injectionPlace1;
    }

    public String getInjectionPlace2() {
        return injectionPlace2;
    }

    public void setInjectionPlace2(String injectionPlace2) {
        this.injectionPlace2 = injectionPlace2;
    }

    public Date getInjectionDate1() {
        return injectionDate1;
    }

    public void setInjectionDate1(Date injectionDate1) {
        this.injectionDate1 = injectionDate1;
    }

    public String getInjectionDate2() {
        return injectionDate2;
    }

    public void setInjectionDate2(String injectionDate2) {
        this.injectionDate2 = injectionDate2;
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

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return "Injection ID : " + injectionID + "\n"
                + "Student ID : " + studentID + "\n"
                + "Student Name : " + studentName + "\n"
                + "Vaccine ID : " + vaccineID + "\n"
                + "Vaccine Name :" + vaccineName + "\n"
                + "First Place : " + injectionPlace1 + "\n"
                + "First Date " + df.format(injectionDate1) + "\n"
                + "Second Place : " + injectionPlace2 + "\n"
                + "Second Date : " + injectionDate2 + "\n";
    }
}
