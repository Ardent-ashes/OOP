import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;

class person{
    String first;
    String mid;
    String last;
    String mail;
    String nid;
    String passport;
    String bd;
    String address;
    void print()
    { 
        try{
            handling.validateName(this.first, this.last);
            System.out.println("Name: "+first+" "+mid+" "+last);
        }
        catch(CustomException e){
            System.out.println("Exception occurred: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Nested Exception: " + e.getCause().getMessage());
            }
        }
        try {
            System.out.println("E-mail: "+mail);            
            handling.validateEmail(mail);
              
        } catch (CustomException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Nested Exception: " + e.getCause().getMessage());
            }
        }
        try { 
            try {
                handling.validateNID(nid);
                System.out.println("NID: "+nid);
            } catch (CustomException e) {
                System.out.println("Exception occurred: " + e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("Nested Exception: " + e.getCause().getMessage());
                }
            }    
            try {
                handling.validatePassport(passport);
                System.out.println("Passport: "+passport);
            } catch (CustomException e) {
                System.out.println("Exception occurred: " + e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("Nested Exception: " + e.getCause().getMessage());
                }
            }                      
            handling.validateID(nid,passport);
            
        } catch (CustomException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Nested Exception: " + e.getCause().getMessage());
            }
        }        

        try {
            handling.validateBirthdate(bd);
            System.out.println("Birthdate: "+bd);
        } catch (CustomException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Nested Exception: " + e.getCause().getMessage());
            }
        }        
        try {
            handling.validateAddress(address);
            System.out.println("Address: "+address);
        } catch (CustomException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Nested Exception: " + e.getCause().getMessage());
            }
        }
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}



class handling {
    public static void validateName(String firstName, String lastName) throws CustomException {
        CustomException nestedException = null;
        if (firstName.isEmpty() && lastName.isEmpty()) {
            nestedException = new CustomException("NoNamePresent: First name and last name are both absent.");
        } else if (firstName.isEmpty()) {
            nestedException = new CustomException("FirstNameAbsence: First name is absent.");
        } else if (lastName.isEmpty()) {
            nestedException = new CustomException("LastNameAbsence: Last name is absent.");
        }

        if (nestedException != null) {
            CustomException exception = new CustomException("Name validation failed");
            exception.initCause(nestedException);
            throw exception;
        }
    }

    public static void validateEmail(String email) throws CustomException {
        CustomException nestedException = null;
        if (email.isEmpty()) {
            nestedException = new CustomException("BlankEmailField: Email address is blank.");
        }else if (!email.contains("@gmail.com")) {
            nestedException = new CustomException("AbsenceOfGmailSuffix: Email address does not contain @gmail.com");
        } 
        else if (!Pattern.matches("[a-z\\d]+@gmail.com", email)) {
            nestedException = new CustomException("NotProperlyFormattedEmail: Email address is not properly formatted.");
        } 
    
        if (nestedException != null) {
            CustomException exception = new CustomException("Email validation failed");
            exception.initCause(nestedException);
            throw exception;
        }
    }

    public static void validateID(String nid, String passport) throws CustomException {
        CustomException nestedException = null;
        if (nid.isEmpty() && passport.isEmpty()) {
            nestedException = new CustomException("BlankNIDPassportField: NID and Passport field is blank.");
        } 
        if (nestedException != null) {
            CustomException exception = new CustomException("NID and Passport validation failed");
            exception.initCause(nestedException);
            throw exception;
        }
    }

    public static void validateNID(String nid) throws CustomException {
        CustomException nestedException = null;
        if(nid.isEmpty()) return;
       if (!Pattern.matches("\\d{11}", nid)) {
            nestedException = new CustomException("UnexpectedNIDFormat: NID format is unexpected.");
        }
    
        if (nestedException != null) {
            CustomException exception = new CustomException("NID validation failed");
            exception.initCause(nestedException);
            throw exception;
        }
    }
    

    public static void validatePassport(String passport) throws CustomException {
        CustomException nestedException = null;
        if(passport.isEmpty()) return;
        if (!Pattern.matches("[A-Z]{2}\\d{7}", passport)) {
            nestedException = new CustomException("UnexpectedPassportFormat: Passport format is unexpected.");
        }
    
        if (nestedException != null) {
            CustomException exception = new CustomException("Passport validation failed");
            exception.initCause(nestedException);
            throw exception;
        }
    }
    
    public static void validateBirthdate(String birthdate) throws CustomException {
        CustomException nestedException = null;
        if (birthdate.isEmpty()) {
            nestedException = new CustomException("BirthdateBlank: Birthdate field is blank.");
        } else if (!Pattern.matches("\\d{2} [a-zA-Z]+ \\d{4}", birthdate)) {
            nestedException = new CustomException("WrongBirthdateFormat: Birthdate format is wrong.");
        }
    
        if (nestedException != null) {
            CustomException exception = new CustomException("Birthdate validation failed");
            exception.initCause(nestedException);
            throw exception;
        }
    }
    
