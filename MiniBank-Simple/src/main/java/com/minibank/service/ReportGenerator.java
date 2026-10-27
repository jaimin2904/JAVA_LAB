package com.minibank.service;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
public class ReportGenerator {
    public static String create(Path folder, Path report) throws IOException {
        long deposits = 0, withdrawals = 0;
        StringBuilder result = new StringBuilder("MINIBANK REPORT\n");
        if (Files.exists(folder)) {
            try (DirectoryStream<Path> files = Files.newDirectoryStream(folder, "*.log")) {
                for (Path file : files) {
                    for (String line : Files.readAllLines(file)) {
                        if (line.startsWith("DEPOSIT ")) deposits += amount(line);
                        if (line.startsWith("WITHDRAW ")) withdrawals += amount(line);
                    }
                    BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
                    result.append(file.getFileName()).append(" size=").append(attr.size()).append(" bytes\n");
                }
            }
        }
        result.append("Total deposits: ").append(deposits).append("\nTotal withdrawals: ").append(withdrawals);
        Path parent = report.getParent();
        if (parent != null) Files.createDirectories(parent);
        Files.writeString(report, result.toString());
        return result.toString();
    }
    private static long amount(String line) {
        String[] parts = line.split(" ");
        try { return Long.parseLong(parts[parts.length - 1]); } catch (Exception e) { return 0; }
    }
}
