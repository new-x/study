package ru.job4j.tracker.start;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class ConsoleInput implements Input {
    /**
     * Scanner - accepts the print.
     */

    private Scanner scanner = new Scanner(System.in);
    /**
     *  Method ask - accepts the parameter and print.
     *  @param question - value.
     *  @return введенное значение.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

}
