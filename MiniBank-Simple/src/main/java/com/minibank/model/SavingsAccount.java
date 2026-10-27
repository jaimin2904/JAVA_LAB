package com.minibank.model;
public class SavingsAccount extends Account {
    public SavingsAccount(String name, long amount) { super(name, amount); }
    @Override public double interestRate() { return 4.0; }
}
