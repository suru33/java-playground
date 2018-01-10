package com.suru.threadbasics;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong {

    public static void main(String[] args) {
        new PingPong().doWork();
    }

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ping();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pong();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

    Lock lock = new ReentrantLock();
    Condition pingCondition = lock.newCondition();
    Condition pongCondition = lock.newCondition();

    private void ping() throws InterruptedException {
        while (true) {
            lock.lock();
            pongCondition.signal();
            try {
                System.out.println("Ping");
                Thread.sleep(500);
            } finally {
                pingCondition.await();
                lock.unlock();
            }
        }
    }

    private void pong() throws InterruptedException {
        while (true) {
            lock.lock();
            pingCondition.signal();
            try {
                System.out.println("Pong");
                Thread.sleep(500);
            } finally {
                pongCondition.await();
                lock.unlock();
            }
        }
    }


}
