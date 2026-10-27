package com.minibank.demo;
public class AutoCloseDemo implements AutoCloseable {
    public void close() { System.out.println("Resource closed"); }
    public static void main(String[] args) {
        try (AutoCloseDemo demo = new AutoCloseDemo()) { System.out.println("Using resource"); }
    }
}
