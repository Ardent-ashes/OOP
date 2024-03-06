import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class bank{
    String name;
    List<Customer>customers;
    List<Employee>employees;

    bank()
    {
        this.name=name;
        this.customers=new ArrayList<>();
        this.employees= new ArrayList<>();
    }

    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }
    void printbank()
    {
        System.out.println(this.name+" Bank created ");
    }
}
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



class Customer extends bank{
    String name;
    String email;
   // String accountNumber;
    String bankName;
    String phoneNumber;
    Account account;
    int type;
    int bin;
    int tin;
    public Customer(String name, String email, /*String accountNumber,*/ String bankName, String phoneNumber, Account account ,int type) {
        this.name = name;
        this.email = email;
       // this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.phoneNumber = phoneNumber;
        this.account=account;
        this.type=type;
    }
    void print() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        // System.out.println("Account Number: " + accountNumber);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Phone Number: " + phoneNumber);
        // Print additional details specific to the Account class
        if (account != null) {
            account.print(); // Assuming Account class has a print method
        }
        if(type==0)
        {
            System.out.println("BIN: " + bin);
        }
        if(type==1)
        {
            System.out.println("TIN: " + tin);
        }
        
        
       
    }
}

class Account {
    int accountNumber;
    AccountType accountType;
    int atype;
    double balance;
    double year;

    Account(int accountNumber, AccountType accountType, double balance, int year) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.year=year;
    }
    void print() {
        System.out.println("Account Number: " + accountNumber);
        if(atype==0)
        {
            System.out.println("Account Type: Savings\n");
        }
        if(atype==1)
        {
            System.out.println("Account Type: Salary\n");
        }
        
        System.out.println("Balance: " + balance);
        System.out.println("Year: " + year);
    }
  
    public double calculateInterest() {
        if(atype==0 && year>=1)
        {
            this.balance*=1.025;
        }
        if(atype==1 && year>=1)
        {
            this.balance*=1.02;
        }
        // Logic for calculating interest
        return 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    void directCheque(Account account, double amount) {
        // Logic for withdrawing money via direct cheque
        // Assuming the account holder is given a cheque for the specified amount
        // The cheque can then be cashed or deposited into another account.
        if (amount <= account.balance) {
            // Issue a cheque to the account holder
            System.out.println("Issuing a cheque for $" + amount);
            // Deduct the amount from the account balance
            account.withdraw(amount);
        } else {
            System.out.println("Insufficient funds in account.");
        }
    }
void bkashWithdrawal(Account account, double amount) {
        // Check if account has sufficient balance
        if (amount <= account.balance) {
            // Withdraw from account
            account.withdraw(amount);
            
            // Deposit to recipient's BKash wallet
        } else {
            System.out.println("Insufficient funds in account.");
        }
    }

    void creditCardWithdrawal(Account account, double amount) {
        // Logic for withdrawing money via credit card
        // This method might involve charging the specified amount to the credit card
        // The cardholder will then need to pay off the balance later, possibly with interest.
        if (amount <= account.balance) {
            // Charge the amount to the credit card
            System.out.println("Charging $" + amount + " to credit card.");
            // Deduct the amount from the account balance
            account.withdraw(amount);
        } else {
            System.out.println("Insufficient funds in account.");
        }
    }
}

enum AccountType {
    SAVINGS, SALARY
    
}

class MoneyTransfer extends Account {
    
    public MoneyTransfer(int accountNumber, AccountType accountType, double balance, int year) {
        super(accountNumber, accountType, balance, year);
        
    }

    void bkashTransfer(String senderWallet, double amount, int accountNumber) {
        

}

    void eftTransfer(Account senderAccount, Account recipientAccount, double amount) {
        // Check if sender has sufficient balance in account
        if (amount <= senderAccount.balance) {
            // Withdraw from sender's account
            senderAccount.withdraw(amount);
            
            // Deposit to recipient's account
            recipientAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds in sender's account.");
        }
    }

   void manualTransfer(Account senderAccount, Account recipientAccount, double amount) {
        // Check if sender has sufficient balance in account
        if (amount <= senderAccount.balance) {
            // Withdraw from sender's account
            senderAccount.withdraw(amount);
            
            // Deposit to recipient's account
            recipientAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds in sender's account.");
        }
    }
}

class BkashWallet {
    String phoneNumber;
    double balance;

    public BkashWallet(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.balance = 0.0; // Initialize balance to zero
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds in BKash wallet.");
        }
    }
}





public class system{

    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int acc=1;
        int tin=1;
        int bin=1;
        List<Customer>cust= new ArrayList<>();;
       
        System.out.println("To Open a bankaccount as client Press 1(bankname)\n");
    
