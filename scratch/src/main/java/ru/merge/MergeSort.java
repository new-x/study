package ru.merge;

/**
 * Merge Sorter
 * @author Alexeev Kirill
 * @version $Id$
 * @since 0.1
 */

public class MergeSort {
    /**
     * Sort the subarray by the merge.
     * @param A common array specified for sorting.
     * @param p the first element of the sorted subarray.
     * @param r the last element of the sorted subarray.
     */
    public void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            this.merge(A, p, q, r);
        }
    }

    /**
     * Sort two sorted subarrays by merge.
     * @param arr common array.
     * @param p the first element of the first subarray.
     * @param q the last element of the first subarray.
     * @param r the last element of the second subarray.
     */
    public void merge(int[] arr, int p, int q, int r) {
        int firstArrayPosition = p - 1;
        int firstArrayLastIndex = q - 1;
        int secondArrayPosition = q;
        int secondArrayLastIndex = r - 1;
        int workSize = secondArrayLastIndex - firstArrayPosition;
        int[] result = new int[workSize + 1];
        for (int i = 0; i <= workSize; i++) {
            result[i] =
                    (secondArrayPosition > secondArrayLastIndex)
                            || (firstArrayPosition <= firstArrayLastIndex
                            && arr[firstArrayPosition] < arr[secondArrayPosition])
                            ? arr[firstArrayPosition++] : arr[secondArrayPosition++];
        }
        System.arraycopy(result, 0, arr, p - 1, result.length);
    }
}
