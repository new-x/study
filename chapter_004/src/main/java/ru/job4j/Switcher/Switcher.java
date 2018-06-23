package ru.job4j.Switcher;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Switcher
 * Create data: 23.06.2018 14:43
 */

public class Switcher {
    private String myString = "";

    public void intToString(int number) {
        myString =  myString + String.valueOf(number);
    }

    public String retrunString() {
        return myString;
    }
}
