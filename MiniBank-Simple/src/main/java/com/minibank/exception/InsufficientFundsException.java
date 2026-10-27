package com.minibank.exception;
public class InsufficientFundsException extends BankException {
    public InsufficientFundsException() { super("Insufficient balance."); }
}
