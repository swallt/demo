package com.zhousx.demo.unsynch;

public class TransferRunnable implements Runnable{

    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable(Bank b,int from,double man){
        this.bank = b;
        this.fromAccount = from;
        this.maxAmount = man;
    }

    @Override
    public void run() {
        try {
            while (true){
                int toAccount = (int) (bank.size() * Math.random());

                double amount = maxAmount*Math.random();
                bank.transfer(fromAccount,toAccount,amount);
                Thread.sleep((int)(DELAY * Math.random()));
            }
        } catch (InterruptedException e){

        }
    }
}
