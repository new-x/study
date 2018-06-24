package ru.job4j.GuaranteedDeadline;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.GuaranteedDeadline
 * Create data: 24.06.2018 13:04
 */

public class Worker {
    private ReentrantLock lockOne = new ReentrantLock(true);
    private ReentrantLock lockTwo = new ReentrantLock(true);
    private Object one;
    private Object two;

    public Worker(Object one, Object two) {
        this.one = one;
        this.two = two;
    }
    public void methodA() {
        lockOne.lock();
        lockTwo.lock();
        one = "One";
        System.out.println(one);
        lockTwo.lock();
        lockOne.unlock();

    }

    public void methodB() {
        lockOne.lock();
        lockTwo.lock();
        two = "two";
        System.out.println(two);
        lockTwo.unlock();
        lockOne.unlock();

    }

}
