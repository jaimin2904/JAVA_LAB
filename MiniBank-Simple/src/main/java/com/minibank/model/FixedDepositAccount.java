package com.minibank.model;
public class FixedDepositAccount extends Account {
    public FixedDepositAccount(String name, long amount) { super(name, amount); }
    @Override public double interestRate() { return 7.0; }
}
