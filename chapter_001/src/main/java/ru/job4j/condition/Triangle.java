package ru.job4j.condition;

/**
 * Class Triangle - Условный оператор.
 * @author alekseev
 * @since 1.0
 */

public class Triangle {
/**
* Point a описывает точки в системе координат.
*/
private Point a;
/**
* Point b описывает точки в системе координат.
*/
private Point b;
/**
*  Point c описывает точки в системе координат.
*/
private Point c;

/**
* Конструктор.
* @param a - a первая переменная.
* @param b - b вторая переменная.
* @param c - c третья переменная.
*/
public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
}

/**
* Высчитываем площадь треугольнк по формуле герона.
* @return возвращает параметр.
*/
public double area() {
  double square;
  square = 0.5 * ((b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX()));
  return square >= 0 ? square : -square;
}

}
