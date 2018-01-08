package com.suru.threadbasics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountdownLatchesExample {
    public static void main(String[] args) {
        new CountdownLatchesExample().doWork();
    }

    class MyProcess implements Runnable {

        private CountDownLatch latch;
        private int id;

        public MyProcess(CountDownLatch latch, int id) {
            this.latch = latch;
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("starting " + id);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println("completed: " + id);
            latch.countDown();
        }
    }

    private void doWork() {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 3; i++) {
            executorService.submit(new MyProcess(latch, i));
        }
        try {
            latch.await(10, TimeUnit.MINUTES);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("everything is done!");
    }
}
