package DAO;

import Util.Util;
import DTO.WriteStudent;
import DTO.WriteVaccine;
import DTO.Injection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuanb
 */
public class VaccineManager {

    ArrayList<Injection> list = new ArrayList<>();
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public void addInjecttion() throws ParseException, IOException {
        WriteStudent stuList = new WriteStudent();
        stuList.addStudent();
        stuList.saveToFile();
        stuList.addFromFile();

        String i;
        boolean wrong = false;
        do {
            Date injDate1;
            String injDate2 = null;
            String idStu;
            String nameStu;
            String idVac;
            String nameVac;
            String fplace2 = null;
            Scanner sc = new Scanner(System.in);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            boolean checkID = false;
            String ID;
            WriteStudent a = new WriteStudent();
            a.addStudent();
            a.saveToFile();
            a.addFromFile();
            WriteVaccine b = new WriteVaccine();
            b.addVaccine();
            b.saveToFile();
            b.addFromFile();
            System.out.println("Student List");
            for (int stu = 0; stu < a.size(); stu++) {
                System.out.println(a.get(stu));
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Vaccine List");
            for (int vac = 0; vac < b.size(); vac++) {
                System.out.println(b.get(vac));
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            do {
                ID = Util.checkInputIDINJString();
                checkID = true;
                for (Injection injection : list) {
                    if (injection.getInjectionID().equals(ID)) {
                        System.out.println("You input a duplicate ID ! ");
                        checkID = false;
                    }
                }
            } while (checkID == false);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

            do {
                Util u = new Util();
                do {
                    idStu = Util.checkInputIDStuString();
                    checkID = true;
                    for (Injection injection : list) {
                        if (injection.getStudentID().equals(idStu)) {
                            System.out.println("You input a duplicate ID, please input Student ID again ! ");
                            checkID = false;
                        }
                    }
                } while (checkID == false);
                nameStu = u.inputStu(idStu);
                if (nameStu == null) {
                    System.out.println("ID Student doesnot exist !");
                }
            } while (nameStu == null);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            do {
                Util w = new Util();
                idVac = Util.checkInputIDVacString();
                nameVac = w.inputVac(idVac);
                if (nameVac == null) {
                    System.out.println("ID Vaccine doesnot exist !");
                }
            } while (nameVac == null);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            String fplace1 = Util.input1PlaceString();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            injDate1 = Util.inputDate();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            wrong = false;
            System.out.println("Do you want input second place YES/NO?");
            do {
                if (wrong) {
                    System.out.println("Please enter \"yes\" or \"no\" correctly.  ! ");
                }
                sc = new Scanner(System.in);
                i = sc.nextLine().toUpperCase().trim();
                wrong = true;
                if ("YES".equals(i)) {
                    fplace2 = Util.input2PlaceString();
                }
                if ("NO".equals(i)) {
                }
            } while (!"YES".equals(i) && !"NO".equals(i));
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            if (fplace2 == null || fplace2.isEmpty() || fplace2.isBlank()) {
            } else {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                injDate2 = df.format(Util.inputCheckSecondDate(injDate1));
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            list.add(new Injection(ID, idStu, nameStu, idVac, nameVac, fplace1, injDate1, fplace2, injDate2));
            wrong = false;
            System.out.println("Do you want to continue add injection YES/NO?");
            do {

                if (wrong) {
                    System.out.println("Please enter \"yes\" or \"no\" correctly.  ! ");
                }
                sc = new Scanner(System.in);
                i = sc.nextLine().toUpperCase().trim();
                wrong = true;
            } while (!"YES".equals(i) && !"NO".equals(i));
        } while ("YES".equals(i));
        System.out.println("Add injection successfullly !");
    }

    public void showInfo() {
        do {
            if (list.isEmpty()) {
                System.out.println("Injection Info list is empty, cannot show info!");
                break;
            }
            System.out.println("Show Injection Info List");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Injection injection : list) {

                System.out.println("Injection ID : " + injection.getInjectionID());
                System.out.println("Student ID : " + injection.getStudentID());
                System.out.println("Student Name : " + injection.getStudentName());
                System.out.println("Vaccine ID : " + injection.getVaccineID());
                System.out.println("Vaccine Name : " + injection.getVaccineName());
                System.out.println("Injection Place 1 : " + injection.getInjectionPlace1());
                System.out.println("Injection Date 1 : " + df.format(injection.getInjectionDate1()));
                System.out.println("Injection Place 2 : " + injection.getInjectionPlace2());
                System.out.println("Injection Date 2 : " + (injection.getInjectionDate2()));
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } while (false);
    }

    public void updatebyID() throws ParseException {
        String injDate2;
        String place2;
        String i;
        Scanner sc = new Scanner(System.in);
        boolean checkID = false;
        do {
            if (list.isEmpty()) {
                System.out.println("Injection list is empty, cannot update!");
                break;
            }

            boolean wrong = false;
            do {
                do {
                    System.out.println("Enter Injection's ID to update :");
                    String injID = Util.checkReinputIDINJString();
                    checkID = true;
                    Injection found = null;
                    Date date1 = null;
                    for (int a = 0; a < list.size(); a++) {

                        if (list.get(a).getInjectionID().equals(injID)) {
                            if (list.get(a).getInjectionPlace2() != null) {
                                found = list.get(a);
                                System.out.println("Student received 2 injections");
                                break;
                            }

                            found = list.get(a);
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                            place2 = Util.input2PlaceString();
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                            injDate2 = df.format(Util.inputCheckSecondDate(list.get(a).getInjectionDate1()));
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                            list.get(a).setInjectionPlace2(place2);
                            list.get(a).setInjectionDate2(injDate2);
                            System.out.println("Update injection successfully !");
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println(list.get(a));
                            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                            checkID = true;
                        }
                    }
                    if (found == null) {
                        System.out.println("Injection doesn't exist!");
                    }

                } while (checkID == false);
            } while (false);
            wrong = false;
            System.out.println("Do you want to continue update injection YES/NO?");
            do {

                if (wrong) {
                    System.out.println("Please enter \"yes\" or \"no\" correctly.  ! ");
                }
                sc = new Scanner(System.in);
                i = sc.nextLine().toUpperCase().trim();
                wrong = true;
            } while (!"YES".equals(i) && !"NO".equals(i));
        } while ("YES".equals(i));

    }

    public void removeInjectionByID() {
        do {
            if (list.isEmpty()) {
                System.out.println("Injection list is empty, cannot remove!");
                break;
            }
            System.out.println("Enter Injection's ID to delete  :");
            String injID = Util.checkReinputIDINJString();
            Injection found = null;
            for (Injection injection : list) {
                for (int a = 0; a < list.size(); a++) {

                    if (injection.getInjectionID().equals(injID)) {
                        found = injection;
                        break;
                    }
                }
            }
            if (found != null) {
                System.out.println("Are you sure you want to removed this injection ? (Y=1 : N=0) ");
                int a = 10;
                Boolean wrongInput = false;
                do {
                    if (wrongInput) {
                        System.out.println("Wrong input ! You entered the word or wrong numbers ! Please choose [1=Yes/0=No]");
                    }
                    try {
                        Scanner ch = new Scanner(System.in);
                        a = ch.nextInt();
                    } catch (Exception e) {
                    }
                    wrongInput = true;
                } while (a < 0 || a > 1);
                if (a == 1) {
                    list.remove(found);
                    System.out.println("The injection has been removed successfully ! ");
                } else if (a == 0) {
                    System.out.println("Removed injection failed");
                }
            } else {
                System.out.println("Injection doesn't exist!");
            }
        } while (false);

    }

    public void searchByID() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Scanner sc = new Scanner(System.in);
        String i = null;
        do {
            if (list.isEmpty()) {
                System.out.println("Injection list is empty, canot search !");
                break;
            }
            System.out.println("Enter the ID Student to be printed !");
            String idStu = Util.checkReInputIDStuString();
            Boolean has = false;
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int a = 0; a < list.size(); a++) {
                if (list.get(a).getStudentID().equals(idStu)) {
                    System.out.println("Show Injection Info");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Injection ID : " + list.get(a).getInjectionID());
                    System.out.println("Student ID : " + list.get(a).getStudentID());
                    System.out.println("Student Name : " + list.get(a).getStudentName());
                    System.out.println("Vaccine ID : " + list.get(a).getVaccineID());
                    System.out.println("Vaccine Name : " + list.get(a).getVaccineName());
                    System.out.println("Injection Place 1 : " + list.get(a).getInjectionPlace1());
                    System.out.println("Injection Date 1 : " + df.format(list.get(a).getInjectionDate1()));
                    System.out.println("Injection Place 2 : " + list.get(a).getInjectionPlace2());
                    System.out.println("Injection Date 2 : " + (list.get(a).getInjectionDate2()));
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                    has = true;
                }
            }
            if (!has) {
                System.out.println("Student doesn't exist!");
            }
            System.out.println("Do you want to continue search? (YES/NO)");
            Boolean wrongInput = false;
            do {
                if (wrongInput) {
                    System.out.println("Please enter \"yes\" or \"no\" correctly.  ! ");

                }
                i = sc.nextLine().toUpperCase().trim();
                wrongInput = true;

            } while (!"YES".equals(i) && !"NO".equals(i));

        } while ("YES".equals(i));
    }

    public boolean addFromFile() throws IOException {
        if (list.size() > 0) {
            list.clear();
        }
        try {
            File f = new File("Injection.dat");
            if (!f.exists()) {
                return false;
            }
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Injection inj;
            while ((inj = (Injection) (fo.readObject())) != null) {
                list.add(inj);
            }
            fo.close();
            fi.close();
        } catch (Exception e) {

        }
        return true;
    }

    public boolean saveToFile() {
        try {
            FileOutputStream f = new FileOutputStream("Injection.dat");
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Injection inj : list) {
                fo.writeObject(inj);
            }
            fo.close();
            f.close();
        } catch (Exception e) {

        }
        return true;
    }

    public void printAll() {
        if (list.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}
