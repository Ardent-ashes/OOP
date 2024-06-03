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
