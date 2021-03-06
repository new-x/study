package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 08.04.2018 20:49
 */
@ThreadSafe
public class ThreadPool {

    private static final int COUNT_CORES = Runtime.getRuntime().availableProcessors();
    private static final int TASK_LIMIT = 10;
    @GuardedBy("this")
    private volatile Queue<Work> taskQueue = new LinkedList<>();
    private Thread[] allThreads;
    private volatile boolean check = false;

    public void stratThreads() {
        this.allThreads = new Thread[COUNT_CORES];
        for (int index = 0; index < TASK_LIMIT; index++) {
            add(new Work());
        }
        for (int index = 0; index < COUNT_CORES; index++) {
            this.allThreads[index] = new Thread(() -> {
                while (!Thread.interrupted()) {
                    addWork();
                }
            });
            this.allThreads[index].start();
        }
    }

    public synchronized void addWork() {
        if (!this.taskQueue.isEmpty()) {
            if (this.taskQueue.peek() != null) {
                this.taskQueue.poll().work();
            }
        } else {
            check = true;
        }

    }

    public void shutdown() {
        while (true) {
                if (check) {
                    for (Thread thread : allThreads) {
                        thread.interrupt();
                    }
                    break;
                }
        }
    }

    public void add(Work work) {
        this.taskQueue.offer(work);
    }

    public static class Work {
        public void work() {
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}


