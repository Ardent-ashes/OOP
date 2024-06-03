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
