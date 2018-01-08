package com.suru.threadbasics;

import java.util.Scanner;

public class WaitNotify {
    public static void main(String[] args) {
        new WaitNotify().doWork();
    }

    class Processor {
        public void producer() throws InterruptedException {
            synchronized (Processor.this) {
                System.out.println("start producer");
                wait();
                System.out.println("resumed producer");
                System.out.println("end producer");
            }
        }

        public void consumer() throws InterruptedException {
            synchronized (Processor.this) {
                Scanner scanner = new Scanner(System.in);

                Thread.sleep(2000);
                System.out.println("start consumer");
                System.out.println("press return to release wait() in producer()");
                scanner.nextLine();
                System.out.println("return pressed and notify() for producer()");
                notify();
                System.out.println("notify() called but waiting 5000 millis in consumer()");
                Thread.sleep(5000);
                System.out.println("lock completely released in consumer()");
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

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all done!!");
    }
}

/*
-- output--

start producer
start consumer
press return to release wait() in producer()

return pressed and notify() for producer()
notify() called but waiting 5000 millis in consumer()
lock completely released in consumer()
resumed producer
end producer
all done!!
* */