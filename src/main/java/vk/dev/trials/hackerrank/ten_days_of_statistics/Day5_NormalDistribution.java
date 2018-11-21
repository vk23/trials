package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.erf;

/**
 * Day5_NormalDistribution.
 *
 * @author Vladimir_Kuragin
 */
public class Day5_NormalDistribution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int mean = sc.nextInt();
        int sigma = sc.nextInt(); // standard deviation
        double q1condition = Double.parseDouble(sc.next());
        int q2condition1 = sc.nextInt();
        int q2condition2 = sc.nextInt();
        sc.close();

        double q1result = normalDistribution(mean, sigma, q1condition);
        double q2result = normalDistribution(mean, sigma, q2condition2) - normalDistribution(mean, sigma, q2condition1);
        System.out.printf("%.3f%n%.3f%n", q1result, q2result);
    }

    private static double normalDistribution(int mean, int sigma, double x) {
        double z = (x - mean) / (sigma * Math.sqrt(2));
        return 0.5 * (1 + erf(z));
    }

    private static String input() {
        return "20 2\n" +
                "19.5\n" +
                "20 22\n";
    }
}
