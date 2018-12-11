package vk.dev.trials.hackerrank.interview_prep_kit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sorting_MarkAndToys.
 *
 * @author Vladimir_Kuragin
 */
public class Sorting_MarkAndToys {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        sc.close();

        System.out.printf("%d%n", maximumToys(prices, k));
    }

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int i = 0;
        while (k > 0) {
            k -= prices[i++];
        }
        return i - 1;
    }

    private static String input() {
        return "7 50\n" +
                "1 12 5 111 200 1000 10\n"; // expected: 4
    }
}
