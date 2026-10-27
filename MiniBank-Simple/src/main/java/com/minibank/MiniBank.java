package com.minibank;

import com.minibank.model.Account;
import com.minibank.model.BankInfo;
import com.minibank.model.BasicAccount;
import com.minibank.model.MenuOption;
import com.minibank.util.StatementFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniBank {
    private static final ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(new BankInfo("MiniBank", "Rajkot Branch"));
        boolean running = true;

        while (running) {
            System.out.println("\n1. Open Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. List Accounts\n6. Statement\n7. Exit");
            System.out.print("Choose: ");
            String choice = input.nextLine().trim();

            MenuOption option = switch (choice) {
                case "1" -> MenuOption.OPEN_ACCOUNT;
                case "2" -> MenuOption.DEPOSIT;
                case "3" -> MenuOption.WITHDRAW;
                case "4" -> MenuOption.TRANSFER;
                case "5" -> MenuOption.LIST_ACCOUNTS;
                case "6" -> MenuOption.STATEMENT;
                case "7" -> MenuOption.EXIT;
                default -> null;
            };

            if (option == null) {
                System.out.println("Please enter a number from 1 to 7.");
                continue;
            }

            try {
                switch (option) {
                    case OPEN_ACCOUNT -> openAccount(input);
                    case DEPOSIT -> deposit(input);
                    case WITHDRAW -> withdraw(input);
                    case TRANSFER -> transfer(input);
                    case LIST_ACCOUNTS -> listAccounts();
                    case STATEMENT -> statement(input);
                    case EXIT -> running = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }

        System.out.println("Thank you for using MiniBank. Goodbye!");
        input.close();
    }

    private static void openAccount(Scanner input) {
        System.out.print("Owner name: ");
        String name = input.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Owner name cannot be empty.");
            return;
        }
        System.out.print("Opening balance: ");
        long amount = Long.parseLong(input.nextLine().trim());
        if (amount < 0) {
            System.out.println("Opening balance cannot be negative.");
            return;
        }
        Account account = new BasicAccount(name, amount);
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    private static void deposit(Scanner input) {
        Account account = findAccount(input, "Account number: ");
        if (account == null) return;
        System.out.print("Amount: ");
        long amount = Long.parseLong(input.nextLine().trim());
        if (account.deposit(amount)) {
            System.out.println("Deposit successful. Balance: Rs. " + account.getBalance());
        } else {
            System.out.println("Enter a positive amount and try again.");
        }
    }

    private static void withdraw(Scanner input) {
        Account account = findAccount(input, "Account number: ");
        if (account == null) return;
        System.out.print("Amount: ");
        long amount = Long.parseLong(input.nextLine().trim());
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Balance: Rs. " + account.getBalance());
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void transfer(Scanner input) {
        Account source = findAccount(input, "From account: ");
        if (source == null) return;
        Account target = findAccount(input, "To account: ");
        if (target == null) return;
        if (source.equals(target)) {
            System.out.println("Source and destination accounts must be different.");
            return;
        }
        System.out.print("Amount: ");
        long amount = Long.parseLong(input.nextLine().trim());
        if (source.canWithdraw(amount)) {
            if (source.withdraw(amount) && target.deposit(amount)) {
                System.out.println("Transfer successful.");
                System.out.println("Source balance: Rs. " + source.getBalance());
                System.out.println("Destination balance: Rs. " + target.getBalance());
            } else {
                System.out.println("Transfer could not be completed.");
            }
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private static void statement(Scanner input) {
        Account account = findAccount(input, "Account number: ");
        if (account != null) {
            System.out.println(StatementFormatter.buildStatement(account));
        }
    }

    private static Account findAccount(Scanner input, String prompt) {
        System.out.print(prompt);
        String number = input.nextLine().trim();
        for (Account account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(number)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }
}
