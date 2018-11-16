package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Arrays;
import java.util.List;

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

    public static int[] convert(List<Integer> integers) {
        int[] res = new int[integers.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = integers.get(i);
        }
        return res;
    }

    public static int[] convert(Integer[] integers) {
        int[] res = new int[integers.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = integers[i];
        }
        return res;
    }
}
