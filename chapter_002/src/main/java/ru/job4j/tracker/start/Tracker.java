package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.Arrays;
import java.util.Random;

/**
 * Class Tracker.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class Tracker {
    /** Иницилизация массива Item размером 10. */
    private Item[] items = new Item[10];
    /** Позиция Item. */
    private int position = 0;
    /** Генерация случайного числа. */
    private static final Random RN = new Random();

    /**
     * Метод add  добавление заявок в трекер.
     *
     * @param item - объект item.
     * @return возвращаем item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод delete  удаляет объект из массива и обрезает его.
     *
     * @param item - объект item.
     */

    public void delete(Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                this.position = this.position - 1;
                break;
            }
        }
    }

    /**
     * Метод update  обновляет объект из массива.
     *
     * @param item - объект item.
     */
    public void update(Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = item;
                break;
            }
        }
    }

    /**
     * Метод findByName  ищет заявку по имени.
     *
     * @param key - название.
     * @return возвращаем обрезанный архив result.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[count] = this.items[index];
                count++;
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }

    /**
     * Метод findById ищем заявку по ID.
     *
     * @param id передаем ID заявки.
     * @return возвращаем result - найденную заявку.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @return возрвращаем сгенерированный ID с помощью метода Random.
     */

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод getAll возвращаем копию массива без null.
     *
     * @return возвращаем result.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}
