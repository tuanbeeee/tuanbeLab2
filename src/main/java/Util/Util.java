package Util;

import DTO.Student;
import DTO.Vaccine;
import DTO.WriteStudent;
import DTO.WriteVaccine;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuanb
 */
public class Util {

    WriteStudent a = new WriteStudent();
    WriteVaccine b = new WriteVaccine();
    private static Scanner sc = new Scanner(System.in);

    public static String checkInputIDINJString() {
        String ID;
        System.out.println("Please input ID of injection : ");
        ID = sc.nextLine().toUpperCase().trim();
        do {
            if (ID == null || ID.isEmpty() || ID.isBlank()) {
                System.err.println("The ID of injection cannot be blank or empty ! ");
                ID = sc.nextLine().toUpperCase().trim();
            }
        } while (ID.isEmpty() || ID.isBlank());
        return ID;
    }

    public static String checkReinputIDINJString() {
        String ID;
        ID = sc.nextLine().toUpperCase().trim();
        do {
            if (ID == null || ID.isEmpty() || ID.isBlank()) {
                System.err.println("The ID of injection cannot be blank or empty ! ");
                ID = sc.nextLine().toUpperCase().trim();
            }
        } while (ID.isEmpty() || ID.isBlank());
        return ID;
    }

    public static String checkInputIDStuString() {
        String name;
        Pattern p = Pattern.compile("^[sS]{1}[eE]{1}\\d{6}$");
        System.out.println("Please input ID of Student (SExxxxxx) : ");
        while (true) {
            name = sc.nextLine().toUpperCase();
            do {
                if (name == null || name.isEmpty() || name.isBlank()) {
                    System.err.println("The ID cannot be blank or empty ! ");
                    name = sc.nextLine().toUpperCase();
                }
            } while (name.isEmpty() || name.isBlank());
            if (p.matcher(name).find()) {
                break;
            } else {
                System.err.println("Wrong input ID Student! ");
            }
        }
        return name;
    }

    public static String checkReInputIDStuString() {
        String name;
        Pattern p = Pattern.compile("^[sS]{1}[eE]{1}\\d{6}$");
        while (true) {
            name = sc.nextLine().toUpperCase();
            do {
                if (name == null || name.isEmpty() || name.isBlank()) {
                    System.err.println("The ID cannot be blank or empty ! ");
                    name = sc.nextLine().toUpperCase();
                }
            } while (name.isEmpty() || name.isBlank());
            if (p.matcher(name).find()) {
                break;
            } else {
                System.err.println("Wrong input ID Student! ");
            }
        }
        return name;
    }

    public String inputStu(String idStu) throws IOException {
        WriteStudent a = new WriteStudent();
        a.addStudent();
        a.saveToFile();
        a.addFromFile();
        String nameStu = null;
        idStu = idStu.trim().toUpperCase();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getStudentID().equals(idStu)) {
                nameStu = a.get(i).getStudentName();
                System.out.println("Student ID : " + idStu);
                System.out.println("Student Name :" + nameStu);
            }
        }
        return nameStu;
    }

    public static String checkInputIDVacString() {
        String id;
        Pattern p = Pattern.compile("^[vV]{1}\\d{3}$");
        System.out.println("Please input ID of Vaccine (Vxxx) : ");
        while (true) {
            id = sc.nextLine().toUpperCase();
            do {
                if (id == null || id.isEmpty() || id.isBlank()) {
                    System.err.println("The ID Vaccine cannot be blank or empty ! ");
                    id = sc.nextLine().toUpperCase();
                }
            } while (id.isEmpty() || id.isBlank());
            if (p.matcher(id).find()) {
                break;
            } else {
                System.err.println("Wrong input ID Vaccine ! ");
            }
        }
        return id;
    }

    public String inputVac(String idVac) throws IOException {
        String nameVac = null;
        WriteVaccine b = new WriteVaccine();
        b.addVaccine();
        b.saveToFile();
        b.addFromFile();
        idVac.trim().toUpperCase();
        for (int a = 0; a < b.size(); a++) {
            if (b.get(a).getVaccineID().contains(idVac)) {
                nameVac = b.get(a).getVaccineName();
                System.out.println("Vaccine ID :" + idVac);
                System.out.println("Vaccine Name : " + nameVac);
            }
        }
        return nameVac;
    }

    public static String input1PlaceString() {
        String place;
        Pattern p = Pattern.compile("^[a-zA-z ]+$");
        System.out.println("Please input first place you injected : ");
        while (true) {
            place = sc.nextLine().toUpperCase();
            do {
                if (place == null || place.isEmpty() || place.isBlank()) {
                    System.err.println("Place cannot be blank or empty ! ");
                    place = sc.nextLine().toUpperCase();
                }
            } while (place.isEmpty() || place.isBlank());
            if (p.matcher(place).find()) {
                break;
            } else {
                System.err.println("Wrong input Place ! ");
            }
        }
        return place;
    }

    public static String input2PlaceString() {
        String place;
        System.out.println("Please input second place you injected : ");
            place = sc.nextLine().toUpperCase().trim();
            return place;
    }

    public static boolean isDateValid(String date) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date validDate = null;
        df.setLenient(false);
        try {
            validDate = df.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Date inputDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date now = null;
        Date today = new Date();
        today.getTime();
        String st = df.format(today);
        System.out.println("Please input first date of injection (dd-MM-yyy) : ");
        while (true) {
            String expiredDate = sc.nextLine();
            try {
                now = df.parse(expiredDate);
            } catch (ParseException ex) {
            }
            if (!Util.isDateValid(expiredDate)) {
                System.err.println("Invalid Day ! Input again: ");
            } else {
                return now;

            }
        }
    }

    public static LocalDate getLocalDateFromDate(Date date) {
        return LocalDate.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
    }

    public static Date inputCheckSecondDate(Date d1) {
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Date d2 = null;
        String date2 = null;
        String date1 = dtf.format(getLocalDateFromDate(d1));
        int flag;
        do {
            System.out.println("Please input second date of injection (dd-MM-yyy) : ");
            flag = 0;
            d.setLenient(false);
            try {
                d2 = d.parse(sc.nextLine());
                date2 = dtf.format(getLocalDateFromDate(d2));
                LocalDate ld1 = LocalDate.parse(date1, dtf);
                LocalDate ld2 = LocalDate.parse(date2, dtf);
                Duration diff = Duration.between(ld1.atStartOfDay(), ld2.atStartOfDay());
                long diffDays = diff.toDays();
                if (diffDays >= 30 && diffDays <= 90) {
                    flag = 1;
                } else {
                    System.out.println("Second date must be between 4 weeks and 12 weeks from " + date1);
                }
            } catch (ParseException e) {
                System.out.println("Invalid day");
                if (e != null) {
                    flag = 0;
                }
            }
        } while (flag == 0);
        return d2;
    }

    public static String convertDateToString(String date) {
        DateFormat df = new SimpleDateFormat(date);
        Date today = Calendar.getInstance().getTime();
        String dateToString = df.format(today);
        return (dateToString);
    }
}
