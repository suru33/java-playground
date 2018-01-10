package com.suru.threadbasics;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private int balance = 1000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public static void transfer(Account a1, Account a2, int amount) {
        a1.balance -= amount;
        a2.balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}

public class DeadLock {
    public static void main(String[] args) {
        new DeadLock().doWork();
    }

    Account account1 = new Account();
    Account account2 = new Account();

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock lock1, Lock lock2) {
        boolean firstLock = false;
        boolean secondLock = false;

        while (true) {
            try {
                firstLock = lock1.tryLock();
                secondLock = lock2.tryLock();
            } finally {
                if (firstLock && secondLock) {
                    return;
                }
                if (firstLock) {
                    lock1.unlock();
                }
                if (secondLock) {
                    lock2.unlock();
                }
            }
        }
    }

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1000; i++) {
//                    lock1.lock();
//                    lock2.lock();
                    acquireLocks(lock1, lock2);
                    try {
                        Account.transfer(account1, account2, random.nextInt(100));
                    } finally {
                        lock1.unlock();
                        lock2.unlock();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1000; i++) {
//                    lock2.lock();
//                    lock1.lock();
                    acquireLocks(lock1, lock2);
                    try {
                        Account.transfer(account2, account1, random.nextInt(100));
                    } finally {
                        lock1.unlock();
                        lock2.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("account 1: " + account1.getBalance());
            System.out.println("account 2: " + account2.getBalance());
            System.out.println("total: " + (account1.getBalance() + account2.getBalance()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
with out sync
account 1: 1203
account 2: 721
total: 1924
*/

/*
dead lock - if we try to use lock objects in different order
for example
for 1st thread
lock1.lock();
lock2.lock();

for 2nd thread
lock2.lock();
lock1.lock();

 */