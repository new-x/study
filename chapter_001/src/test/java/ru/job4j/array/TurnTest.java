package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Turn Array.
 *
 * @author Kirill Alekseev
 * @version $Id$
 * @since 0.1
 */

 public class TurnTest {
   /**
   * Переворачиваем массив с четным количество чисел.
   */
   @Test
   public void whenEvenNumber() {
     Turn turn = new Turn();
     int[] arr = {1, 2, 3, 4, 5, 6};
     int[] result = turn.back(arr);
     int[] expected = {6, 5, 4, 3, 2, 1};
     assertThat(result, is(expected));
 }

   /**
   * Переворачиваем массив с нечетным количество чисел.
   */
   @Test
    public void whenOddNumber() {
      Turn turn = new Turn();
      int[] arr = {1, 2, 3, 4, 5};
      int[] result = turn.back(arr);
      int[] expected = {5, 4, 3, 2, 1};
      assertThat(result, is(expected));
 }

 }
