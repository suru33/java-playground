package com.suru.threadbasics;

public class ThreadJoinExample {

    private int count = 0;

    public static void main(String[] args) {
        ThreadJoinExample example = new ThreadJoinExample();
        example.doWork();
    }

    private void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
            }
        });

        thread1.start();
        thread2.start();


        // without this join() output is  count:0
        // with join() output is  count:2000
        // and some times output is < 2000

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("count: " + count);
    }

}

