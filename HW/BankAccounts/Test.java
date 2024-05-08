package BankAccounts;

public class Test {
    public static void main(String[] args) {
        BankAccounts[] accounts = new BankAccounts[3];
        Fee f = new Fee(20);
        NickleDime n = new NickleDime(50);
        Glamber g = new Glamber(70);
        accounts[0] = f;
        accounts[1] = n;
        accounts[2] = g;
        for(BankAccounts account: accounts){
            account.withdraw(10);
            account.endMonth();

        }
    }
}
