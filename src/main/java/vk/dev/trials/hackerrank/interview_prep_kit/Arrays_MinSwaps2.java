package vk.dev.trials.hackerrank.interview_prep_kit;

import java.util.Scanner;

/**
 * Arrays_MinSwaps2.
 *
 * @author vladimir_kuragin
 */
public class Arrays_MinSwaps2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int res = minimumSwaps(a);
        System.out.printf("%d%n", res);
    }

    private static String input() {
        return "5\n" +
                "2 3 4 1 5\n";
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] == i+1) {
                continue;
            }
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] == i+1) {
                    swap(arr, i, j);
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
