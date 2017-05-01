package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class ArrayDuplicateTest - Массивы.
* @author alekseev
* @since 1.0
*/

public class ArrayDuplicateTest {
  /**
  * Тестируем обрезание массива с дубликатами.
  */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
      ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
      String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
      String[] resultArray = arrayDuplicate.remove(array);
      String[] expectArray = {"Привет", "Мир", "Супер"};
      assertThat(resultArray, is(expectArray));

}

}
