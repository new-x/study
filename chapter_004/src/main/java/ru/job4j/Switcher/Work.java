package ru.job4j.Switcher;

import java.util.concurrent.Semaphore;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Switcher
 * Create data: 23.06.2018 14:42
 */

public class Work implements Runnable {
    private int number;
    private Switcher switcher;
    private static final Semaphore SEMAPHORE = new Semaphore(1, true);

    public Work(int number, Switcher switcher) {
        this.number = number;
        this.switcher = switcher;
    }
    @Override
    public void run() {
        while (true) {
            try {
                SEMAPHORE.acquire();
                for (int index = 0; index < 10; index++) {
                    switcher.intToString(number);
                    System.out.println(switcher.retrunString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                SEMAPHORE.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
