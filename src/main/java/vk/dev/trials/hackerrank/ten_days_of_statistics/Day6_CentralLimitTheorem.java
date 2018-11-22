package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.erf;

/**
 * Day6_CentralLimitTheorem.
 *
 * @author Vladimir_Kuragin
 */
public class Day6_CentralLimitTheorem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int totalMass = sc.nextInt();
        int numBoxes = sc.nextInt();
        int mean = sc.nextInt();
        int sigma = sc.nextInt();
        sc.close();

        // mean' = n*mean
        // sigma' = sqrt(n)*sigma
        double p = normalDistribution(mean * numBoxes, Math.sqrt(numBoxes) * sigma, totalMass);
        System.out.printf("%.4f%n", p);
    }

    private static double normalDistribution(int mean, double sigma, double x) {
        double z = (x - mean) / (sigma * Math.sqrt(2));
        return 0.5 * (1 + erf(z, 10000));
    }

    private static String input() {
        return "9800\n" +
                "49\n" +
                "205\n" +
                "15\n";
    }
}
