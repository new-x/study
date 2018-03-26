package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 26.03.2018 18:06
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    private boolean check = true;
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
                if (this.queue.size() == 0) {
                    this.queue.add(value);
                }
                this.queue.notify();
        }
    }

    public T peek() throws InterruptedException {
        synchronized (this.queue) {
            while (check) {
                if (this.queue.size() == 0) {
                    this.queue.wait();
                } else if (this.queue.size() != 0) {
                    this.check = false;
                    return this.queue.peek();
                }
            }
        }
        return null;
    }
}
