package ru.job4j.Threads;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 20.03.2018 17:05
 */

public class StopThread {

    public static void main(String[] args) {
        new Thread(new Time()).start();
    }

    public static class CountChar implements Runnable {
        @Override
        public void run() {
            int countSymbols = 0;
            String symbols = "adopasjoalapwldavadlqedqlfafvlafqwdlasfcsaldasdlqwfdasflasdqwdlasdlawdqwldadlawdl";
            for (char element : symbols.toCharArray()) {
                if (!Thread.interrupted()) {
                    if (element == 'l') {
                        System.out.println(countSymbols++);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static class Time implements Runnable {
        @Override
        public void run() {
            Thread countChar = new Thread(new CountChar());
            countChar.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countChar.interrupt();
        }
    }
}

