package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by aleks on 28.08.2017.
 */
public class CharactersTest {
    @Test
    public void countingCharactersInStringOne() {
        Characters characters = new Characters();
        int result = characters.characters("()))(", '(');
        assertThat(result, is(2));
    }

    @Test
    public void countingCharactersInStringTwo() {
        Characters characters = new Characters();
        int result = characters.characters("()))(", ')');
        assertThat(result, is(3));
    }
}