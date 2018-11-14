package ru.merge;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/*
 * Merge Sort Test
 * @author Alexeev Kirill
 * @version $Id$
 * @since 0.1
 */

public class MergeSortTest {

    /*
     * Even array sorting test
     */
    @Test
    public void evenTest() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{5, 2, 4, 6, 1, 3, 2, 6};
        int[] expectedArray = new int[]{1, 2, 2, 3, 4, 5, 6, 6};
        mergeSort.sort(array, 1, 8);
        assertThat(array, is(expectedArray));
    }

    /*
     * Odd array sorting test
     */
    @Test
    public void oddTest() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{9, 12, 4, 11, 8, 3, 1, 5, 2, 10, 7, 6, 13};
        int[] expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        mergeSort.sort(array, 1, 13);
        assertThat(array, is(expectedArray));
    }
    /*
    * Test sort of the middle
    */
    @Test
    public void middleTest() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{5, 2, 4, 1, 3, 6, 8, 7, 9, 10};
        int[] expectedArray = new int[]{5, 2, 1, 3, 4, 6, 8, 7, 9, 10};
        mergeSort.sort(array, 3, 7);
        assertThat(array, is(expectedArray));
    }

}