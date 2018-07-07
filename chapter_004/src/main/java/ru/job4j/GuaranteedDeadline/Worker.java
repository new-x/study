package ru.job4j.GuaranteedDeadline;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.GuaranteedDeadline
 * Create data: 24.06.2018 13:04
 */

public class Worker implements Runnable {
    private Worker block;

    private final CyclicBarrier barrier;

    public Worker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void initWorker(Worker block) {
        this.block = block;
    }

    private synchronized void lock() {
        System.out.println("Not print.");
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(String.format("%s захватил монитор", Thread.currentThread().getName()));
            try {
                this.barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Lock.");
            this.block.lock();
        }
    }
}
