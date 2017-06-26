package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Task;

/**
 * Class Tracker.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class StartUI {
    /**
     * Входящее значение.
     */
    private Input input;
    /**
     * Имя Item.
     */
    private String name;
    /**
     * Описание Item.
     */
    private String desc;
    /**
     * Айди Item.
     */
    private String id;
    /**
     * Параметр выхода из программы true - программа работает, false отключается.
     */
    private boolean quest = true;
    /**
     * Пункт меню добавление Item.
     */
    private static final int ADDITEM = 0;
    /**
     * Пункт меню просмотр всех Item.
     */
    private static final int SHOWALLITEM = 1;
    /**
     * Пункт пеню изменения параметров Item.
     */
    private static final int EDITITEM = 2;
    /**
     * Пункт меню удаление Item.
     */
    private static final int DELETEITEM = 3;
    /**
     * Пункт меню поиск Item по ID.
     */
    private static final int FINDBYID = 4;
    /**
     * Пункт меню поиск Item по Name.
     */
    private static final int FINDBYNAME = 5;
    /**
     * Пункт меню выхода из программы.
     */
    private static final int EXIT = 6;
    /**
     * Создаем объект tracker, класса трекер.
     */
    private Tracker tracker = new Tracker();

    /**
     * @param input возращаем введенное значение с клавиатуры.
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Меню программы.
     */
    public void menu() {
        while (this.quest) {
            String number = input.ask("0. Add new Item\n" + "1. Show all items\n" + "2. Edit item\n" + "3. Delete item\n" + "4. Find item by Id\n" + "5. Find items by Name\n" + "6. Exit Program\n" + "Select: ");
            int num = Integer.parseInt(number);
            if (num < 7) {
                if (num == ADDITEM) {
                    this.name = input.ask("Enter a name please: ");
                    this.desc = input.ask("Enter a desc please: ");
                    tracker.add(new Task(this.name, this.desc));
                }
                if (num == SHOWALLITEM) {
                    for (Item item : tracker.getAll()) {
                        System.out.println("ID: " + item.getId() + " " + "Имя: " + item.getName() + " " + "Описание: " + item.getDescription());
                    }
                }
                if (num == EDITITEM) {
                    this.id = input.ask("Enter a id update item please: ");
                    this.name = input.ask("Enter a new name please: ");
                    this.desc = input.ask("Enter a new desc please: ");
                    Task itemNew = new Task(this.name, this.desc);
                    itemNew.setId(this.id);
                    tracker.update(itemNew);
                }
                if (num == DELETEITEM) {
                    this.id = input.ask("Enter a ID please: ");
                    tracker.delete(tracker.findById(this.id));
                }
                if (num == FINDBYID) {
                    this.id = input.ask("Enter a id find item please: ");
                    Item itemId = tracker.findById(this.id);
                    System.out.println("Имя: " + itemId.getName() + " " + "Описание: " + itemId.getDescription());
                }
                if (num == FINDBYNAME) {
                    this.name = input.ask("Enter a name find item please: ");
                    Item[] itemName = tracker.findByName(this.name);
                    System.out.println("Имя: " + itemName[0].getName() + " " + "Описание: " + itemName[0].getDescription());
                }
                if (num == EXIT) {
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

    /**
     * @param args возвращаем аргумент.
     */
    public static void main(String[] args) {
        //this.question = false;
        //new StartUI(new StubInput(new String[] {"Create stub task"})).init();
        Input input = new ConsoleInput();
        new StartUI(input).menu();
    }
}
