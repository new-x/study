package ru.job4j.tracker.start;

/**
 * Class BaseAction.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public abstract class BaseAction implements UserAction {
    private final String name;
    private final int key;
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public int key() {
        return this.key;
    }

    public String info() {
        return String.format("%s %s", this.key, this.name);
    }

}

