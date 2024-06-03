class Employee{
    String name;
    String email;
    String bank;
    int empolyeetype;

    public Employee(String name, String email, String bank, int empolyeetype){
        this.name=name;
        this.email=email;
        this.bank=bank;
        this.empolyeetype= empolyeetype;
    }
    void print() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        if(empolyeetype==0)
        {
            System.out.println("Employee Type: Manager");
        }
        if(empolyeetype==1)
        {
            System.out.println("Employee Type: Officer");
        }
        if(empolyeetype==2)
        {
            System.out.println("Employee Type: Trainee");
        }
       
    }

}

