package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

/**
 * Day0_WeightedMean.
 *
 * @author vladimir_kuragin
 */
public class Day0_WeightedMean {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        sc.close();

        int numerator = 0, denominator = 0;
        for (int i = 0; i < n; i++) {
            numerator += values[i] * weights[i];
            denominator += weights[i];
        }
        double weightedMean = (numerator*1.0) / denominator;
        System.out.printf("%.1f%n", weightedMean);
    }

    private static String input() {
        return "5\n" +
                "10 40 30 50 20\n" +
                "1 2 3 4 5\n";
    }
}
