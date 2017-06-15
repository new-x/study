package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Task;

/**
 * Class Tracker.
 * @author alekseev
 * @since 1.0
 */
public class StartUI {
    private Input input;
    private String name;
    private String desc;
    private boolean quest = true;

    public StartUI(Input input) {
        this.input = input;
    }

    public void menu() {
        while(this.quest) {
        Tracker tracker = new Tracker();
        String number = input.ask("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n" + "Select: ");
        int num = Integer.parseInt(number);
        if (num < 7) {
            if (num == 0) {
                this.name = input.ask("Enter a name please ");
                this.desc = input.ask("Enter a desc please ");
                tracker.add(new Task(this.name, this.desc));
            }
            if (num == 1) {
                for (Item item : tracker.getAll()) {
                    System.out.print(item.getName() + " " + item.getDescription());
                }
            }
            if (num == 5) {
                this.name = input.ask("Enter a name find item please ");
                tracker.findByName(this.name);
            }
            if (num == 6) {
                System.out.print("Close programm");
                this.quest = false;
            }
        }
    }

    }

    public void init() {
        //ConsoleInput input = new ConsoleInput();
        //Tracker tracker = new Tracker();

        //for (Item item : tracker.getAll()) {
        //  System.out.print(item.getName() + " " + item.getDescription());
        //}
    }

    public static void main(String[] args) {
        //this.question = false;
        //new StartUI(new StubInput(new String[] {"Create stub task"})).init();
        Input input = new ConsoleInput();
        new StartUI(input).menu();
    }
}
