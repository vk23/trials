package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Arrays;

/**
 * Util.
 *
 * @author vladimir_kuragin
 */
public class Util {

    public static double calcMediane(int[] arr, int from, int to) {
        int mid = (from - to) / 2;
        return ((from - to) % 2 == 0)
                ? (arr[mid - 1] + arr[mid]) / 2.0
                : arr[mid];
    }

    public static double calcMedianeNotSorted(int[] arr, int from, int to) {
        Arrays.sort(arr);
        return calcMediane(arr, from, to);
    }
}
