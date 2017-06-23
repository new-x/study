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
    private String id;
    private boolean quest = true;
    Tracker tracker = new Tracker();

    public StartUI(Input input) {
        this.input = input;
    }

    public void menu() {
        while(this.quest) {
        String number = input.ask("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by Name\n" +
                "6. Exit Program\n" + "Select: ");
        int num = Integer.parseInt(number);
        if (num < 7) {
            if (num == 0) {
                this.name = input.ask("Enter a name please: ");
                this.desc = input.ask("Enter a desc please: ");
                tracker.add(new Task(this.name, this.desc));
            }
            if (num == 1) {
                for (Item item : tracker.getAll()) {
                    System.out.println("ID: " + item.getId() + " "
                            + "Имя: " + item.getName() + " "
                            + "Описание: " + item.getDescription());
                }
            }
            if (num == 2) {
            //Item itemEdit[] = tracker.update(tracker.findById(this.id));w
            }
            if (num == 3) {
                this.id = input.ask("Enter a ID please: ");
                tracker.delete(tracker.findById(this.id));
            }
            if (num == 4) {
                this.id = input.ask("Enter a id find item please: ");
                Item itemId = tracker.findById(this.id);
                System.out.println(itemId.getName() + " " + itemId.getDescription());
            }
            if (num == 5) {
                this.name = input.ask("Enter a name find item please: ");
                Item itemName[] = tracker.findByName(this.name);
                System.out.println(itemName[0].getName() + " " + itemName[0].getDescription());
            }
            if (num == 6) {
                System.out.print("Close programm.");
                this.quest = false;
            }
        }
    }

    }

    //public void init() {
        //ConsoleInput input = new ConsoleInput();
        //Tracker tracker = new Tracker();

        //for (Item item : tracker.getAll()) {
        //  System.out.print(item.getName() + " " + item.getDescription());
        //}
    //}

    public static void main(String[] args) {
        //this.question = false;
        //new StartUI(new StubInput(new String[] {"Create stub task"})).init();
        Input input = new ConsoleInput();
        new StartUI(input).menu();
    }
}
