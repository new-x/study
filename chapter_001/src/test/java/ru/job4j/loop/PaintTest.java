package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Paint.
* @author Kirill Alekseev
* @version $Id$
* @since 0.1
*/

public class PaintTest {
	/**
	* Тест формирования пирамиды высотой 2.
	*/
	@Test
	public void whenPiramidSize2ThenDrawPiramidSize2() {
		Paint figure = new Paint();
		String result = figure.piramid(2);
		String expected = " ^ \n\r"
		                           +
		                  "^^^\n\r";
        assertThat(result, is(expected));
	}
		/**
	* Тест формирования пирамиды высотой 3.
	*/
	@Test
	public void whenPiramidSize3ThenDrawPiramidSize3() {
		Paint figure = new Paint();
		String result = figure.piramid(3);
		String expected = "  ^  \n\r"
		                           +
		                  " ^^^ \n\r"
						           +
						  "^^^^^\n\r";
        assertThat(result, is(expected));
	}

}
