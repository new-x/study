package ru.job4j.substring;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class Substring - Тестовое задание.
* @author alekseev
* @since 1.0
*/

public class SubstringTest {
/**
* Тестируем - проверяем что строка sub является подстрокой origin.
*/
  @Test
  public void subSubstringOrigin() {
    Substring substring = new Substring();
    String origin = "работа";
    String sub = "бот";
    boolean result = substring.contains(origin, sub);
    boolean expected = true;
    assertThat(result, is(expected));
  }
}
