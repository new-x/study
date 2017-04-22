package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class BubbleSort - Массивы.
* @author alekseev
* @since 1.0
*/

public class BubbleSortTest {
    /**
    * Test сортировка массива чисел в порядке возрастания.
    */
   @Test
   public void whenSortArrayWithTenElementsThenSortedArray() {
     BubbleSort bubblesort = new BubbleSort();
     int[] array = {5, 7, 8, 5, 3, 1};
     int[] result = bubblesort.sort(array);
     int[] expected = {1, 3, 5, 5, 7, 8};
     assertThat(result, is(expected));
      }
}
