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
     * Method ask - accepts the parameter and print.
     *
     * @param question - value.
     * @return введенное значение.
     */
    public String ask(String question) {
        System.out.print(question);
        String answer = scanner.nextLine();
        return answer;
    }

    public int ask(String qustion, int[] ranges) {
        int key = Integer.valueOf(ask(qustion));
        boolean exist = false;
        for (int value : ranges) {
            if (value == key) {
                exist = true;
                break;
            }

        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutExeption("Out of menu range.");
        }
    }

}
