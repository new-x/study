package ru.job4j.Threads;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 23.05.2018 19:35
 */

public class NonBlockingCache {
    private ConcurrentHashMap cache = new ConcurrentHashMap();

    public void add(int key, Base model) {
        cache.putIfAbsent(key, model);
    }

    public void update(int key, String newName) {
        Base oldModel = (Base) cache.get(key);
            if (oldModel.equals(cache.get(key))) {
                cache.replace(key, oldModel, new Base(newName, 1 + oldModel.getVersion()));
                System.out.println(cache.get(key));
            } else {
                throw new OptimisticException("Error.");
            }
    }

    public void delete(Base model) {
    }

    private class OptimisticException extends RuntimeException {
        public OptimisticException(String message) {
            super(message);
        }
    }
}
