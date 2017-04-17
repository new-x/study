package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Max Number.
 *
 * @author Kirill Alekseev
 * @version $Id$
 * @since 0.1
 */

 public class MaxTest {
 	/**
 	* Тест поиска максимального значения из двух заданных.
 	*/
 	@Test
 	public void maxTestOne() {
 		Max operation = new Max();
 		int result = operation.findMaxNumber(2, 5);
 		int expected = 5;
 		assertThat(result, is(expected));
 	}

 	/**
 	* Тест поиска максимального значения из трех заданных.
 	*/
 	@Test
 	public void maxTestTwo() {
 		Max operation = new Max();
 		int result = operation.findMaxNumber(1, 3, 5);
 		int expected = 5;
 		assertThat(result, is(expected));
 	}
 }
