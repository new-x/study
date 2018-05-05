package ru.job4j;

import org.junit.Test;
import ru.job4j.WorldChecking;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Alekseev Kirill.
 * Package name: java.ru.job4j
 * Create data: 03.05.2018 23:48
 */

public class WorldCheckingTest {
    @Test
    public void whenFirstWorldIsSecondWorldOne() {
        WorldChecking wch = new WorldChecking();
        String first = "мама";
        String second = "амам";
        assertThat(wch.checkWorld(first, second), is(true));
    }
    @Test
    public void whenFirstWorldIsSecondWorldTwo() {
        WorldChecking wch = new WorldChecking();
        String first = "кирилл";
        String second = "лилкир";
        assertThat(wch.checkWorld(first, second), is(true));
    }
    @Test
    public void whenFirstWorldIsNotSecondWorld() {
        WorldChecking wch = new WorldChecking();
        String first = "ложь";
        String second = "бжол";
        assertThat(wch.checkWorld(first, second), is(false));
    }
}
