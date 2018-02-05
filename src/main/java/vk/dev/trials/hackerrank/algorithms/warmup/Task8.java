package vk.dev.trials.hackerrank.algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task8.
 *
 * @author vk
 * @since 05.02.2018
 */
public class Task8 {

    // solution goes here
    static void miniMaxSum(int[] arr) {
        int min = Arrays.stream(arr).min().orElseThrow(() -> new IllegalArgumentException("Empty input array?"));
        int max = Arrays.stream(arr).max().orElseThrow(() -> new IllegalArgumentException("Empty input array?"));

        long sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.format("%d %d", sum - max, sum - min);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }

}
