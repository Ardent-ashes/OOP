import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
        switch (n) {
            case 1:
                {
                    AI s= new AI();
                    System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
                    int x=sc.nextInt();
                    switch(x){
                        case 1:
                        int a=sc.nextInt(), b=sc.nextInt();
                        s.ev= new Evaluation(a,b);
                        break;
                        case 2:
                        int c=sc.nextInt(), d=sc.nextInt(), e=sc.nextInt();
                        s.ev= new Evaluation(c,d,e);
                        break;
                        case 3:
                        int f=sc.nextInt(), i=sc.nextInt(), g=sc.nextInt(), h=sc.nextInt();
                        s.ev= new Evaluation(f,g,h,i);
                        break;
                    }

                    Course c =s;
                    if(credit ==3) majorList.add(c);
                    else minCourse=c;
                    
                    
                    double courseGPA = s.ev.GPA(); // Calculate GPA for the course
                    aicg=s.ev.GPA();
                    ai=s.ev.total;
                    cgpa += credit * courseGPA;
                    rl.AI.add(this);
                    break;
                }
            case 2:
                {
                    Security s= new Security();
                    System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
                    int x=sc.nextInt();
                    switch(x){
                        case 1:
                        int a=sc.nextInt(), b=sc.nextInt();
                        s.ev= new Evaluation(a,b);
                        break;
                        case 2:
                        int c=sc.nextInt(), d=sc.nextInt(), e=sc.nextInt();
                        s.ev= new Evaluation(c,d,e);
                        break;
                        case 3:
                        int f=sc.nextInt(), i=sc.nextInt(), g=sc.nextInt(), h=sc.nextInt();
                        s.ev= new Evaluation(f,g,h,i);
                        break;
                    }
                    
                    cgpa+= credit * s.ev.GPA();
                    seccg=s.ev.GPA();
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
                    System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
                    int x=sc.nextInt();
                    switch(x){
                        case 1:
                        int a=sc.nextInt(), b=sc.nextInt();
                        s.ev= new Evaluation(a,b);
                        break;
                        case 2:
                        int c=sc.nextInt(), d=sc.nextInt(), e=sc.nextInt();
                        s.ev= new Evaluation(c,d,e);
                        break;
                        case 3:
                        int f=sc.nextInt(), i=sc.nextInt(), g=sc.nextInt(), h=sc.nextInt();
                        s.ev= new Evaluation(f,g,h,i);
                        break;
                    }
                    
                    cgpa+= credit * s.ev.GPA();
                    orcg=s.ev.GPA();
                    or=s.ev.total;
                    rl.OR.add(this);
                   
                    Course c =s;
                    if(credit ==3) majorList.add(c);
                    else minCourse=c;
                    break;
            }
            case 4:
            {
                NET s= new NET();
                System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
                int x=sc.nextInt();
                switch(x){
                    case 1:
                    int a=sc.nextInt(), b=sc.nextInt();
                    s.ev= new Evaluation(a,b);
                    break;
                    case 2:
                    int c=sc.nextInt(), d=sc.nextInt(), e=sc.nextInt();
                    s.ev= new Evaluation(c,d,e);
                    break;
                    case 3:
                    int f=sc.nextInt(), i=sc.nextInt(), g=sc.nextInt(), h=sc.nextInt();
                    s.ev= new Evaluation(f,g,h,i);
                    break;
                }
                Course c =s;
                if(credit ==3) majorList.add(c);
                else minCourse=c;
                cgpa+= credit * s.ev.GPA();
                netcg=s.ev.GPA();
                net=s.ev.total;
                rl.NET.add(this);
                
                break;
        }
        case 5:
        {
            ES s= new ES();
            System.out.println("Choose the evaluation procedure: 1.final+mid  2.final+mid+assignm  3. final+mid+assi+atten");
            int x=sc.nextInt();
            switch(x){
                case 1:
                int a=sc.nextInt(), b=sc.nextInt();
                s.ev= new Evaluation(a,b);
                break;
                case 2:
                int c=sc.nextInt(), d=sc.nextInt(), e=sc.nextInt();
                s.ev= new Evaluation(c,d,e);
                break;
                case 3:
                int f=sc.nextInt(), i=sc.nextInt(), g=sc.nextInt(), h=sc.nextInt();
                s.ev= new Evaluation(f,g,h,i);
                break;
                default:
                System.out.println("Invalid Input");
                break;
            }
            Course c =s;
            if(credit ==3) majorList.add(c);
            else minCourse=c;
            cgpa+= credit * s.ev.GPA();   
            escg=s.ev.GPA();
            es=s.ev.total;
            rl.ES.add(this);
            
            break;            
        }    
        
 }
 }

 void cg()
 {
     this.cgpa= this.cgpa/(10.5);
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
    double gp;
    Scanner sc= new Scanner(System.in);
    Evaluation(int finalScore, int midtermScore) {
        boolean valid=false;
        while (!valid){
        if((finalScore<=70 && midtermScore<=30 && finalScore+midtermScore<=100)||(finalScore<=60 && midtermScore<=40 && finalScore+midtermScore<=100))
        {
            this.total=finalScore+midtermScore;
            valid=true;
        
        }    
        else
        {
            System.out.print("Final Score: ");
            finalScore= sc.nextInt();
            System.out.print("Mid Score: ");
            midtermScore= sc.nextInt();
        }
       
        }

    }
    Evaluation(int finalScore, int midtermScore, int assignment ) {
        // Constructor implementation
        boolean valid=false;
        while (!valid){
        if((finalScore<=70 && midtermScore<=20 && assignment<=10 && finalScore+midtermScore+assignment<=100)||(finalScore<=60 && midtermScore<=30 && assignment<=10 && assignment+finalScore+midtermScore<=100))
        {
            this.total=finalScore+midtermScore+assignment;
            valid=true;
        
        }    
        else
        {
            System.out.print("Invalid input please try again:\n");
            System.out.print("Final Score: ");
            finalScore= sc.nextInt();
            System.out.print("Mid Score: ");
            midtermScore= sc.nextInt();
            System.out.print("Assignment: ");
            assignment= sc.nextInt();
        }
       
        }
    }
    Evaluation(int finalScore, int midtermScore, int assignment, int attendance) {
        this.total=finalScore+midtermScore+assignment+attendance;
        boolean valid=false;
        while (!valid){
        if((finalScore<=70 && midtermScore<=20 && assignment<=5 && attendance<=5 && attendance+finalScore+midtermScore+assignment<=100))
        {
            this.total=finalScore+midtermScore+assignment+attendance;
            valid=true;
        
        }    
        else
        {
            System.out.print("Invalid input please try again:\n");
            System.out.print("Final Score: ");
            finalScore= sc.nextInt();
            System.out.print("Mid Score: ");
            midtermScore= sc.nextInt();
            System.out.print("Assignment: ");
            assignment= sc.nextInt();
            System.out.print("Attendance: ");
            attendance= sc.nextInt();
        }
       
        }
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
}


class Security extends Course {
    Evaluation ev;
    @Override
    double marks() {
        System.out.print("Securiy "+ev.gp+" Marks: ");
        return ev.total;
    }

}

class AI extends Course {
    Evaluation ev;
    double marks(){
        System.out.print("AI "+ev.gp+" Marks: ");
        return ev.total;
    }
}

class OR extends Course {
    Evaluation ev;
    double marks(){
        System.out.print("OR "+ev.gp+" Marks: ");
        return ev.total;
    }
}

class ES extends Course {
    Evaluation ev;
    double marks(){
        System.out.print("EV "+ev.gp+" Marks: ");
        return ev.total;
    }
}

class NET extends Course {
    Evaluation ev;
    double marks(){
        System.out.print("NET "+ev.gp+" Marks ");
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
        Collections.sort(data, Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("Sorted GPA list:");
        int i=1;
        for (Student student : data) {
            System.out.println(i+". Name: " + student.getName() + ", GPA: " + student.getGpa());
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
            System.out.println("Name: " + student.getName() + ", GPA: " + student.getGpa());
        }
    }
    public void printES() {
        System.out.println("ES List:");
        for (Student student : ES) {
            System.out.println("Name: " + student.getName() + ", GPA: " + student.getGpa());
        }
    }

    public void printNET() {
        System.out.println("NET List:");
        for (Student student : NET) {
            System.out.println("Name: " + student.getName() + ", GPA: " + student.getGpa());
        }
    }
    public void printOR() {
        System.out.println("OR List:");
        for (Student student : OR) {
            System.out.println("Name: " + student.getName() + ", GPA: " + student.getGpa());
        }
    }
    public void printSecurity() {
        System.out.println("Security List:");
        for (Student student : Security) {
            System.out.println("Name: " + student.getName() + ", GPA: " + student.getGpa());
        }
    }

    // Similarly, implement methods to print other lists like ES, NET, OR, Security
}

public class Main {
    public static void main(String[] args) {
        Rank list= new Rank();
        int[] code = new int[5];
        Scanner sc = new Scanner(System.in);
        int x;
        do{
        System.out.println("1. Add Student\t2. Print List\n3. Print AI\t4. Print Security\n5. Print OR\t6. Print NET\n7. Print ES \t8. Rank AI\n9. Rank Sec\t10. Rank OR\n11. Rank NET\t12. Rank ES\n0.Exit");
        x= sc.nextInt();
        switch (x) {
            case 1:
            System.out.print("Name: ");
            String name= sc.next();
            System.out.print("Roll: ");
            int roll=sc.nextInt();
            System.out.print("Email: ");
            String email=sc.next();
            Student person= new Student(name, roll, email);
    for (int i = 0; i < 3; i++) {
    boolean validInput = false;
    while (!validInput) {
        System.out.println("Choose any of them as a major course:\n1. AI\n2. Security\n3. OptionalResearch\n4. Networking\n5. Embedded System");
        int y = sc.nextInt();
        if (y >= 1 && y <= 5) { // Check if the input is within the valid range
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (code[j] == y) { // Check if the input is a duplicate
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                person.creatcourse(y, 3, list);
                code[i] = y;
                validInput = true;
            } else {
                System.out.println("You have already chosen this course. Please choose another one.");
            }
        } else {
            System.out.println("Invalid input. Please choose a number between 1 and 5.");
        }
    }
}
System.out.println("Choose any of them as optional course:\n1. AI\n2. Security\n3. OptionalResearch\n4. Networking\n5. Embedded System");
int y;
boolean validInput = false;
do {
    y = sc.nextInt();
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
            System.out.println("You have already chosen this course as optional. Please choose another one.");
        }
    } else {
        System.out.println("Invalid input. Please choose a number between 1 and 5.");
    }
} while (!validInput);

person.creatcourse(y, 1.5, list);

            person.cg();
            person.printst();
            list.data.add(person);
            break;
            
            case 2: 
            list.gpalist();
            break;

            case 3: 
            list.printAI();
            break;

            case 4: 
            list.printSecurity();
            break;

            case 5: 
            list.printOR();
            break;

            case 6: 
            list.printNET();
            break;

            case 7: 
            list.printES();
            break;

            case 8: 
            list.gpaAI();
            break;

            case 9: 
            list.gpaSEC();
            break;

            case 10: 
            list.gpaOR();
            break;

            case 11: 
            list.gpaNET();
            break;

            case 12: 
            list.gpaES();
            break;



            default:
            break;

        }}
        while(x!=0);
        
        

        
        
    }

    


}
