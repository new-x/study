package ru.scratch;

/*
 * Merge Sorter
 * @author Alexeev Kirill
 * @version $Id$
 * @since 0.1
 */

public class MergeSort {
    public void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            this.merge(A, p, q, r);
        }
    }

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
