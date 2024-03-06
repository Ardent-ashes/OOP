import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class bank{
    String name;
    List<Customer>customers;
    List<Employee>emplyees;

    public bank()
    {
        this.name=name;
        this.customers=new ArrayList<>();
        this.emplyees= new ArrayList<>();
    }

    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    public void addEmployee(Employee employee)
    {
        emplyees.add(employee);
    }
}
class Employee{
    String name;
    String email;
    EmpolyeeType empolyeetype;

    public Employee(String name, String email, EmpolyeeType empolyeetype){
        this.name=name;
        this.email=email;
        this.empolyeetype= empolyeetype;
    }

}

enum EmployeeType {
    MANAGER, OFFICER, TRAINEE
}

class Customer{
    String name;
    String email;
    String accountNumber;
    String bankName;
    String phoneNumber;
    Account account;
    public Customer(String name, String email, String accountNumber, String bankName, String phoneNumber, Account account) {
        this.name = name;
        this.email = email;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.phoneNumber = phoneNumber;
        this.account=account;
    
    }
}

class SinglePerson extends Customer {
    private String binNumber;

    public SinglePerson(String name, String email, String accountNumber, String bankName, String phoneNumber, String binNumber, Account account) {
        super(name, email, accountNumber, bankName, phoneNumber, account);
        this.binNumber = binNumber;
    }

}


class Organization extends Customer {
    private String tinNumber;

    public Organization(String name, String email, String accountNumber, String bankName, String phoneNumber, Account account, String tinNumber) {
        super(name, email, accountNumber, bankName, phoneNumber, account);
        this.tinNumber = tinNumber;
    }
}


class Account {
    String accountNumber;
    AccountType accountType;
    double balance;
    double year;

    public Account(String accountNumber, AccountType accountType, double balance, int year) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.year=year;
    }


    public double calculateInterest() {
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
}

enum AccountType {
    SAVINGS, SALARY
    
}

class MoneyTransfer extends Account {
    
    public MoneyTransfer(String accountNumber, AccountType accountType, double balance, int year) {
        super(accountNumber, accountType, balance, year);
        
    }

    public static void bkashTransfer(BkashWallet senderWallet, double amount, Account recipientAccount) {
        // Check if sender has sufficient balance in BKash wallet
        if (amount <= senderWallet.balance) {
            // Withdraw from sender's BKash wallet
            senderWallet.withdraw(amount);
            
            // Deposit to recipient's account
            recipientAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds in BKash wallet.");
        }
    }

    public static void eftTransfer(Account senderAccount, Account recipientAccount, double amount) {
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

    public static void manualTransfer(Account senderAccount, Account recipientAccount, double amount) {
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

class WithdrawalMethod {
    public static void directCheque(Account account, double amount) {
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

    public static void bkashWithdrawal(Account account, double amount, BkashWallet recipientWallet) {
        // Check if account has sufficient balance
        if (amount <= account.balance) {
            // Withdraw from account
            account.withdraw(amount);
            
            // Deposit to recipient's BKash wallet
            recipientWallet.deposit(amount);
        } else {
            System.out.println("Insufficient funds in account.");
        }
    }

    public static void creditCardWithdrawal(Account account, double amount) {
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




public class system{

    public static void main()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
       
        System.out.println("To Open a bank Press 1(bankname)\n");
        System.out.println("To Open a bank Press 1(bankname)\n");
        System.out.println("To Open a bank Press 1(bankname)\n");
        System.out.println("To Open a bank Press 1(bankname)\n");
        Account ac1= new Account(1, AccountType.SAVINGS, 0, 1);
        do {
            System.out.println("To Open a bank Press 1(bankname)\n");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            //Execute the selected operation
            switch (choice) {
                case 1:
                    // addition
                    System.out.print("To add Customer press 1 or toadd Empolyee press 2 ");
                    int num1 = scanner.nextInt();
                   if(num1==1)
                   {
                    String name= scanner.next();
                     String email= scanner.next();
                    String accountNumber= scanner.next();
                    String bankName=scanner.next();
                    String phoneNumber=scanner.next();
                    AccountType accountType= scanner.() ;
                    double balance=scanner.nextDouble();
                    double year=scanner.nextDouble();
                
                    Account account= new Account
                    Customer customer1= new Customer(null, null, null, null, null, ac1)
                   }
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    // subtraction
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    // multiplication
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    // division
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    if (num2 == 0) {
                        // divide-by-zero error
                        System.out.println("Cannot divide by zero");
                    } else {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    }
                    break;
                case 5:
                    //Exit the program
                    System.out.println("Exiting program...");
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
}
