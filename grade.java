package solution;

import java.io.*;
import java.util.Scanner;

import generic_module.*;

class GradeManagment implements Serializable{
    // You can not add any additional attribute in this class or modify the data type of the variables 
    // Be sure regarding the Array sizes if required 
    double marks; // store the mark here
    String grade; // keep the final grade value here 
    double gpa; // store the gpa here 

}

public class Problem{
    public static void main(String [] args){


        /* ---- (TEST CASE NUMBER) DO NOT MODIFY THIS PORTION STARTED ---- */
        int testCase = 1; // default testcase 
        try{
            testCase = Integer.parseInt(args[0]); // input of testCase number
        }
        catch(Exception e){}
        StoreObject s = new StoreObject("student" , testCase); 
        /* ---- (TEST CASE NUMBER) DO NOT MODIFY THIS PORTION ENDED  ----*/ 


        /* ---TASK Started--- */
        GradeManagment gm = new GradeManagment(); // Your object over which you would work  
        Scanner scanner= new Scanner(System.in);
        gm.marks= scanner.nextDouble();
        if (gm.marks >= 80) {
            gm.grade = "A+";
            gm.gpa = 4.00;
        } else if (gm.marks >= 75) {
            gm.grade = "A";
            gm.gpa = 3.75;
        } else if (gm.marks >= 70) {
            gm.grade = "A-";
            gm.gpa = 3.50;
        } else if (gm.marks >= 65) {
            gm.grade = "B+";
            gm.gpa = 3.25;
        } else if (gm.marks >= 60) {
            gm.grade = "B";
            gm.gpa = 3.00;
        } else if (gm.marks >= 55) {
            gm.grade = "B-";
            gm.gpa = 2.75;
        } else if (gm.marks >= 50) {
            gm.grade = "C+";
            gm.gpa = 2.50;
        } else if (gm.marks >= 45) {
            gm.grade = "C";
            gm.gpa = 2.25;
        } else if (gm.marks >= 40) {
            gm.grade = "D";
            gm.gpa = 2.00;
        } else {
            gm.grade = "F";
            gm.gpa = 0.00;
        }
        System.out.println(gm.grade+" "+gm.gpa);

        
        /* ---TASK Ended--- */

        /*  ----  OOP STORING PORTION ----  (DO NOT CHANGE THIS LINE AND BELOW THIS) */
        if (gm != null) {
            s.store(gm, "1"); 
        }
    }
}/*
6a3cf5192354f71615ac51034b3e97c20eda99643fcaf5bbe6d41ad59bd121678732775eee770018db7d79d035a0163015a016de17ebbf8884902ec6d1d9fcf2f1c0364928dc69a45f1901b4d5d9297235cd27b6b134616a7c5b896f77fd3e0bdaf65097099ff301ebaec456ee590dd34ab8d26151eef623263b0fef6194ab36f45d46e100570a383f23e9ced5ae5cb10cd90ab77e2836926895bc49872e7fe7
*/
