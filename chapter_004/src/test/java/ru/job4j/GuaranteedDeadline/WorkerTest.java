package ru.job4j.GuaranteedDeadline;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.GuaranteedDeadline
 * Create data: 24.06.2018 13:19
 */

public class WorkerTest {
    @Test
    public void whenRunWorkerIsDeadlock() {
        CyclicBarrier barrier = new CyclicBarrier(2);
        Worker workerOne = new Worker(barrier);
        Worker workerTwo = new Worker(barrier);

        workerOne.initWorker(workerTwo);
        workerTwo.initWorker(workerOne);

        Thread one = new Thread(workerOne);
        Thread two = new Thread(workerTwo);
        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
