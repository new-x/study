package ru.job4j.Threads;

import org.junit.Test;
import ru.job4j.Threads.ThreadPool.Work;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 29.04.2018 21:24
 */

public class ThreadPoolTest {

    @Test
    public void whenAllThreadsWork() throws InterruptedException {
        ThreadPool th = new ThreadPool();
        th.stratThreads();
        th.shutdown();

    }
}
