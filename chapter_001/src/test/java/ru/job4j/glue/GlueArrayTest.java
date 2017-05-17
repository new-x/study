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
  public void arrayGlue() {
    int[] first = {1, 3, 5, 7, 9};
    int[] second = {2, 4, 6, 8, 10};
  	GlueArray glueArray = new GlueArray();
  	int[] resultArray = glueArray.glue(first, second);
  	int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  	assertThat(resultArray, is(expectArray));
  }

}
