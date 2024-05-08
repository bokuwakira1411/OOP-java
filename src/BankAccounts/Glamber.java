package BankAccounts;

import java.util.Random;

public class Glamber extends BankAccounts{
    private static double pc = 0;
    private static double CHARGE = 0;
    public Glamber(double balance){
        super();
        this.balance = balance;
    }
    @Override
    public void charge(){
        System.out.println("Charge: " + CHARGE);
    }
    @Override
    public void withdraw(double amount){
        Random random = new Random();
        pc = random.nextDouble();
        if(pc < 0.5) CHARGE = 0;
        else CHARGE = amount * 2;
        super.withdraw(CHARGE);
    }
}