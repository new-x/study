package ru.job4j.loop;

/**
* Class Loop - Циклы.
* @author alekseev
* @since 1.0
*/

public class Counter {
/**
* Подсчет суммы чётных чисел в диапазоне.
* @param start начало диапозона
* @param finish конец диапозона
* @return sum - сумма четных чисел
*/
public int add(int start, int finish) {
  int sum = 0;
  for (; start <= finish;) {

      if (start % 2 == 0) {
        sum = sum + start;
        start++;
      } else {
        start++;
      }

    }
  return sum;
  }
}
