package GUI;

import DAO.VaccineManager;
import DTO.WriteStudent;
import DTO.WriteVaccine;
import java.io.IOException;
import java.text.ParseException;
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
public class VaccineMenu {

    public static void Menu() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to Vaccine Injection Management - @ 2021 by <SE151159 - Nguyen Anh Tuan >");
        System.out.println("Select the options below:");
        System.out.println("1. Show information all students have been injected");
        System.out.println("2. Add student's vaccine");
        System.out.println("3. Updating information of students' vaccine injection");
        System.out.println("4. Delete student vaccine injection information");
        System.out.println("5. Search for injection information by studentID");
        System.out.println("6. Print to file");
        System.out.println("7. Quit");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please choose [1..7] : ");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
        WriteStudent a = new WriteStudent();
        WriteVaccine b = new WriteVaccine();
        VaccineManager c = new VaccineManager();
        c.addFromFile();
        for (;;) {
            int choice = 0;
            Boolean wrongInput = false;
            do {
                if (wrongInput) {
                    System.out.println("Wrong input choice ! You are input text, or input the menu limit. Please input again ! ");
                }
                Menu();

                try {
                    choice = 0;
                    Scanner sc = new Scanner(System.in);
                    choice = sc.nextInt();
                } catch (Exception e) {
                }
                wrongInput = true;
            } while (choice < 1 || choice > 7);
            switch (choice) {
                case 1: {
                    System.out.println("Injection List");
                    c.printAll();
                    break;
                }
                case 2: {
                    c.addInjecttion();
                    c.saveToFile();
                    break;
                }
                case 3: {
                    c.updatebyID();
                    c.saveToFile();
                    break;
                }
                case 4: {
                    c.removeInjectionByID();
                    c.saveToFile();
                    break;
                }
                case 5: {
                    c.searchByID();
                    break;
                }
                case 6: {
                    c.saveToFile();
                    break;
                }
                case 7: {
                    System.exit(0);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
