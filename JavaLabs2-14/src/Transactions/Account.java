package Transactions;

public class Account
{
    private long money;
    private final String accNumber;
    private volatile boolean  isBlock = false;

    public void block(){
        isBlock = true;
    }

    public void unBlock(){
        isBlock = false;
    }

    public boolean isBlock(){
        return isBlock;
    }

    public Account(String accNumber, long money) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public long getMoney() {
        return money;
    }

    public void sendMoney(long money){
        this.money -= money;
    }

    public void catchMoney(long money){
        this.money += money;
    }
}
