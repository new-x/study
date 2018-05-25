package ru.job4j.Threads;

import javafx.concurrent.Task;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 25.05.2018 15:14
 */

public class NonBlockingCacheTest {
    private Thread[] allThreads = new Thread[10];
    private NonBlockingCache cache = new NonBlockingCache();
    @Test
    public void testThread() throws InterruptedException {
        for (int key = 0; key < 20; key++) {
            cache.add(key, new Base("Task" + key, 0));
        }
        for (int index = 0; index < 10; index++) {
            this.allThreads[index] = new Thread(() -> {
                    cache.update(5, "newTask");
            });
            this.allThreads[index].start();
        }

        for (Thread thread : this.allThreads) {
            thread.join();
        }
    }

}
