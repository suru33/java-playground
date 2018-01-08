package com.suru.threadbasics;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyExample {
    public static void main(String[] args) {
        new WaitNotifyExample().doWork();
    }

    class Processor {
        private List<Integer> list = new ArrayList<Integer>();
        private static final int LIMIT = 10;
        private final Object lock = new Object();

        public void producer() throws InterruptedException {
            int listValue = 0;

            synchronized (lock) {
                while (true) {
                    while (list.size() == LIMIT) {
                        lock.wait();
                    }
                    list.add(listValue++);
                    lock.notify();
                }
            }
        }

        public void consumer() throws InterruptedException {
            Thread.sleep(2000);
            synchronized (lock) {
                while (true) {
                    while (list.isEmpty()) {
                        lock.wait();
                    }
                    Integer remove = list.remove(0);
                    System.out.println("list size: " + list.size() + "; value: " + remove);
                    lock.notify();
                    Thread.sleep(100);
                }
            }
        }
    }

    private Processor processor = new Processor();

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}

/*
-- output --
list size: 9; value: 0
list size: 8; value: 1
list size: 7; value: 2
list size: 6; value: 3
list size: 5; value: 4
list size: 4; value: 5
list size: 3; value: 6
list size: 2; value: 7
list size: 1; value: 8
list size: 0; value: 9
list size: 9; value: 10
list size: 8; value: 11
 */