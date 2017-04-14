package ru.job4j.condition;

/**
 * Class Point - Условный оператор.
 * @author alekseev
 * @since 1.0
 */

public class Point {
  /**
 * Значение x класса Point.
 */
private int x;
/**
 * Значение y класса Point.
 */
private int y;
/**
 * Конструктор.
 * @param x абсцисса точки.
 * @param y ордината точки.
 */

public Point(int x, int y) {
        this.x = x;
        this.y = y;
}

/**
 * Метод getX.
 * @return значение Х.
 */
public int getX() {
        return this.x;
}

/**
 * Метод getY.
 * @return значение Y.
 */
public int getY() {
        return this.y;
}

/**
 * Метод is определяет находится ли точка на прямой y(x) = a*x + b.
 * @param a коэф. х.
 * @param b смещение.
 * @return правда или ложь.
 */
public boolean is(int a, int b) {
        return this.y == a * this.x + b;
}
}
