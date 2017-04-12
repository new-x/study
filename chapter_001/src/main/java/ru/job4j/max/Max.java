package ru.job4j.max;

/**
* Class Max - Условный оператор.
* @author alekseev
* @since 1.0
*/

public class Max {

/**
* Метод получает на вход 2 числа и возвращает то, что больше.
* @param first первое число.
* @param second второе число.
* @return возвращает большее число.
*/

public int findMaxNumber(final int first, final int second) {

    return first > second ? first : second;
    }

}
