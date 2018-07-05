package ru.job4j.tracker.models;

import java.sql.Timestamp;

/**
 * Class Item.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class Item {
    /** ID for Item.*/
    private String id;
    /** Name for Item.*/
    private String name;
    /** Description for Item.*/
    private String description;
    /** Data create for Item.*/
    private Timestamp create_date; // data create for Item

    /**
     * Перекрыте конструктора.
     */
    public Item() {

    }

    /**
     *
     * @param name передаем параметр в конструктор.
     * @param description передаем описание в конструктор.
     * @param create_date передаем дату создания в конструтор.
     */
    public Item(String id, String name, String description, Timestamp create_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.create_date = create_date;
    }
    /**
     * Получаем значение id.
     * @return возвращаем значенеи id.
     */
    public String getId() {
        return this.id;
    }
    /**
     * Устанавливаем значение id.
     * @param id паредаем параметр id, а затем его возвращаем.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Передаем значение name.
     * @return Возвращаем значение name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Устанавливаем значение name.
     * @param name передаем пареметр name, а затем возвращаем его.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Передаем значение description.
     * @return Возвращаем значение description.
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Устанавливаем значение Name.
     * @param description передаем пареметр Descripton, а затем возвращаем его.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Устанавливаем значение create_date.
     * @param create_date устанвливаем дату создания Item.
     */
    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }
    /**
     * Получаем значение create_date.
     * @return получаем дату создания Item.
     */
    public Timestamp getCreate_date() {
        return create_date;
    }


}
