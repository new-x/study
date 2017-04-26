package ru.job4j.array;

/**
* Class RotateArray - Массивы.
* @author alekseev
* @since 1.0
*/

public class RotateArray {
  /**
 * Метод rotate поворачивающий массив.
 * @param array массив.
 * @return массив после поворота.
 */
  public int[][] rotate(int[][] array) {
    int height = array.length;
    int length = array[0].length;
    for (int index = 0; index < height / 2; index++) {
      for (int number = 0; number < length - 1 - index; number++) {
      int temp = array[index][number];
      array[index][number] = array[length - index - 1][number];
      array[length - number - 1][index] = array[length - index - 1][length - number - 1];
      array[length - index - 1][length - number - 1] = array[number][length - index - 1];
      array[number][length - index - 1] = temp;
      }
    }
    return array;
  }
}
