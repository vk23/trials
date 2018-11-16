package vk.dev.trials.hackerrank.ten_days_of_statistics;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.calcMedian;
import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Day1_InterquartileRange.
 *
 * @author vladimir_kuragin
 */
public class Day1_InterquartileRange {

    public static void main(String[] args) {

        // read input
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int add = n % 2 == 0 ? 0 : 1;
        int[] values = new int[n];
        int[] frequencies = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequencies[i] = sc.nextInt();
        }
        sc.close();

        // populate array according to input params
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int val = values[i];
            int freq = frequencies[i];
            for (int j = 0; j < freq; j++) {
                integers.add(val);
            }
        }
        int[] arr = convert(integers);

        // calculate quartiles and range between q1 and q3
        int len = arr.length;
        Arrays.sort(arr);
        int q2 = (int) calcMedian(arr, 0, len - 1);
        int q1 = (int) calcMedian(arr, 0, (len - 1) / 2 - add);
        int q3 = (int) calcMedian(arr, (len - 1) / 2, len);
        int range = q3 - q1;
        System.out.printf("%.1f%n", range * 1.0);
    }

    private static String input() {
        return "6\n" +
                "6 12 8 10 20 16\n" +
                "5 4 3 2 1 5\n"; // expected result = 9.0
    }


}
