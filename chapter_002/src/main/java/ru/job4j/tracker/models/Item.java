package ru.job4j.tracker.models;

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
    private long create; // data create for Item

    /**
     * Перекрыте конструктора.
     */
    public Item() {
    }

    /**
     *
     * @param name передаем параметр в конструктор.
     * @param description передаем описание в конструктор.
     * @param create передаем дату создания в конструтор.
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
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
     * Устанавливаем значение create.
     * @return возвращаем дату создания Item.
     */
    public long getCreate() {
        return this.create;
    }

}
