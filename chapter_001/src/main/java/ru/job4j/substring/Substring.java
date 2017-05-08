package ru.job4j.substring;
//import java.util.Arrays;

/**
* Class Substring - Тестовое задание.
* @author alekseev
* @since 1.0
*/

public class Substring {
  /**
  * Метод contains проверяет, что строка origin содержит строку sub.
  * @param origin - целая строка
  * @param sub - подстрока строки origin
  @ @return возвращаем true or false.
  */
public boolean contains(String origin, String sub) {
  char[] arrayOrigin = origin.toCharArray();
  char[] arraySub = sub.toCharArray();
  boolean check = false;

  for (int index = 0; index < arrayOrigin.length; index++) {
    for (int number = 0; number < arraySub.length; number++) {
      int count = index;
      if (arraySub[number] == arrayOrigin[count]) {
        count++;
      } else if (count == arraySub.length) {
      check = true;
      number = arraySub.length;
      index = arrayOrigin.length;
    } else if (count != arraySub.length) {
      number = arraySub.length;
    }
  }
}
return check;
}
}
