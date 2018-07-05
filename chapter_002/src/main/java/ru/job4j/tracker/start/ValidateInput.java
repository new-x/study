package ru.job4j.tracker.start;

/**
 * Class ValidateInput.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String qustion, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(qustion, range);
                invalid = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Please select key for menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a validate number.");
            }
        } while (invalid);
        return value;
    }
}
