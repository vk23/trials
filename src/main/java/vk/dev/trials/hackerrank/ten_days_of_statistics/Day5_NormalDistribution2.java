package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.erf;

/**
 * Day5_NormalDistribution2.
 *
 * @author Vladimir_Kuragin
 */
public class Day5_NormalDistribution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int mean = sc.nextInt();
        int sigma = sc.nextInt(); // standard deviation
        int condition1 = sc.nextInt();
        int condition2 = sc.nextInt();
        sc.close();

        double result1 = 1 - normalDistribution(mean, sigma, condition1);
        double result2 = 1 - normalDistribution(mean, sigma, condition2);
        double result3 = normalDistribution(mean, sigma, condition2);
        System.out.printf("%.2f%n%.2f%n%.2f%n", result1 * 100, result2 * 100, result3 * 100);
    }

    private static double normalDistribution(int mean, int sigma, double x) {
        double z = (x - mean) / (sigma * Math.sqrt(2));
        return 0.5 * (1 + erf(z, 50000));
    }

    private static String input() {
        return "70 10\n" +
                "80\n" +
                "60\n";
    }
}
