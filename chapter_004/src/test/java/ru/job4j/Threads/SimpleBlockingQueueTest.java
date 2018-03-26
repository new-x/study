package ru.job4j.Threads;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 26.03.2018 18:21
 */
public class SimpleBlockingQueueTest {
    @Test
    public void whenAddObjectToQueueTrue() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread produser = new Produser(queue);
        Thread consumer = new Consumer(queue);
        consumer.start();
        produser.start();
        produser.join();
        consumer.join();

    }
    public class Produser extends Thread {
        SimpleBlockingQueue<Integer> queue;

        public Produser(SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                this.queue.offer(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Consumer extends Thread {
        SimpleBlockingQueue<Integer> queue;

        public Consumer(SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                this.queue.peek();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
