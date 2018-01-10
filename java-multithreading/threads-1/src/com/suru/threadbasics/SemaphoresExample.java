package com.suru.threadbasics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoresExample {
    public static void main(String[] args) {
        Connection connection = Connection.getInstance();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.connect();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Connection {
    private static final Connection CONNECTION = new Connection();
    private int count = 0;

    Semaphore semaphore = new Semaphore(10, true);

    private Connection() {
    }

    public static Connection getInstance() {
        return CONNECTION;
    }

    public void connect() throws InterruptedException {
        semaphore.acquire();
        try {
            doConnect();
        } finally {

            semaphore.release();
        }
    }

    public void doConnect() throws InterruptedException {
        synchronized (this) {
            count++;
            System.out.println("count: " + count);
        }

        Thread.sleep(1000);

        synchronized (this) {
            count--;
        }
    }

}
