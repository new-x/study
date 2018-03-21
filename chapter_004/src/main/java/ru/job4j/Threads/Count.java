package ru.job4j.Threads;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 21.03.2018 22:12
 */

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Count {
    @GuardedBy("this")
    private int value;

    public synchronized void increment() {
        this.value++;
    }

    public synchronized int get() {
        return this.value;
    }
}
