package ru.scratch;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ScratchTest {
    @Test
    public void testOne() {
        Scratch scratch = new Scratch();
        int[] arrayOne = new int[]{5, 2, 4, 6, 1, 3, 2, 6};
        int[] arrayTwo = new int[]{9, 12, 4, 11, 8, 3, 1, 5, 2, 10, 7, 6};
        int[] sortArrayOne = new int[]{1, 2, 2, 3, 4, 5, 6, 6};
        int[] sortArrayTwo = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        scratch.sort(arrayOne, 1, 8);
        assertThat(Arrays.toString(arrayOne), is(Arrays.toString(sortArrayOne)));
        scratch.sort(arrayTwo, 1, 12);
        assertThat(Arrays.toString(arrayTwo), is(Arrays.toString(sortArrayTwo)));
    }

}