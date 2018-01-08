package com.suru.threadbasics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocks {
    public static void main(String[] args) {
        new MultipleLocks().doWork();
    }

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();
    private final Random random = new Random();

    /*
    Only one implicit lock object is available for each class.
    Thread need to acquire lock though two or more methods are independent.
    To avoid this we use synchronized blocks with multiple lock objects.

        private synchronized void stageOne() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt());
        }

        private synchronized void stageTwo() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt());
        }
    */

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt());
        }
    }

    private void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt());
        }
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    private void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        thread2.start();

        long start = System.currentTimeMillis();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("list 1 size: " + list1.size());
        System.out.println("list 2 size: " + list2.size());
        System.out.println("time: " + (end - start));

    }
}
