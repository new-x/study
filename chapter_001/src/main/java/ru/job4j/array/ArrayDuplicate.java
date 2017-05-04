package ru.job4j.array;
import java.util.Arrays;

/**
* Class ArrayDuplicate - Массивы.
* @author alekseev
* @since 1.0
*/

public class ArrayDuplicate {
  /**
  * Метод remove для убирания повторений в конец.
  * @param array массив слов
  * @return очищеный от повторений массив
  */
  public String[] remove(String[] array) {
    int count = 0;
       for (int index = 0; index < array.length - count; index++) {
         for (int number = index + 1; number < array.length - count; number++) {
           if (array[index].equals(array[number])) {
             String temp = array[number];
             array[number] = array[array.length - 1 - count];
             array[array.length - 1 - count] = temp;
             count++;
             number--;
           }
         }
      }
      /**
      for (int index = 0; index < array.length - count; index++) {
        for (int number = index + 1; number < array.length - count; number++) {
          if (array[index].equals(array[number])) {
            String temp = array[number];
            array[number] = array[length];
            array[length] = temp;
            length--;
          }
        }
     }
*/
       return Arrays.copyOf(array, array.length - count);
  }
}
