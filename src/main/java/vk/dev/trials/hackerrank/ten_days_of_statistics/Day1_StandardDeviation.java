package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.mean;
import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.standardDeviation;

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
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        double mean = mean(arr);
        double standardDeviation = standardDeviation(arr, mean);
        System.out.printf("%.1f%n", standardDeviation);
    }

    private static String input() {
        return "5\n" +
                "10 40 30 50 20\n";
    }
}
