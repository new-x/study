package ru.job4j.tracker.start;
import ru.job4j.tracker.models.*;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Class Tracker.
 * @author alekseev
 * @since 1.0
 */

public class Tracker {

    private  Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Метод add  добавление заявок в трекер.
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
     * @param item - объект item.
     * @return возвращаем item.
     */
    public void delete (Item item) {
        for(int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                break;
                //this.items[this.items.length - 1] = null;
            }
        }
    }
    /**
     * Метод update  обновляет объект из массива.
     * @param item - объект item.
     */
    public void update (Item item) {
        for(int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())){
                this.items[index] = item;
                break;
            }
        }
    }
    /**
     * Метод findByName  ищет заявку по имени.
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
     * @param id передаем ID заявки.
     * @return возвращаем result - найденную заявку.
     */
    protected Item findById (String id) {
        Item result = null;
        for (Item item : items) {
            if(item != null && item.getId().equals(id))
                result = item;
            break;
        }
        return result;
    }
    String generateId () {
       return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод getAll возвращаем копию массива без null.
     * @return возвращаем result.
     */
    public Item[] getAll () {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}
