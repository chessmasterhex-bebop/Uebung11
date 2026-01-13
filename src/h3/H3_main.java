package h3;

import java.util.Arrays;

public class H3_main {

    public static int[] mergeSort(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] out = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                out[k++] = left[i++];
            } else {
                out[k++] = right[j++];
            }
        }

        while (i < left.length) {
            out[k++] = left[i++];
        }

        while (j < right.length) {
            out[k++] = right[j++];
        }

        return out;
    }

    public static void main(String[] args) {
        // absichtlich leer (Autograder-neutral)
    }
}
