package ru.job4j.tracker.models;

/**
 * Class Task.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Task extends Item {
    /**
     * Method Task.
     *
     * @param name - name for Item.
     * @param description - description for Item.
     */

    public Task(String name, String description) {
        setName(name);
        setDescription(description);
    }
}
