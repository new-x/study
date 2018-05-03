package ru.job4j;

import org.junit.Test;
import ru.job4j.WorldChecking;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Alekseev Kirill.
 * Package name: java.ru.job4j
 * Create data: 03.05.2018 23:48
 */

public class WorldCheckingTest {
    @Test
    public void whenFirstWorldIsSecondWorld() {
        WorldChecking wch = new WorldChecking();
        StringBuilder worldOne = new StringBuilder("кирилл");
        StringBuilder worldTwo = new StringBuilder("рилкил");
        boolean result = wch.checkWorld(worldOne, worldTwo);
        assertThat(result, is(true));
    }
    @Test
    public void whenFirstWorldIsNotSecondWorld() {
        WorldChecking wch = new WorldChecking();
        StringBuilder worldOne = new StringBuilder("мама");
        StringBuilder worldTwo = new StringBuilder("мааа");
        boolean result = wch.checkWorld(worldOne, worldTwo);
        assertThat(result, is(false));
    }
}
