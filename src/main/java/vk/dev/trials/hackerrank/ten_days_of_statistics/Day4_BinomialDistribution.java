package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.factorial;

/**
 * Day4_BinomialDistribution.
 *
 * @author Vladimir_Kuragin
 */
public class Day4_BinomialDistribution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        double a = Double.parseDouble(sc.next());
        double b = Double.parseDouble(sc.next());
        sc.close();

        double p = a / (a + b);
        double q = b / (a + b);
        System.out.printf("p = %.5f, q = %.5f%n", p, q);

        int n = 6;
        int x = 3;

        double sum = 0;
        for (int i = x; i <= n; i++) {
            long combinations = combinations(n, i);
            System.out.printf("Number of combinations for %d of %d = %d%n", i, n, combinations);
            double probability = probability(p, q, n, combinations, i);
            sum += probability;
            System.out.printf("Probability for %d of %d = %.5f%n", i, n, probability);
        }

        System.out.printf("result = %.3f%n", sum);
    }

    private static String input() {
        return "1.09 1\n";
    }

    private static long combinations(int n, int x) {
        return factorial(n) / (factorial(x) * factorial(n - x));
    }

    private static double probability(double p, double q, int n, long combinations, int i) {
        return combinations * Math.pow(p, i) * Math.pow(q, (n-i));
    }

}
