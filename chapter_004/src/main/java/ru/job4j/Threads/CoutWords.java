package ru.job4j.Threads;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 17.03.2018 22:16
 */

public class CoutWords {

    public static final class Splitter implements Runnable {
        private int index;
        private String line = "Это короткая строка для тестирования";

        public Splitter(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            if (index == 0) {
                int count = line.split(" ").length;
                System.out.println(count);
            } else if (index == 1) {
                for(String word : line.split("\\s")){
                    System.out.println(word);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Splitter(0)).start();
        new Thread(new Splitter(1)).start();
    }
}
