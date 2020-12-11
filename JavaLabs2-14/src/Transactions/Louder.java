package Transactions;

import java.util.Random;

public class Louder {
    private static final int COUNT_OF_ACCOUNT = 20;
    private static final int COUNT_OF_OPERATION = 50;
    private static final Random random = new Random();

    public static void main(String[] args){
        Bank bank = new Bank();

        for(int i = 1000; i < 1000 + COUNT_OF_ACCOUNT; i++){
            bank.addAccount(String.valueOf(i), (long)(Math.random() * 1_000_000) + 500_000);
        }
        for(int i = 0; i < COUNT_OF_OPERATION; i++){

            String fromAccount = getRandomAccountNum();
            while(bank.isBlockAccount(fromAccount)) fromAccount = getRandomAccountNum();
            String finalFromAccount = fromAccount;

            if(random.nextBoolean()) {
                transfer(i,finalFromAccount, bank);
            }else{
                int finalI = i;
                new Thread(() -> System.out.println(finalI + ": Balance of " + finalFromAccount + " : " +
                        bank.getBalance(finalFromAccount) + "\n")).start();
            }
        }
    }

    public static String getRandomAccountNum(){
        return String.valueOf((int)(Math.random()*COUNT_OF_ACCOUNT + 1000));
    }

    public static long getRandomAmount(){
        return (long)(Math.random()*100_000) + 10_000;
    }

    public static void transfer(int numOfOperation,String fromAccount, Bank bank){
        String toAccount = getRandomAccountNum();
        while (fromAccount.equals(toAccount) || bank.isBlockAccount(toAccount)) toAccount = getRandomAccountNum();
        String finalToAccount = toAccount;

        long amount = getRandomAmount();
        while (amount > bank.getBalance(fromAccount)) amount = getRandomAmount();
        long finalAmount = amount;


        new Thread(() -> {
            try {
                bank.transfer(numOfOperation, fromAccount, finalToAccount, finalAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
