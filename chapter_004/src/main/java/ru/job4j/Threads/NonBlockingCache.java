package ru.job4j.Threads;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 23.05.2018 19:35
 */

public class NonBlockingCache {
    private ConcurrentHashMap<Integer,Base> cache = new ConcurrentHashMap();
    private int key = 0;

    public void add(Base model) {
        cache.putIfAbsent(++key, model);
    }

    public void update(Base model) {
        Base oldModel = model;
        int baseKey = findByValue(model);
                cache.computeIfPresent(baseKey, (k, v) -> {
                    if (oldModel.equals(cache.get(baseKey))){
                        return new Base("new" + model.getName(), 1 + model.getVersion());
                    } else {
                        throw new OptimisticException("Error, this Base is modification.");
                    }
                });
        System.out.println(cache.get(baseKey));
    }

    public int findByValue(Base model) {
        for (Map.Entry<Integer, Base> map : cache.entrySet()) {
            if (map.getValue().equals(model)) {
                return map.getKey();
            }
        }
        throw new NoSuchElementException("Not found element");
    }

    public void delete(Base model) {
        cache.remove(findByValue(model));
    }


    private class OptimisticException extends RuntimeException {
        public OptimisticException(String message) {
            super(message);
        }
    }
}
