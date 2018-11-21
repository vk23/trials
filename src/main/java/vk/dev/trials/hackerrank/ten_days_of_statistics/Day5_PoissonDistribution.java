package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.factorial;

/**
 * Day5_PoissonDistribution.
 *
 * @author Vladimir_Kuragin
 */
public class Day5_PoissonDistribution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        double lambda = Double.parseDouble(sc.next());
        int k = sc.nextInt();
        sc.close();

        double probability = poissonDistribution(lambda, k);
        System.out.printf("%.5f%n", probability);
    }

    private static double poissonDistribution(double lambda, int k) {
        return (Math.pow(lambda, k) * Math.pow(Math.E, -lambda)) / factorial(k);
    }

    private static String input() {
        return "2.5\n" +
                "5\n";
    }
}
