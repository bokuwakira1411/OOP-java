package BankAccounts;

abstract public class BankAccounts{
    public double balance;
    public static int transactions;
    public void charge(){}
    public void deposit(double amount){
        transactions++;
        balance += amount;
    }
    public void withdraw(double amount){
        transactions++;
        balance -= amount;
    }
    public void endMonth(){
        charge();
        System.out.println("Balance: " + balance);
        System.out.println("Transactions: " + transactions);
    }
}