package com.minibank.model;
public class CurrentAccount extends Account {
    public CurrentAccount(String name, long amount) { super(name, amount); }
    @Override public double interestRate() { return 0.0; }
}
