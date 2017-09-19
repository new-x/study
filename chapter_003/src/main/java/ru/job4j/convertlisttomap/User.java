package ru.job4j.convertlisttomap;

/**
 * Created by aleks on 17.09.2017.
 */
public class User {
    public int id;
    public String name;
    public String city;

    public User(int id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
