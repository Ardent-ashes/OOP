import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class Student {
    Scanner sc = new Scanner(System.in);
    public String name;
    public int roll;
    public String email;
    double ai;
    double aicg;
    double sec;
    double seccg;
    double or;
    double orcg;
    double net;
    double netcg;
    double es;
    double escg;
    String aimethod;
    String ormethod;
    String esmethod;
    String netmethod;
    String secmethod;
    private int totalm=0;

   
    String optionalCourse;
    ArrayList<Course> majorList = new ArrayList<>();
    Course minCourse;
  
    double gpa;
    private double cgpa=0;
    

    public Student(String name, int roll, String email) {
        this.name = name;
        this.roll = roll;
        this.email = email;
        
        //this.majorCourses = new ArrayList<>();
    }

    void creatcourse(int n, double credit, Rank rl)
    {
        Random random = new Random();
        switch (n) {
            case 1:
                {
                    AI s= new AI();
                    s.ev = new Evaluation(0,0);
                    //System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
                    int x=random.nextInt(3);
                    switch(x){
                        case 1:
                        int a=random.nextInt(70), b=random.nextInt(40);
                        s.ev= new Evaluation(a,b);
                        break;
                        case 2:
                        int c=random.nextInt(70), d=random.nextInt(30), e=random.nextInt(10);
                        s.ev= new Evaluation(c,d,e);
                        break;
                        case 3:
                        int f=random.nextInt(), i=random.nextInt(70), g=random.nextInt(5), h=random.nextInt(5);
                        s.ev= new Evaluation(f,g,h,i);
                        break;
                    }

                    Course c =s;
                    if(credit ==3) majorList.add(c);
                    else minCourse=c;
                    
                    
                    double courseGPA = s.ev.GPA(); // Calculate GPA for the course
                    aicg=s.ev.GPA();
                    ai=s.ev.total;
                    totalm+=s.ev.total;
                    aimethod=s.ev.method;
                    cgpa += credit * courseGPA;
                    rl.AI.add(this);
                    break;
                }
            case 2:
                {
                    Security s= new Security();
                    s.ev = new Evaluation(0,0);
                    //System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
                    int x=random.nextInt(3);
                    switch(x){
                        case 1:
                        int a=random.nextInt(70), b=random.nextInt(40);
                        s.ev= new Evaluation(a,b);
                        break;
                        case 2:
                        int c=random.nextInt(70), d=random.nextInt(30), e=random.nextInt(10);
                        s.ev= new Evaluation(c,d,e);
                        break;
                        case 3:
                        int f=random.nextInt(70), i=random.nextInt(30), g=random.nextInt(5), h=random.nextInt(5);
                        s.ev= new Evaluation(f,g,h,i);
                        break;
                    }
                    
                    cgpa+= credit * s.ev.GPA();
                    seccg=s.ev.GPA();
                    secmethod=s.ev.method;
                    totalm+=s.ev.total;
                    sec=s.ev.total;
                    Course c =s;
                    if(credit ==3) majorList.add(c);
                    else minCourse=c;
                    rl.Security.add(this);
                    
                    break;



                }
                case 3:
                {
                    OR s= new OR();
                    s.ev = new Evaluation(0,0);
                    //System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
                    int x=random.nextInt(3);
                    switch(x){
                        case 1:
                        int a=random.nextInt(70), b=random.nextInt(40);
                        s.ev= new Evaluation(a,b);
                        break;
                        case 2:
                        int c=random.nextInt(70), d=random.nextInt(30), e=random.nextInt(10);
                        s.ev= new Evaluation(c,d,e);
                        break;
                        case 3:
                        int f=random.nextInt(70), i=random.nextInt(30), g=random.nextInt(5), h=random.nextInt(5);
                        s.ev= new Evaluation(f,g,h,i);
                        break;
                    }
                    
                    cgpa+= credit * s.ev.GPA();
                    orcg=s.ev.GPA();
                    ormethod=s.ev.method;
                    or=s.ev.total;
                    totalm+=s.ev.total;
                    rl.OR.add(this);
                   
                    Course c =s;
                    if(credit ==3) majorList.add(c);
                    else minCourse=c;
                    break;
            }
            case 4:
            {
                NET s= new NET();
                s.ev = new Evaluation(0,0);
                //System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
                int x=random.nextInt(3);
                switch(x){
                    case 1:
                        int a=random.nextInt(70), b=random.nextInt(40);
                        s.ev= new Evaluation(a,b);
                        break;
                        case 2:
                        int c=random.nextInt(70), d=random.nextInt(30), e=random.nextInt(10);
                        s.ev= new Evaluation(c,d,e);
                        break;
                        case 3:
                        int f=random.nextInt(70), i=random.nextInt(30), g=random.nextInt(5), h=random.nextInt(5);
                        s.ev= new Evaluation(f,g,h,i);
                        break;
                }
                Course c =s;
                if(credit ==3) majorList.add(c);
                else minCourse=c;
                cgpa+= credit * s.ev.GPA();
                netcg=s.ev.GPA();
                netmethod=s.ev.method;
                totalm+=s.ev.total;
                net=s.ev.total;
                rl.NET.add(this);
                
                break;
        }
        case 5:
        {
            ES s= new ES();
            s.ev = new Evaluation(0,0);
            //System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
            int x=random.nextInt(3);
            switch(x){
                case 1:
                        int a=random.nextInt(70), b=random.nextInt(40);
                        s.ev= new Evaluation(a,b);
                        break;
                        case 2:
                        int c=random.nextInt(70), d=random.nextInt(30), e=random.nextInt(10);
                        s.ev= new Evaluation(c,d,e);
                        break;
                        case 3:
                        int f=random.nextInt(70), i=random.nextInt(30), g=random.nextInt(5), h=random.nextInt(5);
                        s.ev= new Evaluation(f,g,h,i);
                        break;
            }
            Course c =s;
            if(credit ==3) majorList.add(c);
            else minCourse=c;
            cgpa+= credit * s.ev.GPA();   
            escg=s.ev.GPA();
            es=s.ev.total;
            totalm+=s.ev.total;
            esmethod=s.ev.method;
            rl.ES.add(this);
            
            break;            
        }    
        
 }
 }

 void cg()
 {
     this.cgpa= (int)(1000*this.cgpa/(10.5));
     this.cgpa=this.cgpa/1000;
 }

    public String getName() {
        return name;
    }


    public double getGpa() {
        return this.cgpa;
    }
    public double getai() {
        return this.ai;
    }
    public double getsec() {
        return this.sec;
    }
    public double getor() {
        return this.or;
    }
    public double getnet() {
        return this.net;
    }
    public double getes() {
        return this.es;
    }
    public int getroll() {
        return this.roll;
    }
    
    public int gettotal() {
    
        return this.totalm;
    }


    // public void addMajorCourse(String course1, String course2, String course3) {
    //     this.course1=course1;
    //     this.course2=course2;
    //     this.course3=course3;
    // }
    // public void addMinorCourse(String course4) {
    //     this.optionalCourse=course4;
    // }

   void printst()
   {
     System.out.println("Name: "+this.name);
     System.out.println("Roll: "+this.roll);
     System.out.println("Email: "+this.email);
     System.out.println("CGPA: "+this.cgpa);
     System.out.println("Major courses: ");
     for(Course c: majorList)
     {
        System.out.println(c.marks());
     }
     System.out.println("(Optional Courses)" + minCourse.marks());
   }
   
}


