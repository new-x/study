package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Task;


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
    private UserAction[] actions = new UserAction[7];

    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[position++] = new AddItem();
        this.actions[position++] = new ShowItem();
        this.actions[position++] = new EditItem();
        this.actions[position++] = new DeleteItem();
        this.actions[position++] = new FindById();
        this.actions[position++] = new FindByName();
    }

    public void addActions(UserAction action) {
        this.actions[position++] = action;

    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }

    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please eneter a task name: ");
            String desc = input.ask("Please eneter a desc name: ");
            tracker.add(new Task(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new Item");
        }
    }

    private static class ShowItem implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s %s %s", item.getId(), item.getName(), item.getDescription()));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items: ");
        }
    }

    private static class FindById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter item ID: ");
            System.out.println(String.format("%s %s %s", tracker.findById(id).getId(), tracker.findById(id).getName(), tracker.findById(id).getDescription()));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find Item by ID: ");
        }
    }

    private class FindByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please eneter a task name: ");
            Item[] itemName = tracker.findByName(name);
            //System.out.println(tracker.findByName(name));
            System.out.println(String.format("%s %s %s", itemName[0].getId(), itemName[0].getName(), itemName[0].getDescription()));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find Item by name: ");
        }
    }
}

class EditItem implements UserAction {
    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please eneter a item ID: ");
        String name = input.ask("Please eneter a new task name: ");
        String desc = input.ask("Please eneter a new desc name: ");
        Task task = new Task(name, desc);
        task.setId(id);
        tracker.update(task);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit Item");
    }
}

class DeleteItem implements UserAction {
    public int key() {
        return 3;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter a item ID: ");
        tracker.delete(tracker.findById(id));
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Delete Item");
    }
}
