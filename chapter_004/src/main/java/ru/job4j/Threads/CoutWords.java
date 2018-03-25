package ru.job4j.Threads;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 17.03.2018 22:16
 */

public class CoutWords {

    public static final class CountLine implements Runnable {
        private String line = "Это короткая строка для тестирования";

        @Override
        public void run() {
            int countLine = 0;
            for (char symbol : line.toCharArray()) {
                if (symbol == ' ') {
                    countLine++;
                }
            }
            System.out.println(countLine);
        }
    }

    public static final class CountWords implements Runnable {
        private String line = "Это короткая строка для тестирования";

        @Override
        public void run() {
            int countLine = 0;
            for (char symbol : line.toCharArray()) {
                if (symbol == ' ') {
                    countLine++;
                }
            }
            System.out.println(countLine + 1);
        }
    }


    public static void main(String[] args)  {
        Thread threadOne = new Thread(new CountLine());
        Thread threadTwo = new Thread(new CountWords());
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
            System.out.println("All thread's stop.");
        } catch (InterruptedException e) {
            System.out.println("General thread stop.");
        }
    }
}
