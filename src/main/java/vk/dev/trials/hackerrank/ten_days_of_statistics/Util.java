package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Arrays;

/**
 * Util.
 *
 * @author vladimir_kuragin
 */
public class Util {

    public static double calcMedian(int[] arr, int left, int right) {
        int mid = (right + 1 - left) / 2 + left;
        return ((right + 1 - left) % 2 == 0)
                ? (arr[mid - 1] + arr[mid]) / 2.0
                : arr[mid];
    }

    public static double calcMedianNotSorted(int[] arr, int from, int to) {
        Arrays.sort(arr);
        return calcMedian(arr, from, to);
    }
}
