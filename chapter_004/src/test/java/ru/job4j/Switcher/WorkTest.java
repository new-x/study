package ru.job4j.Switcher;

import org.junit.Test;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Switcher
 * Create data: 23.06.2018 14:53
 */

public class WorkTest {

    @Test
    public void testWorker() throws InterruptedException {
        Switcher switcher = new Switcher();
        Thread workOne = new Thread(new Work(1, switcher));
        Thread workTwo = new Thread(new Work(2, switcher));
        workOne.start();
        workTwo.start();
        workTwo.join();
    }
}
