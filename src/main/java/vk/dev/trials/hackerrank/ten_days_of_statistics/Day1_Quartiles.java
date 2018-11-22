package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Day1_Quartiles.
 *
 * @author vladimir_kuragin
 */
public class Day1_Quartiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int add = n % 2 == 0 ? 0 : 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(arr);
        int q2 = (int) Util.median(arr, 0, n-1);
        int q1 = (int) Util.median(arr, 0, (n-1)/2 - add);
        int q3 = (int) Util.median(arr, (n-1)/2 , n);
        System.out.printf("%d%n%d%n%d%n", q1, q2, q3);
    }

    private static String input() {
        return "9\n" +
                "3 7 8 5 12 14 21 13 18\n";
    }
}
