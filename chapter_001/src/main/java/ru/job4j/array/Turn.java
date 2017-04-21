package ru.job4j.array;

/**
* Class Turn - Массивы.
* @author alekseev
* @since 1.0
*/

public class Turn {
  /**
  * Метод back переворачивает массив.
  * @param array массив чисел
  * @return возвращаем перевернутый массив
  */
  public int[] back(int[] array) {

    for (int i = 0; i < array.length / 2; i++) {
    			int temp = array[i];
    			array[i] = array[array.length - 1 - i];
    			array[array.length - 1 - i] = temp;
    		}
    		return array;
  }

}