        do {
            System.out.println("To open a bank system press 0\n");
            System.out.println("To Open a bank account Press 1\n");
            System.out.println("To Open a bank account as empolyee Press 2\n");
            System.out.println("To deposit money press 3\n");
            System.out.println("To withdraw money press 4\n");
            System.out.println("For Quit press 5\n");
           
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            //Execute the selected operation
            switch (choice) {



                case 1:                    
                    Customer person= new Customer(null, null, null, null,new Account(0, AccountType.SAVINGS, 0.0, 0), 0) ;
                    System.out.print("If you are a organization press 1 or if you are person press 2: ");
                    int num2 = scanner.nextInt();
                    System.out.print("Name: ");
                       person.name= scanner.next();
                       System.out.print("Email: ");
                       person.email= scanner.next();
                       System.out.print("bankname: ");
                       person.bankName= scanner.next();
                       System.out.print("phone: ");
                       person.phoneNumber= scanner.next();
                       
                       person.account.balance=0;
                       System.out.print("balance: "+person.account.balance);
                       System.out.print("\nyear: ");
                       
                       person.account.year= scanner.nextDouble();
                        System.out.println("For savings account press 0 , for salary press 1");
                       int type=scanner.nextInt();
                
                    if(num2==2)
                    {
                       
                      person.bin=bin;
                      System.out.print("bin number: "+bin);
                      bin++;
                      person.type=0;
                       person.account.accountNumber= acc;
                       System.out.println("\nacc number: "+acc);
                       acc++;
                     }
                     if(num2==1)
                    {
                       
                      person.tin=tin;
                      person.type=1;
                      System.out.println("tin number: "+tin);
                      tin++;
                       person.account.accountNumber= acc;
                       System.out.println("acc number: "+acc);
                       acc++;
                     }
                     
                   
                     if(type==0)
                     {
                        person.account.atype=0;
                     }
                     if(type==1)
                     {
                        person.account.atype=1;
                     }
                     cust.add(person);
                     person.print();
                   

                    break;
                case 2:
                    Employee person2= new Employee(null, null, null, 0);
                    System.out.print("Employee Name: ");
                       person2.name= scanner.next();
                       System.out.print("Email: ");
                       person2.email= scanner.next();
                       System.out.print("bankname: ");
                       person2.bank= scanner.next();
                       System.out.print("EmployeeType(manager press 0, officer 1, Trainee 2 ): ");
                       person2.empolyeetype= scanner.nextInt();
                       person2.print();
                    break;
                case 3:
                System.out.print("For bkash press1, for eft press 2, for manual press3 \n ");
                int num3 = scanner.nextInt();
                
                   if(num3==1)
                   {
                        MoneyTransfer p1= new MoneyTransfer(acc, null,0,0);
                        System.out.print("Account no: ");
                        p1.accountNumber= scanner.nextInt();
                        System.out.print("Bkash no: ");
                        String s= scanner.next();

                        System.out.print("Balance to be added: ");
                        double amount= scanner.nextDouble();
                        
                        boolean f = false;

                            for (Customer customer : cust) {
                            if (customer.account != null && customer.account.accountNumber == p1.accountNumber) {
                            System.out.println("Customer with account number " + p1.accountNumber + " found:");
                            customer.account.balance+=amount;
                            customer.print(); // Print the details of the customer
                            f = true;
                            break; // Exit the loop once the customer is found
                            }
                            }
                   }

                   if(num3==2)
                   {
                        MoneyTransfer p1= new MoneyTransfer(acc, null,0,0);
                        p1.accountNumber= scanner.nextInt();
                        int amount= scanner.nextInt();
                         int ac= scanner.nextInt();
                      
                        boolean found = false;

                            
                            for (Customer customer2 : cust) {
                                if (customer2.account != null && customer2.account.accountNumber == ac) {
                                System.out.println("Customer with account number " + p1.accountNumber + " found:");
                                if( customer2.account.balance>=amount)
                                customer2.account.balance-=amount;
                                customer2.print(); // Print the details of the customer
                                found = true;
                                break; // Exit the loop once the customer is found
                                }
                            }
                            if(found)
                            {
                                for (Customer customer : cust) {
                                    if (customer.account != null && customer.account.accountNumber == p1.accountNumber) {
                                    System.out.println("Customer with account number " + p1.accountNumber + " found:");
                                    customer.account.balance+=amount;
                                    customer.print(); // Print the details of the customer
                                    found = true;
                                    break; // Exit the loop once the customer is found
                                    }}
                            }
                   }

                   if(num3==3)
                   {
                        MoneyTransfer p1= new MoneyTransfer(acc, null,0,0);
                        p1.accountNumber= scanner.nextInt();
                        int amount= scanner.nextInt();
                         int ac= scanner.nextInt();
                      
                        boolean found = false;

                            
                            for (Customer customer2 : cust) {
                                if (customer2.account != null && customer2.account.accountNumber == ac) {
                                System.out.println("Customer with account number " + p1.accountNumber + " found:");
                                if( customer2.account.balance>=amount)
                                customer2.account.balance-=amount;
                                customer2.print(); // Print the details of the customer
                                found = true;
                                break; // Exit the loop once the customer is found
                                }
                            }
                            if(found)
                            {
                                for (Customer customer : cust) {
                                    if (customer.account != null && customer.account.accountNumber == p1.accountNumber) {
                                    System.out.println("Customer with account number " + p1.accountNumber + " found:");
                                    customer.account.balance+=amount;
                                    customer.print(); // Print the details of the customer
                                    found = true;
                                    break; // Exit the loop once the customer is found
                                    }}
                            }
                   }
                   
                    break;
                case 4:
                System.out.print("For directcheck press1, for bkash wallet 2, for credit card 3 \n ");
                int num4= scanner.nextInt();
                System.out.println("Account which will bw withdrawal: ");
            
                int ac= scanner.nextInt();
                System.out.println("Amount: ");
                double amount=scanner.nextDouble();
                boolean found = false;

                            
                            for (Customer customer2 : cust) {
                                if (customer2.account != null && customer2.account.accountNumber == ac) {
                                System.out.println("Customer with account number " + ac + " found:");
                                if( customer2.account.balance>=amount)
                                {
                                    customer2.account.balance-=amount;
                                }
                                else
                                System.out.println("Not Sufficient amount found");

                               
                                customer2.print(); // Print the details of the customer
                                found = true;
                                break; // Exit the loop once the customer is found
                                }
                            }
                
                
                    break;

                
                    case 0:
                    bank b= new bank();
                    b.name=scanner.next();
                    b.printbank();
                    //we can implement the bank client list or bank list by that as our wish
                     break;
                case 5:
                    break;
                default:
                    // invalid choice
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5); // repeat until the user chooses to exit
        
        scanner.close(); // close the scanner
    }
    
    }
