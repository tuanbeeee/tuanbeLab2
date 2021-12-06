package DTO;

import DTO.Vaccine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuanb
 */
public class WriteVaccine extends ArrayList<Vaccine> {

    public void addVaccine() {

        Vaccine v1 = new Vaccine("V001", "Astra Zeneca");
        Vaccine v2 = new Vaccine("V002", "SPUTNIK V");
        Vaccine v3 = new Vaccine("V003", "Vero Cell");
        Vaccine v4 = new Vaccine("V004", "Pfrizer");
        Vaccine v5 = new Vaccine("V005", "Moderna");
        this.add(v1);
        this.add(v2);
        this.add(v3);
        this.add(v4);
        this.add(v5);
    }

    public boolean addFromFile() throws IOException {
        if (this.size() > 0) {
            this.clear();
        }
        try {
            File f = new File("Vaccine.dat");
            if (!f.exists()) {
                return false;
            }
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Vaccine vac;
            while ((vac = (Vaccine) (fo.readObject())) != null) {
                this.add(vac);
            }
            fo.close();
            fi.close();
        } catch (Exception e) {

        }
        return true;
    }

    public boolean saveToFile() {
        try {
            FileOutputStream f = new FileOutputStream("Vaccine.dat");
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Vaccine vac : this) {
                fo.writeObject(vac);
            }
            fo.close();
            f.close();
        } catch (Exception e) {

        }
        return true;
    }

}
