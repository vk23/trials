package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Day0_MeanMedianMode.
 *
 * @author vladimir_kuragin
 */
public class Day0_MeanMedianMode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // mean
        double mean = (sum * 1.0) / n;
        System.out.printf("%.1f%n", mean);

        // median
        System.out.printf("%.1f%n", Util.calcMedian(arr, 0, n));

        // mode
        System.out.println(calcMode(n, arr));
    }

    private static String input() {
        return "10\n" +
                "64630 11735 14216 99233 14470 4978 73429 38120 51135 67060\n";
    }

    private static int calcMode(int n, int[] arr) {
        int modeVal = arr[0];
        int modeCount = 1;
        int modeValCurr = arr[0];
        int modeCountCurr = 1;
        for (int i = 1; i < n; i++) {
            if (modeValCurr != arr[i]) {
                modeValCurr = arr[i];
                modeCountCurr = 1;
            } else {
                modeCountCurr++;
            }
            if (modeCountCurr > modeCount) {
                modeCount = modeCountCurr;
                modeVal = modeValCurr;
            }
        }
        return modeVal;
    }


}
