package ru.job4j.Threads;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 11.05.2018 16:45
 */

public class LockUnlockTest {

    @Ignore
    @Test
    public void whenLock() {
        LockUnlock lockUnlock = new LockUnlock();
        Thread first = new Thread(()-> {
            lockUnlock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockUnlock.unlock();
        });
        Thread second = new Thread(()-> {
            lockUnlock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockUnlock.unlock();
        });
        second.start();
        first.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
