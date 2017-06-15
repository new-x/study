package ru.job4j.tracker.start;

import java.util.Scanner;

/**
 * Class Tracker.
 * @author alekseev
 * @since 1.0
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

}
