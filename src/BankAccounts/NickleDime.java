package BankAccounts;
public class NickleDime extends BankAccounts{
    private static int wdCount = 0;
    public NickleDime(double balance){
        super();
        this.balance = balance;
    }
    @Override
    public void withdraw(double amount){
        super.withdraw(amount);
        wdCount++;
    }
    @Override
    public void charge(){
        double c = 0.5 * wdCount;
        balance -= c;
        System.out.println("Charge: " + c);
    }
    @Override
    public void endMonth(){
        super.endMonth();
        wdCount = 0;
    }
}