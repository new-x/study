package ru.job4j.paintimg;

import org.junit.Test;
import ru.job4j.paintimg.models.Square;
import ru.job4j.paintimg.models.Triangle;
import ru.job4j.paintimg.start.Paint;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StubInputTest.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class PaintTest {
    /**
     * Test - draw Square.
     */
    @Test
    public void testSquare() {
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        String separator = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int index = 0; index < 8; index++) {
            stringBuilder.append("+");
        }
        stringBuilder.append(separator);
        for (int index = 0; index < 8; index++) {
            resultStringBuilder.append(stringBuilder);
        }
        resultStringBuilder.append(separator);
        paint.draw(new Square());
        String result = resultStringBuilder.toString();
        assertThat(paint.draw(new Square()), is(result));
    }
    /**
     * Test - draw Triangle/
     */
    @Test
    public void testTriangle() {
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        String separator = System.getProperty("line.separator");
        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("    +");
        resultStringBuilder.append(separator);
        resultStringBuilder.append("   +++");
        resultStringBuilder.append(separator);
        resultStringBuilder.append("  +++++");
        resultStringBuilder.append(separator);
        resultStringBuilder.append(" +++++++");
        resultStringBuilder.append(separator);
        resultStringBuilder.append("+++++++++");
        resultStringBuilder.append(separator);
        String result = resultStringBuilder.toString();
        //paint.draw(new Triangle());
        assertThat(paint.draw(new Triangle()), is(result));
    }
}
