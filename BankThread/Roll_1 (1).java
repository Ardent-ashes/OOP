import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Account {
    String accountHolderName;
    String accountNumber;
    int maximumTransactionLimit;
    int balance;

    public Account(String accountHolderName, String accountNumber, int maximumTransactionLimit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.maximumTransactionLimit = maximumTransactionLimit;
        this.balance = 0;
    }

    /*public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " BDT to account " + accountNumber+ "Account balance"+balance);
    }*/

    public synchronized void deposit(int amount) throws Exception {
        if (amount > maximumTransactionLimit) {
            throw new Exception("Maximum WithdrawTransaction Limit Violated");
        }
        balance += amount;
        System.out.println("Successfully deposited " + amount + " BDT into account " + accountNumber+" Account balance: "+balance+" BDT"+"\n");
         //System.out.println("Successfully Withdrawn " + amount + " BDT from account " + accountNumber+"Account balance "+balance);
    }

    public synchronized void withdraw(int amount) throws Exception {
        if (amount > maximumTransactionLimit) {
            throw new Exception("Maximum WithdrawTransaction Limit Violated");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance");
        }
       
        balance -= amount;
        System.out.println("Successfully Withdrawn " + amount + " BDT from account " + accountNumber+" Account balance "+balance+" BDT"+"\n");
    }
}

class  AccountGenerationThread extends Thread {
    List<Account> accounts;
    int time;
    Random random = new Random();
    AccountGenerationThread(List<Account> accounts, int t)
    {
        this.accounts=accounts;
        this.time=t;
        
    }

    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            String accountHolderName = "Account Holder " + i;
            String accountNumber = generateAccountNumber();
            int maximumTransactionLimit = random.nextInt(1000) + 1;
            Account account = new Account(accountHolderName, accountNumber, maximumTransactionLimit);
            accounts.add(account);
            
            System.out.println("Created account: "+  accountNumber+" Account Holder: "+accountHolderName+" maximum transfer "+ maximumTransactionLimit+" BDT");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // for (Account acc : accounts) {
        //     System.out.println(acc);
        // }
        
    }

    private String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        accountNumber.append((char) (random.nextInt(26) + 'a'));
        accountNumber.append((char) (random.nextInt(26) + 'a'));
        for (int i = 0; i < 10; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }
}

class TransactionThread extends Thread {
    List<Account> accounts;
    List<data> transactions;
    Random random = new Random();

    public TransactionThread(List<Account> accounts, List<data> transactions) {
        this.accounts = accounts;
        this.transactions = transactions;
    }
}

