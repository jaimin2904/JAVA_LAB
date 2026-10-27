package com.minibank.service;
import com.minibank.model.Account;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
public class AccountStore {
    private final ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
    private final ArrayList<String> history = new ArrayList<>();
    public void add(Account account) { accounts.put(account.getAccountNumber(), account); }
    public Account get(String number) { return accounts.get(number); }
    public ArrayList<Account> getAll() { return new ArrayList<>(accounts.values()); }
    public ArrayList<Account> sortedByBalance() {
        ArrayList<Account> result = getAll();
        result.sort(Comparator.comparingLong(Account::getBalance));
        return result;
    }
    public synchronized void addHistory(String line) { history.add(line); }
    public synchronized ArrayList<String> getHistory() { return new ArrayList<>(history); }
}
