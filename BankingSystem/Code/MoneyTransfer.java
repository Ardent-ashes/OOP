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
