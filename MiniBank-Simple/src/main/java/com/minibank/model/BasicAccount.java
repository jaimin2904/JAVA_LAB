package com.minibank.model;
public class BasicAccount extends Account {
    public BasicAccount(String name, long amount) { super(name, amount); }
    @Override public double interestRate() { return 0.0; }
}