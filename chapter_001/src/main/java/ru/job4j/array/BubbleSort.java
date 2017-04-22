package ru.job4j.array;

/**
* Class BubbleSort - Массивы.
* @author alekseev
* @since 1.0
*/

public class BubbleSort {
  /**
  * Метод sort для сортировки массива чисел по возростанию.
  * @param array массив чисел
  * @return отсротированный массив чисел
  */
  public int[] sort(int[] array) {
    		boolean value;
		do {
      value = false;
				for (int index = 0; index < array.length - 1; index++) {
					if (array[index] > array[index + 1]) {
						int temp = array[index];
						array[index] = array[index + 1];
						array[index + 1] = temp;
						value = true;
					}
				}
		} while (value);
		return array;
	}
}
