package com.minibank.demo;
import java.util.LinkedList;
import java.util.Queue;
public class ProducerConsumerDemo {
    private final Queue<Integer> buffer = new LinkedList<>();
    public synchronized void produce(int value) throws InterruptedException { buffer.add(value); notifyAll(); }
    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) wait();
        return buffer.remove();
    }
    public static void main(String[] args) throws Exception {
        ProducerConsumerDemo demo = new ProducerConsumerDemo();
        Thread producer = new Thread(() -> { try { for (int i = 1; i <= 5; i++) demo.produce(i); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread consumer = new Thread(() -> { try { for (int i = 1; i <= 5; i++) System.out.println("Consumed: " + demo.consume()); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        producer.start(); consumer.start(); producer.join(); consumer.join();
    }
}