    public static void validateAddress(String address) throws CustomException {
        CustomException nestedException = null;
        if (address.isEmpty()) {
            nestedException = new CustomException("BirthdateBlank: Address field is blank.");
        } 
        else{
            String[] parts = address.split(", ");
  
        String p1 = parts[0].trim();
        //System.out.print("P1: " + p1); 
        if (!p1.matches("\\d+[A-Z/]*")) {
            nestedException = new CustomException("InvalidP1: P1 should consist of digits, punctuation ('/'), and upper case English letters.");
        }
    
        String p2 = parts[1];
        if (!p2.matches("[a-zA-Z\\s]+")) {
            nestedException = new CustomException("InvalidP2: P2 should consist of English characters and spaces only.");
        }
  
        String p3 = parts[2];
        String[] validP3 = {"Dhaka", "Chottogram", "Barishal", "Khulna", "Sylhet", "Rajshahi", "Mymensingh", "Rangpur"};
        boolean isValidP3 = false;
        for (String valid : validP3) {
            if (p3.equals(valid)) {
                isValidP3 = true;
                break;
            }
        }
        if (!isValidP3) {
            nestedException = new CustomException("InvalidP3: P3 should denote major divisions of Bangladesh.");
        }
        }
    
        
    
        if (nestedException != null) {
            CustomException exception = new CustomException("Address validation failed");
            exception.initCause(nestedException);
            throw exception;
        }
    }
    
}

public class Roll_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<person> list = new ArrayList<>();
        
        int x=1; 
        while(x!=0)
        {
           
            System.out.println("0. Exit\n1. Add User\n2. Find User");
            x=sc.nextInt();
            switch (x) {
                case 1:
                try{
                    person p= new person();
                    try{
                        String f, m, l;
                        System.out.print("First name: ");
                        sc.nextLine();
                        f=sc.nextLine();
                        System.out.print("Mid name: ");
                        m=sc.nextLine();
                        System.out.print("Last name: ");
                        l=sc.nextLine();
                        p.first=f;
                        p.mid=m;
                        p.last=l;
                        handling.validateName(f, l);
                        
                    }
                    catch(CustomException e){
                        System.out.println("Exception occurred: " + e.getMessage());
                        if (e.getCause() != null) {
                            System.out.println("Nested Exception: " + e.getCause().getMessage());
                        }
                    }
        
                    try {
                        String mail;
                        System.out.print("Mail Address: ");
                        mail = sc.nextLine();
                        p.mail=mail;
                        handling.validateEmail(mail);
                          
                    } catch (CustomException e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                        if (e.getCause() != null) {
                            System.out.println("Nested Exception: " + e.getCause().getMessage());
                        }
                    }
        
                    try {
                        String nid;
                        System.out.print("NID no(11 digit): ");
                        nid = sc.nextLine();
                        p.nid=nid;
                        try{
                            handling.validateNID(nid);
                        }
                        catch (CustomException e) {
                            System.out.println("Exception occurred: " + e.getMessage());
                            if (e.getCause() != null) {
                                System.out.println("Nested Exception: " + e.getCause().getMessage());
                            }
                        }
                        
                        String passport;
                        System.out.print("Passport No(2 uppercase and 7 digit): ");
                        passport = sc.nextLine();
                        p.passport=passport;
                        try{
                            handling.validatePassport(passport);
                        }
                        catch (CustomException e) {
                            System.out.println("Exception occurred: " + e.getMessage());
                            if (e.getCause() != null) {
                                System.out.println("Nested Exception: " + e.getCause().getMessage());
                            }
                        }
                        handling.validateID(nid, passport);
                        
                    } catch (CustomException e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                        if (e.getCause() != null) {
                            System.out.println("Nested Exception: " + e.getCause().getMessage());
                        }
                    }
                    
                    try {
                        String bd;
                        System.out.print("Date of Birth(date month year): ");
                        bd = sc.nextLine();
                        p.bd=bd;
                        handling.validateBirthdate(bd);
                        
                    } catch (CustomException e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                        if (e.getCause() != null) {
                            System.out.println("Nested Exception: " + e.getCause().getMessage());
                        }
                    }
                    
                    try {
                        String ad;
                        System.out.print("Address: ");
                        ad = sc.nextLine();
                        p.address=ad;
                        handling.validateAddress(ad);
                        
                    } catch (CustomException e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                        if (e.getCause() != null) {
                            System.out.println("Nested Exception: " + e.getCause().getMessage());
                        }
                    }
                    list.add(p);
                }
                catch(Exception e){
                    System.out.println(e);
        
                }
                finally{
                   System.out.println("Input Completed");

                }
                break;

                case 2:
                System.out.println("User No: ");
                try{
                    int n=sc.nextInt();
                    list.get(n).print();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            
                default:
                    break;
            }
        }

        } 
    }