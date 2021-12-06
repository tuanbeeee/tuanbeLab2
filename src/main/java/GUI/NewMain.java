package GUI;

import DTO.WriteVaccine;
import Util.Util;
import java.io.IOException;
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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean wrong = false;
        String i;
        String place = null;

        wrong = false;
        System.out.println("Do you want to continue add injection YES/NO?");
        do {

            if (wrong) {
                System.out.println("Please enter \"yes\" or \"no\" correctly.  ! ");
            }
            sc = new Scanner(System.in);
            i = sc.nextLine().toUpperCase().trim();
            wrong = true;
            if ("YES".equals(i)) {
                place = Util.input2PlaceString();
            }
            if ("NO".equals(i)) {
                place = null;
            }
            System.out.println(place);
        } while (!"YES".equals(i) && !"NO".equals(i));

    }
}
