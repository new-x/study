package ru.job4j.Threads;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 23.05.2018 19:35
 */

public class NonBlockingCache {
    private ConcurrentHashMap<Integer,Base> cache = new ConcurrentHashMap();

    public void add(int key, Base model) {
        cache.putIfAbsent(key, model);
    }

    public void update(int key, String newName) {
        Base oldModel = cache.get(key);
                cache.computeIfPresent(key, (k, v) -> {
                    if (oldModel.equals(cache.get(key))){
                        return new Base(newName, 1 + oldModel.getVersion());
                    } else {
                        throw new OptimisticException("Error, this Base is modification.");
                    }
                });
                System.out.println(cache.get(key));
    }

    public void delete(Base model) {
    }

    private class OptimisticException extends RuntimeException {
        public OptimisticException(String message) {
            super(message);
        }
    }
}
