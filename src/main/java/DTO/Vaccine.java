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
public class Vaccine implements Serializable {

    private String vaccineID;
    private String vaccineName;

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

    public Vaccine(String vaccineID, String vaccineName) {
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
    }

    
    @Override
    public String toString() {
        return vaccineID + "-" + vaccineName ;
    }
}
