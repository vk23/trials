package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

/**
 * Day1_StandardDeviation.
 *
 * @author vladimir_kuragin
 */
public class Day1_StandardDeviation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sc.close();

        double mean = (sum * 1.0) / n;
        double sumOfSquaredDistances = 0;
        for (int i = 0; i < n; i++) {
            sumOfSquaredDistances += Math.pow(arr[i] - mean, 2.0);
        }
        double standardDeviation = Math.sqrt(sumOfSquaredDistances / n);
        System.out.printf("%.1f%n", standardDeviation);
    }

    private static String input() {
        return "5\n" +
                "10 40 30 50 20\n";
    }
}
