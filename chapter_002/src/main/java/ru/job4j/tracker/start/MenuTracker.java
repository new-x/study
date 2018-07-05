package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Task;

import java.util.ArrayList;
import java.util.List;


/**
 * Class MenuTracker.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class MenuTracker {
    /*
     * Объект input - вводимое значение с консоли.
     */
    private Input input;
    /*
     * Объект tracker - система заявок.
     */
    private Tracker tracker;
    /*
     * Массив данных actions.
     */
    private List<UserAction> actions = new ArrayList<>(7);

    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions.add(position++, new AddItem());
        this.actions.add(position++, new ShowItem());
        this.actions.add(position++, new EditItem());
        this.actions.add(position++, new DeleteItem());
        this.actions.add(position++, new FindById());
        this.actions.add(position++, new FindByName());
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }

    }

    private static class ShowItem extends BaseAction implements UserAction {
        public ShowItem() {
            super("Show all items", 1);
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s %s %s %s",
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getCreate_date()));
            }
        }
    }

    private static class FindById extends BaseAction implements UserAction {
        public FindById() {
            super("Find Item by ID", 4);
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter item ID: ");
            if (!(tracker.findById(id) == null)) {
                System.out.println(String.format("%s %s %s",
                        tracker.findById(id).getId(),
                        tracker.findById(id).getName(),
                        tracker.findById(id).getDescription()));
            } else {
                System.out.println("Object not found by this ID.");
            }
        }
    }

    private class AddItem extends BaseAction implements UserAction {
        public AddItem() {
            super("Add the new Item", 0);
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please eneter a task name: ");
            String desc = input.ask("Please eneter a desc name: ");
            tracker.add(new Task(name, desc));
        }
    }

    private class FindByName extends BaseAction implements UserAction {
        public FindByName() {
            super("Find Item by name", 5);
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please eneter a task name: ");
            List<Item> items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println(String.format("%s %s %s %s",
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getCreate_date()));
            }
        }
    }
}

class EditItem extends BaseAction implements UserAction {
    public EditItem() {
        super("Edit Item", 2);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please eneter a item ID: ");
        String name = input.ask("Please eneter a new task name: ");
        String desc = input.ask("Please eneter a new desc name: ");
        Task task = new Task(name, desc);
        task.setId(id);
        tracker.update(task);
    }

}

class DeleteItem extends BaseAction implements UserAction {
    public DeleteItem() {
        super("Delete Item", 3);
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter a item ID: ");
        tracker.delete(tracker.findById(id));
    }

}
