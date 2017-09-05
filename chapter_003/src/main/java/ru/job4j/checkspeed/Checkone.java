package ru.job4j.checkspeed;

import java.util.Collection;

/**
 * Created by aleks on 01.09.2017.
 */
public class Checkone {
    public long add(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int index = 0; index < amount; index++){
            collection.add(String.valueOf(Math.random() * 10000));
        }
        long finish = System.currentTimeMillis();
    return finish - start;

    }
    public long delete(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int index = 0; index < amount; index++){
            collection.remove(0);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

}
