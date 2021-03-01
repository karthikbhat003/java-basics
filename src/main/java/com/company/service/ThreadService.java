package com.company.service;

public class ThreadService {
    private Integer count = 0;

    /**
     *
     */
    public void testSynchronisedBlock() {
        final Runnable t1 = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    executeTask();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        final Runnable t2 = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    executeTask();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(t1).start();
        new Thread(t2).start();
    }

    private void executeTask() throws InterruptedException {
        System.out.println("Thread sent request is: " + Thread.currentThread().getName());
        // acquires lock on whole block such that no read and write operations on this block happens by another thread
        synchronized (this) {
            int var = count;
            System.out.println("Value read is: " + count);
            Thread.sleep(50L);
            count = var + 1;
        }
        System.out.println("value of integer is: " + count);
    }
}
