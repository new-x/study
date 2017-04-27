package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class RotateArrayTest - Массивы.
* @author alekseev
* @since 1.0
*/

public class RotateArrayTest {
  /**
  * Test - тестируем массив 3x3.
  */

  @Test
  public void arrayThreeByThree() {
    int[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  	RotateArray rotateArray = new RotateArray();
  	int[][] resultArray = rotateArray.rotate(values);
  	int[][] expectArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
  	assertThat(resultArray, is(expectArray));
  }

}
