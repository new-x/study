package ru.job4j.glue;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class GlueArrayTest - Склеивание массивов.
* @author alekseev
* @since 1.0
*/

public class GlueArrayTest {
  /**
  * Test - тестируем склеивание двух массивов с последовательными числами.
  */

  @Test
  public void arrayGlueOne() {
    int[] first = {1, 3, 5, 7, 9};
    int[] second = {2, 4, 6, 8, 10};
  	GlueArray glueArray = new GlueArray();
  	int[] resultArray = glueArray.glue(first, second);
  	int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  	assertThat(resultArray, is(expectArray));
  }

  /**
  * Test - тестируем склеивание двух массивов, второй массив пустой.
  */

  @Test
  public void arrayGlueTwo() {
    int[] first = {1, 3, 5, 7, 9};
    int[] second = {};
    GlueArray glueArray = new GlueArray();
    int[] resultArray = glueArray.glue(first, second);
    int[] expectArray = {1, 3, 5, 7, 9};
    assertThat(resultArray, is(expectArray));
  }

  /**
  * Test - тестируем склеивание двух массивов, первый массив пустой.
  */

  @Test
  public void arrayGlueThree() {
    int[] first = {};
    int[] second = {2, 4, 6, 8, 10};
    GlueArray glueArray = new GlueArray();
    int[] resultArray = glueArray.glue(first, second);
    int[] expectArray = {2, 4, 6, 8, 10};
    assertThat(resultArray, is(expectArray));
  }

  /**
  * Test - тестируем склеивание двух массивов, первый короче.
  */

  @Test
  public void arrayGlueFour() {
    int[] first = {1, 3, 7, 9};
    int[] second = {2, 4, 6, 8, 10};
  	GlueArray glueArray = new GlueArray();
  	int[] resultArray = glueArray.glue(first, second);
  	int[] expectArray = {1, 2, 3, 4, 6, 7, 8, 9, 10};
    assertThat(resultArray, is(expectArray));
  }

  /**
  * Test - тестируем склеивание двух массивов, второй короче.
  */

  @Test
  public void arrayGlueFive() {
    int[] first = {1, 3, 5, 7, 9};
    int[] second = {2, 4, 6, 8};
    GlueArray glueArray = new GlueArray();
    int[] resultArray = glueArray.glue(first, second);
    int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    assertThat(resultArray, is(expectArray));
  }

}
