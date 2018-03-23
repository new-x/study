package ru.job4j.Threads;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 21.03.2018 23:06
 */


public class UserStorageTest {
    @Test
    public void whenAddDeleteUpdateObjectTrue() {
        final UserStorage<User> storage = new UserStorage();
        User user1 = new User(8, 10);
        User user2 = new User(16, 10);
        User user3 = new User(24, 10);
        User user4 = new User(32, 20);
        Thread threadOne = new addUsers(storage);
        Thread threadTwo = new addUsers(storage);
        Thread threadThree = new addUsers(storage);
        Thread threadFour = new addUsers(storage);
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
            threadFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storage.update(user4);
        storage.delete(user1);
        storage.transfer(32, 24, 10);
        User result = storage.userStorage.get(1);
        assertThat(storage.userStorage.get(0), is(user2));
        assertThat(storage.userStorage.get(1), is(user3));
        assertThat(storage.userStorage.get(2), is(user4));
        assertThat(result.amount, is(20));
    }


    public static final class addUsers extends Thread {
        private final UserStorage<User> storage;

        public addUsers(UserStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int index = 0; index < 4; index++) {
                storage.add(new User(storage.genId(), 10));
            }
        }
    }
}
