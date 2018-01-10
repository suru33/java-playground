package com.suru.threadbasics;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLocks {
    public static void main(String[] args) {
        new ReEntrantLocks().doWork();
    }

    private final Runner runner = new Runner();

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
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

        runner.showResults();

    }

    class Runner {
        private Lock lock;
        // condition is just like wait() and notify()
        private Condition condition;
        private int count;

        public Runner() {
            lock = new ReentrantLock();
            condition = lock.newCondition();
            count = 0;
        }

        private void increment() {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }

        // we have to use lock object in this way only
        // if any exceptions occur lock will never unlock

        public void firstThread() throws InterruptedException {
            lock.lock();
            try {
                increment();
            } finally {
                lock.unlock();
            }
        }

        public void secondThread() throws InterruptedException {
            Thread.sleep(1000);
            lock.lock();
            try {
                increment();
            } finally {
                lock.unlock();
            }
        }

        public void showResults() {
            System.out.println("count is: " + count);
        }

    }

}
