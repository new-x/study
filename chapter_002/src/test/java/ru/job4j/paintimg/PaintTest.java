package ru.job4j.paintimg;

import org.junit.Test;
import ru.job4j.paintimg.models.Square;
import ru.job4j.paintimg.models.Triangle;
import ru.job4j.paintimg.start.Paint;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StubInputTest.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class PaintTest
{
    @Test
    public void testSquare() {
        Paint paint = new Paint();
        assertThat(paint.draw(new Square()), is());
    }
}
