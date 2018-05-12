package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 08.04.2018 20:49
 */

public class ThreadPool {

    private static final int COUNT_CORES = Runtime.getRuntime().availableProcessors();
    private static final int TASK_LIMIT = 10;
    @GuardedBy("this")
    private Queue<Work> taskQueue = new LinkedList<>();
    private Thread[] allThreads;
    private boolean check = true;

    public void stratThreads() {
        this.allThreads = new Thread[COUNT_CORES];
        for (int index = 0; index < TASK_LIMIT; index++) {
            add(new Work());
        }
        for (int index = 0; index < COUNT_CORES; index++) {
            synchronized (this) {
                this.allThreads[index] = new Thread(() -> {
                    while (check) {
                        if (!this.taskQueue.isEmpty()) {
                            Work work = this.taskQueue.poll();
                            if (work != null) {
                                work.work();
                            }
                        } else {
                            this.check = false;
                        }
                    }
                }
                );
            }
            this.allThreads[index].start();
        }
    }

    public void waitThreads() {
        for (Thread thread : allThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Work work) {
        synchronized (this) {
            this.taskQueue.offer(work);
        }
    }

    public static class Work {
        public void work() {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}


