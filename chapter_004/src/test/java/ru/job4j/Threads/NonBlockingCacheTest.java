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
    private Thread[] allThreads = new Thread[2];
    private NonBlockingCache cache = new NonBlockingCache();
    @Test
    public void testThread() throws InterruptedException {
        Base model = new Base("Task4", 0);
        for (int index = 0; index < 20; index++) {
            cache.add(new Base("Task" + index, 0));
        }
        for (int index = 0; index < allThreads.length; index++) {
            this.allThreads[index] = new Thread(() -> {
                    cache.update(model);
            });
            this.allThreads[index].start();
        }

        for (Thread thread : this.allThreads) {
            thread.join();
        }
    }

}
