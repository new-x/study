package ru.job4j.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 08.04.2018 20:49
 */

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ThreadPool pool = new ThreadPool();
        for (int index = 0; index < 12; index++) {
            threadPool.submit(new Work());
        }
        threadPool.shutdown();
    }
}

