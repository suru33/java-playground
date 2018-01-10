package com.suru.threadbasics;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) {
        new CallableAndFuture().doWork();
    }

    private void doWork() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                System.out.println("starting thread");
                int randomTime = random.nextInt(2000);
                Thread.sleep(randomTime);
                System.out.println("finished thread");
                return randomTime;
            }
        });
        executorService.shutdown();
        try {
            System.out.println("Random time: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
