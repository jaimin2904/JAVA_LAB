package com.minibank.util;
import com.minibank.model.Command;
import com.minibank.model.TransactionType;
public class CommandParser {
    public static Command parse(String line) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length != 3) throw new IllegalArgumentException("Use: TYPE ACCOUNT_NUMBER AMOUNT");
        return new Command(TransactionType.valueOf(parts[0].toUpperCase()), parts[1], Long.parseLong(parts[2]));
    }
}