class Evaluation {
    int total;
    Random random= new Random();
    double gp;
    String method;

    Scanner sc= new Scanner(System.in);
    Evaluation(int finalScore, int midtermScore) {
        boolean validInput = false;
        do {

            if ((finalScore<=70 && midtermScore<=30 && finalScore+midtermScore<=100)||(finalScore<=60 && midtermScore<=40 && finalScore+midtermScore<=100)) { // Check if the input is within the valid range
                this.total=finalScore+midtermScore;
                validInput=true;}
               
                 else {
                    finalScore = random.nextInt(70);
                    midtermScore= random.nextInt(40);
                    
                }
            
        } while (!validInput);
        if(finalScore<=60 && midtermScore>30) method="Final(60)+Mid(40)";
        else method="Final(70)+Mid(30)";

    }
    Evaluation(int finalScore, int midtermScore, int assignment ) {

        boolean validInput = false;
        do {

            if ((finalScore<=70 && midtermScore<=20 && assignment<=10 && finalScore+midtermScore+assignment<=100)||(finalScore<=60 && midtermScore<=30 && assignment<=10 && assignment+finalScore+midtermScore<=100)) { // Check if the input is within the valid range
                this.total=finalScore+midtermScore+assignment;
                validInput=true;}
               
                 else {
                    finalScore = random.nextInt(70);
                    midtermScore= random.nextInt(30);
                    assignment= random.nextInt(10);
                    
                }
            
        } while (!validInput);
        if(finalScore<=60 && midtermScore>20) method="Final(60)+Mid(20)+Assignment(10)";
        else method="Final(70)+Mid(20)+Assignment(10)";
    }
    Evaluation(int finalScore, int midtermScore, int assignment, int attendance) {

        boolean validInput = false;
        do {

            if ((finalScore<=70 && midtermScore<=20 && assignment<=5 && attendance<=5 && attendance+finalScore+midtermScore+assignment<=100)) { // Check if the input is within the valid range
                this.total=finalScore+midtermScore+assignment+attendance;
                validInput=true;}
               
                 else {
                    finalScore = random.nextInt(70);
                    midtermScore= random.nextInt(20);
                    assignment= random.nextInt(5);
                    attendance= random.nextInt(5);
                    
                }
            
        } while (!validInput);
        method="Final(70)+Mid(20)+Assignment(5)+Attendance(5)";
        

        // Constructor implementation
    }
    

