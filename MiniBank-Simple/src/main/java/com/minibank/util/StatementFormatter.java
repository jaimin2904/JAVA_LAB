package com.minibank.util;
import com.minibank.model.Account;
public class StatementFormatter {
    public static String buildStatement(Account account) {
        StringBuilder text = new StringBuilder();
        text.append("MINIBANK STATEMENT\n");
        text.append("Account: ").append(account.getAccountNumber()).append("\n");
        text.append("Owner: ").append(account.getOwnerName()).append("\n");
        text.append("Balance: Rs. ").append(account.getBalance());
        return text.toString();
    }
}