class DepositGenerationThread extends TransactionThread {
    int time;
    public DepositGenerationThread(List<Account> accounts, List<data> transactions, int t) {
        super(accounts, transactions);
        this.time=t;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 500; i++) {
            int amount;
            int accountIndex;
            data d=new data(0, 0);
            synchronized (accounts) {
                if (accounts.isEmpty()) {
                   System.out.println("hi");
                    return;
                }
                amount = random.nextInt(50000) + 1;
                accountIndex = random.nextInt(accounts.size());
                d.trans=amount;
                d.acc=accountIndex;
            }
            Account account = accounts.get(accountIndex);
            synchronized (transactions) {
                transactions.add(d);
                System.out.println("Generated deposit of " + amount + " BDT for account " + account.accountNumber);
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WithdrawGenerationThread extends TransactionThread {
    int time;
    public WithdrawGenerationThread(List<Account> accounts, List<data> transactions, int t) {
        super(accounts, transactions);
        this.time=t;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 500; i++) {
            int amount = random.nextInt(100000) + 1;
            int accountIndex = random.nextInt(accounts.size());
            Account account = accounts.get(accountIndex);
            data d=new data(0, 0);
            amount = random.nextInt(50000) + 1;
            accountIndex = random.nextInt(accounts.size());
            d.trans=amount;
            d.acc=accountIndex;
            synchronized (transactions) {
                ////transactions.add(-amount);
                transactions.add(d);
                System.out.println("Generated withdrawal of " + amount + " BDT for account " + account.accountNumber);
            }
            try {
                Thread.sleep(time);
               
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TransactionProcessingThread extends Thread {
    List<Account> accounts;
    List<data> transactions;

    public TransactionProcessingThread(List<Account> accounts, List<data> transactions2) {
        this.accounts = accounts;
        this.transactions = transactions2;
    }
}

class DepositProcessingThread extends TransactionProcessingThread {
    int start;
    int end;
    int time;
    public DepositProcessingThread(List<Account> accounts, List<data> transactions, int k, int l, int t) {
        super(accounts, transactions);
        this.start=k;
        this.end=l;
        this.time=t;
    }

    @Override
    public void run() {
        for (int i=start; i<=end;i++) {
           /// int accountIndex = (int) Math.abs(amount) % accounts.size();
            //Account account = accounts.get(accountIndex);
            data d = transactions.get(i);
            try {
                //System.out.println("depositing from "+accounts.get(d.acc).accountNumber+"amount "+d.trans);
                accounts.get(d.acc).deposit(d.trans);
            } catch (Exception e) {
                System.out.println("depositing into "+accounts.get(d.acc).accountNumber+" amount "+d.trans+" BDT"+"\n"+"Error: " + e.getMessage()+"\n");
    
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WithdrawProcessingThread extends TransactionProcessingThread {
    int start;
    int end;
    int time;
    public WithdrawProcessingThread(List<Account> accounts, List<data> transactions, int k, int l, int t) {
        super(accounts, transactions);
        this.start=k;
        this.end=l;
        this.time=t;
    }

    @Override
    public void run() {
        for (int i=start; i<=end;i++) {
           // int accountIndex = (int) Math.abs(amount) % accounts.size();
            //Account account = accounts.get(accountIndex);
            data d = transactions.get(i);
            try {
                //account.withdraw(amount);
                //System.out.println("withdrawing from "+accounts.get(d.acc).accountNumber+"amount "+d.trans);
                accounts.get(d.acc).withdraw(d.trans);
            } catch (Exception e) {
                System.out.println("withdrawing from "+accounts.get(d.acc).accountNumber+" amount "+d.trans+" BDT"+"\n"+"Error: " + e.getMessage()+"\n");
            }
            try {
                 Thread.sleep(time);
                 
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class data{
    int trans;
    int acc;
    data(int amount, int acc){
        this.trans=amount;
        this.acc=acc;
    }
}

public class Roll_1 {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        List<data> depositTransactions = new ArrayList<>();
        List<data> withdrawTransactions = new ArrayList<>();

        AccountGenerationThread accountGenerationThread = new AccountGenerationThread(accounts,1000);
        DepositGenerationThread depositGenerationThread = new DepositGenerationThread(accounts, depositTransactions,1000);
        WithdrawGenerationThread withdrawGenerationThread = new WithdrawGenerationThread(accounts, withdrawTransactions,1000);
        DepositProcessingThread depositProcessingThread1 = new DepositProcessingThread(accounts, depositTransactions,0,250,1000);
        DepositProcessingThread depositProcessingThread2 = new DepositProcessingThread(accounts, depositTransactions,251,499,800);
        WithdrawProcessingThread withdrawProcessingThread1 = new WithdrawProcessingThread(accounts, withdrawTransactions,0,250,1000);
        WithdrawProcessingThread withdrawProcessingThread2 = new WithdrawProcessingThread(accounts, withdrawTransactions,251,499,800);
        
       
        
        accountGenerationThread.start();
        
        

        try {
            
            accountGenerationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // // Print the accounts list
        // System.out.println("Accounts:");
        // for (Account account : accounts) {
        //     System.out.println(account);
        // }
        depositGenerationThread.start();
        /*try {
            depositGenerationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // Now start withdrawGenerationThread
        withdrawGenerationThread.start();
        try {
            depositGenerationThread.join();
            withdrawGenerationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }      
            
         depositProcessingThread1.start();
         depositProcessingThread2.start();
        
         try {
            depositProcessingThread1.join();
            depositProcessingThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
         withdrawProcessingThread1.start();
         withdrawProcessingThread2.start();
        
       
         
    }
}
