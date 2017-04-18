package ru.job4j.loop;

/**
* Class Factorial - Циклы.
* @author alekseev
* @since 1.0
*/

public class Factorial {
/**
* Вычисление факториала.
* @param n факториал
* @return sum - сумма четных чисел
*/

public int calc(int n) {
    int factorial = 1;

  for (; n >= 1; n--) {
    factorial *= n;
  }

  return factorial;

}
}
