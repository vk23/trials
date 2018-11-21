package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

/**
 * Day5_PoissonDistribution.
 *
 * @author Vladimir_Kuragin
 */
public class Day5_PoissonDistribution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        double lambda1 = Double.parseDouble(sc.next());
        double lambda2 = Double.parseDouble(sc.next());
        sc.close();

        double cost1 = 160 + 40 * variance(lambda1);
        double cost2 = 128 + 40 * variance(lambda2);
        System.out.printf("%.3f%n%.3f%n", cost1, cost2);
    }

    private static double variance(double lambda) {
        return lambda + lambda * lambda;
    }

    private static String input() {
        return "0.88 1.55\n";
    }
}
