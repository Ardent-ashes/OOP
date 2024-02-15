//package solution;

//import java.io.*;
import java.io.Serializable;
import java.util.Scanner;

//import generic_module.*;

class PrimeChecker implements Serializable{
    /* ---READ CAREFULLY--- */
    // You can not add any additional attribute in this class or modify the data type of the variables 
    // Be sure regarding the Array sizes if required 
    /* ---READING DONE--- */

    int n; // number of elements: manipulate properly 
    int prime[]; // where you will store the given numbers: Array MUST BE OF SIZE 700 during reference creation 
    int primeStatus[]; // where you will keep the status of the numbers: if prime then 1 else 0 
    
}

public class prime{
    public static void main(String [] args){


        /* ---- (TEST CASE NUMBER) DO NOT MODIFY THIS PORTION STARTED ---- */
        int testCase = 1; // default testcase 
        try{
            testCase = Integer.parseInt(args[0]); // input of testCase number
        }
        catch(Exception e){}


        // ----------------------------- STORE OBJECT -----------------------------
        //StoreObject s = new StoreObject("student" , testCase); 
        // ----------------------------- STORE OBJECT ----------------------------
        
        /* ---- (TEST CASE NUMBER) DO NOT MODIFY THIS PORTION ENDED  ----*/ 


        /* ---TASK Started--- */
        PrimeChecker pc = new PrimeChecker();
        Scanner sc = new Scanner(System.in);
        pc.n=sc.nextInt();
        pc.prime= new int[pc.n];
        pc.primeStatus= new int[pc.n];
        for(int i=0;i<pc.n;i++)
        {
            int x =sc.nextInt();
            int flag=0;
            for(int j=2;j<x;j++)
            {
                if(x%j==0)
                {
                    flag=1;
                }
            }
            if(flag==1)
            {
                pc.primeStatus[i]=0;
                flag=0;
            }
            else
            pc.primeStatus[i]=1;
        }

        for(int i=0;i<pc.n;i++)
        {
            System.out.print(pc.primeStatus[i]+" ");
        }

        

        

        /* ---TASK Ended--- */
    }
}