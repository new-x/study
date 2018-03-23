package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 21.03.2018 22:58
 */
@ThreadSafe
public class UserStorage<E extends User> {
    @GuardedBy("this")
    protected CopyOnWriteArrayList<E> userStorage = new CopyOnWriteArrayList();
    @GuardedBy("this")
    private int id = 0;

    public synchronized int genId() {
        return id+=8;
    }

    public synchronized boolean add(E user) {
        if (!user.equals(null) & !this.userStorage.contains(user)) {
            this.userStorage.add(user);
            return true;
        }
        return false;
    }

    public synchronized boolean update(E user) {
        for (User oneUser : this.userStorage) {
            if (oneUser.equals(user)) {
                oneUser.amount = user.amount;
                return true;
            }
        }
        return false;
    }

    public synchronized boolean delete(E user) {
        if (this.userStorage.contains(user)){
            this.userStorage.remove(user);
            return true;
        }
        return false;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        User userOne = findById(fromId);
        User userTwo = findById(toId);
        if (userOne.amount >= amount) {
            userTwo.amount += amount;
            userOne.amount -= amount;
            return true;
        } else {
            return false;
        }
    }

    public synchronized E findById(int id) {
        for (User user : this.userStorage) {
            if (user.id == id) {
                return (E) user;
            }
        }
        throw new NoSuchElementException();
    }
}