    public double GPA() {
        double gpa;
        if (this.total >= 80) {
            gpa = 4.0;
        } else if (this.total >= 75) {
            gpa = 3.75;
        } else if (this.total >= 70) {
            gpa = 3.5;}
        else if (this.total >= 65) {
            gpa = 3.25;
        } else if (this.total >= 60) {
            gpa = 3.00;
        } else if (this.total >= 55) {
            gpa = 2.75;
        }
        else if (this.total >= 50) {
            gpa = 2.5;
        } else if (this.total >= 40) {
            gpa = 1.5;
        } else {
            gpa = 0.0;
        }
        this.gp= gpa;
        return gpa;
    }
}




abstract class Course {
    abstract double marks();
    abstract int total();
}


class Security extends Course {
    Evaluation ev;
    @Override
    double marks() {
        System.out.print("Securiy "+ev.gp+" Marks: ");
        return ev.total;
    }
    int total() {
        return ev.total;
    }

}

class AI extends Course {
    Evaluation ev;
    @Override
    double marks(){
        System.out.print("AI "+ev.gp+" Marks: ");
        return ev.total;
    }
    int total() {
        return ev.total;
    }
}

class OR extends Course {
    Evaluation ev;
    @Override
    double marks(){
        System.out.print("OR "+ev.gp+" Marks: ");
        return ev.total;
    }
    int total() {
        return ev.total;
    }
}

class ES extends Course {
    Evaluation ev;
    @Override
    double marks(){
        System.out.print("EV "+ev.gp+" Marks: ");
        return ev.total;
    }
    int total() {
        return ev.total;
    }
}

class NET extends Course {
    Evaluation ev;
    @Override
    double marks(){
        System.out.print("NET "+ev.gp+" Marks ");
        return ev.total;
    }
    int total() {
        return ev.total;
    }
}

class Rank {
    ArrayList<Student> data;
    ArrayList<Student> AI;
    ArrayList<Student> ES;
    ArrayList<Student> NET;
    ArrayList<Student> OR;
    ArrayList<Student> Security;
    
    

    // Constructor
    public Rank() {
        data = new ArrayList<>();
        AI = new ArrayList<>();
        ES = new ArrayList<>();
        NET = new ArrayList<>();
        OR = new ArrayList<>();
        Security = new ArrayList<>();
    }

