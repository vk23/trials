package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

/**
 * Day4_GeometricDistribution.
 *
 * @author Vladimir_Kuragin
 */
public class Day4_GeometricDistribution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int numerator = sc.nextInt();
        int denominator = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        double p = (numerator * 1.0) / denominator;
        double q = 1 - p;
        double result = 0.0;
        for (int i = 1; i <= n; i++) {
            result += geometricDistribution(p, q, i);
        }
        System.out.printf("%.3f%n", result);
    }

    private static double geometricDistribution(double p, double q, int n) {
        return p * Math.pow(q, n - 1);
    }

    private static String input() {
        return "1 3\n" +
                "5\n";
    }
}
