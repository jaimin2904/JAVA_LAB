package com.minibank.model;
import java.io.Serializable;
import java.util.Objects;
public abstract class Account implements Serializable, Comparable<Account>, Transactable, InterestBearing, WithdrawRule {
    private static final long serialVersionUID = 1L;
    @Id
    private final String accountNumber;
    @MaxLength(50)
    private final String ownerName;
    @Positive
    private long balance;
    private boolean active = true;
    private static long counter = 1;
    public Account(String ownerName, long openingBalance) {
        this.accountNumber = String.format("AC%04d", counter++);
        this.ownerName = ownerName;
        this.balance = Math.max(0, openingBalance);
    }
    public Account(String ownerName) { this(ownerName, 0); }
    public synchronized boolean deposit(long amount) {
        if (amount <= 0 || !active) return false;
        balance += amount;
        return true;
    }
    public synchronized boolean canWithdraw(long amount) { return amount > 0 && amount <= balance && active; }
    public synchronized boolean withdraw(long amount) {
        if (!canWithdraw(amount)) return false;
        balance -= amount;
        return true;
    }
    public static synchronized void updateCounter(String number) {
        try { counter = Math.max(counter, Long.parseLong(number.substring(2)) + 1); }
        catch (RuntimeException ignored) { }
    }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public synchronized long getBalance() { return balance; }
    public boolean isActive() { return active; }
    public void close() { active = false; }
    public abstract double interestRate();
    @Override public String toString() { return accountNumber + " | " + ownerName + " | Balance: Rs. " + getBalance(); }
    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account other)) return false;
        return accountNumber.equals(other.accountNumber);
    }
    @Override public int hashCode() { return Objects.hash(accountNumber); }
    @Override public int compareTo(Account other) { return accountNumber.compareTo(other.accountNumber); }
}
