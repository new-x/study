package ru.job4j;

/**
 * Created by aleks on 28.08.2017.
 */
public class Characters {
    public int characters(String allSymbols, char symbol) {
        int number = 0;
        for (int index = 0; index < allSymbols.length(); index++){
            if (allSymbols.charAt(index) == symbol) {
                number++;
            }
        }
    return number;
    }
}
