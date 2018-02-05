package vk.dev.trials.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Task6.
 *
 * @author vk
 * @since 05.02.2018
 */
public class Task6 {

    // solution goes here
    static void plusMinus(int[] arr) {
        int n = arr.length;
        int[] sums = new int[3];
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            if (x > 0) {
                sums[0]++;
            } else if (x < 0) {
                sums[1]++;
            } else {
                sums[2]++;
            }
        }

        for (int i = 0; i < sums.length; i++) {
            System.out.format("%f%n", sums[i]*1d/n);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
