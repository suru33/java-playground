package com.suru.threadbasics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools {

    public static void main(String[] args) {
        new ThreadPools().doWork();
    }

    class MyProcess implements Runnable {

        private int id;

        public MyProcess(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("starting: " + id);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("completed: " + id);
        }
    }

    private void doWork() {

        // number of concurrent threads
        // like workers in a factory shares the work to complete

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            executorService.submit(new MyProcess(i));
        }

        // it will execute after all tasks completed
        // for this example 5 threads
        executorService.shutdown();

        // if all tasks not completed in given time for this example 10 MIN
        // executorService terminates and throws an exception
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all tasks done!");
    }
}