    // Method to sort and print GPA list
    public void gpalist() {
        
        Collections.sort(data, Comparator.comparingInt(Student::gettotal).reversed());
        Collections.sort(data, Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("Sorted CGPA list:");
        int i=1;
        for (Student student : data) {
            System.out.println(i+". Name: " + student.getName() + " Roll: "+student.getroll()+ " CGPA: " + student.getGpa()+" Totalmarks: "+student.gettotal());
            i++;
        }
        i=1;
    }
    public void rollwiselist() {
        
        Collections.sort(data, Comparator.comparingDouble(Student::getroll));
        System.out.println("Rollwise Students list:");
        int i=1;
        for (Student student : data) {
            System.out.print(i+". ");
            student.printst();
            System.out.println("\n");
            i++;
        }
        i=1;
    }
    public void gpaAI() {
        Collections.sort(AI, Comparator.comparingDouble(Student::getai).reversed());
        System.out.println("Sorted AI GPA list:");
        int i=1;
        for (Student student : AI) {
            System.out.println(i+ ". Name: " + student.getName() + ", AI GPA: " + student.aicg+ ", AI marks " + student.ai);
            i++;
        }
        i=1;
    }

    public void gpaSEC() {
        Collections.sort(Security, Comparator.comparingDouble(Student::getsec).reversed());
        System.out.println("Sorted Security GPA list:");
        int i=1;
        for (Student student : Security) {
            System.out.println(i+ ". Name: " + student.getName() + ", Security GPA: " + student.seccg+ ", Security marks " + student.sec);
            i++;
        }
        i=1;
    }
    public void gpaOR() {
        Collections.sort(OR, Comparator.comparingDouble(Student::getor).reversed());
        System.out.println("Sorted Optional Research GPA list:");
        int i= 1;
        for (Student student : OR) {
            System.out.println(i+ ". Name: " + student.getName() + ", Optional Research GPA: " + student.orcg+ ", Optional Research marks " + student.or);
            i++;
        }
        i=1;
    }

    public void gpaNET() {
        Collections.sort(NET, Comparator.comparingDouble(Student::getnet).reversed());
        System.out.println("Sorted Networking GPA list:");
        int i=1;
        for (Student student : NET) {
            System.out.println(i+ ". Name: " + student.getName() + ", Networking GPA: " + student.netcg+ ", Networking marks " + student.net);
            i++;
        }
        i=1;
    }

    public void gpaES() {
        Collections.sort(ES, Comparator.comparingDouble(Student::getes).reversed());
        System.out.println("Sorted Embedded System GPA list:");
        int i=1;
        for (Student student : ES) {
            System.out.println(i+ ". Name: " + student.getName() + ", Embedded System GPA: " + student.escg+ ", Embedded System marks " + student.es);
            i++;
        }
        i=1;
    }

    // Method to print AI list
    public void printAI() {
        System.out.println("AI List:");
        for (Student student : AI) {
            //System.out.println("Name: " + student.getName() + ", GPA: " + student.getGpa());
            System.out.print("Name: " + student.getName() + "\tRoll: "+student.roll+"\tCGPA: " + student.getGpa()+ "\tEmail: "+student.email);
            System.out.println("\tEvaluation Criteria: "+student.aimethod);
        }
    }
    public void printES() {
        System.out.println("Embedded System List:");
        for (Student student : ES) {
            System.out.print("Name: " + student.getName() + "\tRoll: "+student.roll+"\tCGPA: " + student.getGpa()+ "\tEmail: "+student.email);
            System.out.println("\tEvaluation Criteria: "+student.esmethod);
        }
    }

    public void printNET() {
        System.out.println("NETWORKING List:");
        for (Student student : NET) {
            System.out.print("Name: " + student.getName() + "\tRoll: "+student.roll+"\tCGPA: " + student.getGpa()+ "\tEmail: "+student.email);
            System.out.println("\tEvaluation Criteria: "+student.netmethod);
        }
    }
    public void printOR() {
        System.out.println("Optional Research List:");
        for (Student student : OR) {
            System.out.print("Name: " + student.getName() + "\tRoll: "+student.roll+"\tCGPA: " + student.getGpa()+ "\tEmail: "+student.email);
            System.out.println("\tEvaluation Criteria: "+student.ormethod);
        }
    }
    public void printSecurity() {
        System.out.println("Security List:");
        for (Student student : Security) {
            System.out.print("Name: " + student.getName() + "\tRoll: "+student.roll+"\tCGPA: " + student.getGpa()+ "\tEmail: "+student.email);
            System.out.println("\tEvaluation Criteria: "+student.secmethod);
        }
    }
}

   




public class Roll_1 {

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        Rank list= new Rank();
        int[] code = new int[5];
        ArrayList<Integer> Rolllist = new ArrayList<Integer>();
        
