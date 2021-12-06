package DTO;

import DTO.Student;
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
public class WriteStudent extends ArrayList<Student>{

    public void addStudent() {
        Student s1 = new Student("SE150001", "Nguyen Van A");
        Student s2 = new Student("SE150002", "Nguyen Van B");
        Student s3 = new Student("SE150003", "Nguyen Van C");
        Student s4 = new Student("SE150004", "Nguyen Van D");
        Student s5 = new Student("SE150005", "Nguyen Van E");
        Student s6 = new Student("SE150006", "Nguyen Van F");
        Student s7 = new Student("SE150007", "Nguyen Van G");
        Student s8 = new Student("SE150008", "Nguyen Van H");
        Student s9 = new Student("SE150009", "Nguyen Van I");
        Student s10 = new Student("SE150010", "Nguyen Van J");
        this.add(s1);
        this.add(s2);
        this.add(s3);
        this.add(s4);
        this.add(s5);
        this.add(s6);
        this.add(s7);
        this.add(s8);
        this.add(s9);
        this.add(s10);

    }

//    public void save() {
//        try {
//            FileWriter fw = new FileWriter("student.dat");
//            BufferedWriter bw = new BufferedWriter(fw);
//            for (Student student : this) {
//                bw.write(student.toString());
//                bw.newLine();
//            }
//            bw.close();
//            fw.close();
//        } catch (Exception e) {
//        }
//
//    }
//
//    public static Arra this<Student> addFromFile() {
//        Arra this<Student> this = new Arra this<>();
//        try {
//            FileReader fr = new FileReader("student.dat");
//            BufferedReader br = new BufferedReader(fr);
//            String line = "";
//            while (true) {
//                line = br.readLine();
//                if (line == null) {
//                    break;
//                }
//                String txt[] = line.split("-");
//                String studentName = txt[0];
//                String studentID = txt[1];
//                this.add(new Student(studentName, studentID));
//            }
//        } catch (Exception e) {
//
//        }
//        return this;
//    }
//    public static void readFromFile(){
//        Arra this<Student> this = addFromFile();
//        for (Student student : this) {
//            System.out.println(student);
//            
//        }
//    }
    public boolean addFromFile() throws IOException {
        if  (this.size() > 0) {
            this.clear();
        }
        try {
            File f = new File("student.dat");
            if (!f.exists()) {
                return false;
            }
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Student stu;
            while ((stu = (Student) (fo.readObject())) != null) {
                this.add(stu);
            }
            fo.close();
            fi.close();
        } catch (Exception e) {

        }
        return true;
    }

    public boolean saveToFile() {
        try {
            FileOutputStream f = new FileOutputStream("student.dat");
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Student stu : this) {
                fo.writeObject(stu);
            }
            fo.close();
            f.close();
        } catch (Exception e) {

        }
        return true;
    }
}
