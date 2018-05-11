package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 11.05.2018 16:40
 */
@ThreadSafe
public class LockUnlock {
    @GuardedBy("this")
    Thread lock;

    public synchronized void lock() {
        while (this.lock != null && !Thread.currentThread().equals(this.lock)) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        this.lock = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (this.lock != null && this.lock.equals(Thread.currentThread())) {
            this.lock = null;
            this.notify();
        }
    }
}