        Scanner sc = new Scanner(System.in);
        int x;
        do{
        System.out.println("1. Add Student\n2. Course-based Info\n3. Student Ranking\n4. Course-based Ranking \n5. Rollwise Details \n0.Exit");
        x= sc.nextInt();
        switch (x) {
            case 1:
            System.out.print("Number of Students: ");
            int no=sc.nextInt();
            for(int p=0;p<no;p++)
            {
                //System.out.print("Name: ");
                String name= generateRandomString(10);
                //System.out.print(name);
               // System.out.print("Roll: ");
               int roll= random.nextInt(no+10);
                boolean validRoll = false;
                do {
                    roll = random.nextInt(no+10) + 1; // Generate a random number between 1 and 100 (inclusive)
        
                    // Check if the roll is valid
                    validRoll = (roll != 0) && (!Rolllist.contains(roll));
        
                    if (!validRoll) {
                        System.out.println("Roll number already exists or is zero. Please enter another roll number:");
                        roll = random.nextInt();
                    }
                } while (!validRoll);
            
                //System.out.print(roll);
                //System.out.print("Email: ");
                String email= generateRandomString(10)+"@gmail.com";
                Student person= new Student(name, roll, email);
        for (int i = 0; i < 3; i++) {
        boolean validInput = false;
        while (!validInput) {
           // System.out.println("Choose any of them as a major course:\n1. AI\n2. Security\n3. OptionalResearch\n4. Networking\n5. Embedded System");
            int y = random.nextInt(5)+1;
            if (y >= 1 && y <= 5) { // Check if the input is within the valid range
                boolean isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (code[j] == y) { // Check if the input is a duplicate
                        isDuplicate = true;
                       
                        break;
                    }
                }
                if (!isDuplicate) {
                    //System.out.print(y+"course no");
                    person.creatcourse(y, 3, list);
                    code[i] = y;
                    validInput = true;
                } else {
                    //System.out.println("You have already chosen this course. Please choose another one.");
                    ;
                }
            } else {
                //System.out.println("Invalid input. Please choose a number between 1 and 5.");
                ;
            }
        }
    }
    //System.out.println("Choose any of them as optional course:\n1. AI\n2. Security\n3. OptionalResearch\n4. Networking\n5. Embedded System");
    int y;
    boolean validInput = false;
    do {
        y = random.nextInt(5)+1;
        if (y >= 1 && y <= 5) { // Check if the input is within the valid range
            boolean isDuplicate = false;
            // Check if the input is a duplicate by comparing with previously chosen optional courses
            for (int i = 0; i < 3; i++) {
                if (code[i] == y) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                validInput = true;
            } else {
                ;//System.out.println("You have already chosen this course as optional. Please choose another one.");
            }
        } else {
            ;//System.out.println("Invalid input. Please choose a number between 1 and 5.");
        }
    } while (!validInput);
    
    person.creatcourse(y, 1.5, list);
    
                person.cg();
                //person.printst();
                list.data.add(person);
            }
           
            break;
            
            case 2: 
            System.out.println("1. AI\n2. Security\n3. Optional Research\n4. Networking\n5. Embedded System");
            int p=sc.nextInt();
            switch (p) {
                case 1:
                list.printAI(); 
                break;

                case 2:
                list.printSecurity();
                break;
                case 3:
                list.printOR(); 
                break;
                case 4:
                list.printNET();  
                break;
                case 5:
                list.printES(); 
                break;
            
                default:
                    break;
            }
            break;
           

            case 3: 
            list.gpalist();
            break;

            case 4: 
            System.out.println("1. AI\n2. Security\n3. Optional Research\n4. Networking\n5. Embedded System");
            int q=sc.nextInt();
            switch (q) {
                case 1:
                list.gpaAI(); 
                break;
                case 2:
                list.gpaSEC();
                break;
                case 3:
                list.gpaOR();
                break;
                case 4:
                list.gpaNET();  
                break;
                case 5:
                list.gpaES(); 
                break;           
                default:
                    break;
            }
            break;

            case 5: 
            list.rollwiselist();
            break;

            default:
            break;

        }}
        while(x!=0);
        
        

        
        
    }
}


    




