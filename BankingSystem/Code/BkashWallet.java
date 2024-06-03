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





