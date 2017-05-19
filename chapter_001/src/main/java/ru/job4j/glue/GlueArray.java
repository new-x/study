package ru.job4j.glue;

/**
* Class RotateArray - Массивы.
* @author alekseev
* @since 1.0
*/

public class GlueArray {
  /**
 * Метод glue склеивает массив.
 * @param first первый массив чисел.
 * @param second второй массив чисел.
 * @return array массив после склеивания.
 */
  public int[] glue(int[] first, int[] second) {
    int[] array = new int[first.length + second.length];
    int count = 0;



    for (int index = 0; index < array.length; index++) {
      if (first.length > count & second.length > count) {
        if (first[count] > second[count]) {
          array[index] = second[count];
          array[index + 1] = first[count];
        } else {
          array[index] = first[count];
          array[index + 1] = second[count];
          }
          count++;
          index++;
    } else if (first.length > count) {
      array[index] = first[count];
      count++;
    } else if (second.length > count) {
      array[index] = second[count];
      count++;
    }
  }
    /*for (int index = 0; index < array.length; index++) {
      if (count < first.length) {
      if (first[count] > second[count]) {
        array[index] = second[count];
      }
      } else {
        array[index] = second[count];
      }

      if (count < second.length) {
      if (second[count] < first[count]) {
        array[index + 1] = first[count];
      }
      } else {
        array[index] = first[count];
      }
      count++;
      index++;

    }
    */
    return array;
  }
}
