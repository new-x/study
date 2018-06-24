package ru.job4j.GuaranteedDeadline;

import org.junit.Test;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.GuaranteedDeadline
 * Create data: 24.06.2018 13:19
 */

public class WorkerTest {
    @Test
    public void whenRunWorkerIsDeadlock() throws InterruptedException {
        Object one = new Object();
        Object two = new Object();
        Worker worker = new Worker(one, two);
        Thread[] threads = new Thread[10];
        for (int index = 0; index < threads.length; index++) {
            threads[index] = new Thread() {
                public void run() {
                    worker.methodA();
                    worker.methodB();
                }

            };
            threads[index].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
