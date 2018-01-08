package com.suru.threadbasics;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedThreads {

    private int count = 0;
    // thread safe primitive data types implementations
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        new SynchronizedThreads().doWork();
    }

    private synchronized void increment() {
        count++;
    }

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
//                    count++;
                    increment();
                    atomicInteger.incrementAndGet();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
//                    count++;
                    increment();
                    atomicInteger.incrementAndGet();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count: " + count);
        System.out.println("atomicInteger: " + atomicInteger.get());

    }

}
