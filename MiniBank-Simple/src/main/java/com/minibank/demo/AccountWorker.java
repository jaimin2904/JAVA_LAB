package com.minibank.demo;
import com.minibank.model.Account;
public class AccountWorker implements Runnable {
    private final Account account;
    private final int count;
    public AccountWorker(Account account, int count) { this.account = account; this.count = count; }
    @Override public void run() { for (int i = 0; i < count; i++) account.deposit(1); }
    public static void main(String[] args) throws Exception {
        Account account = new com.minibank.model.BasicAccount("Thread Demo", 0);
        Thread first = new Thread(new AccountWorker(account, 1000));
        Thread second = new Thread(new AccountWorker(account, 1000));
        first.start(); second.start(); first.join(); second.join();
        System.out.println("Final balance: " + account.getBalance());
    }
}