package BankAccounts;
public class Fee extends BankAccounts{
    private static final int CHARGE = 5;
    public Fee(double balance){
        super();
        this.balance = balance;
    }
    @Override
    public void charge(){
        System.out.println("Charge: " + CHARGE);
        balance -= CHARGE;
    }
}