package Transactions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank
{
    private final HashMap<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud()
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(int numOfOperation,String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException
    {
        accounts.get(toAccountNum).block();
        accounts.get(fromAccountNum).block();

        accounts.get(fromAccountNum).sendMoney(amount);
        accounts.get(toAccountNum).catchMoney(amount);

        long sumOfBank = 0;
        for (Map.Entry<String,Account> entry: accounts.entrySet()){
            sumOfBank += entry.getValue().getMoney();
        }
        System.out.println(numOfOperation + ": Transfer:  from " + fromAccountNum + "  to  " + toAccountNum + "  :  " +
                amount + "\nAll money of the bank: " + sumOfBank + "\n");

        if(amount > 50000 && isFraud()) {
            System.out.println(fromAccountNum + " blocked\n" + toAccountNum + " blocked" + "\n");
        }else{
            accounts.get(toAccountNum).unBlock();
            accounts.get(fromAccountNum).unBlock();
        }
    }

    public long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getMoney();
    }

    public void addAccount(String accountNum, long money){
        accounts.put(accountNum, new Account(accountNum, money));
    }

    public boolean isBlockAccount(String accountNum){
        return accounts.get(accountNum).isBlock();
    }
}
