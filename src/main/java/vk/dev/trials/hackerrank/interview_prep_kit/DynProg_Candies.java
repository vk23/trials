package vk.dev.trials.hackerrank.interview_prep_kit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DynProg_Candies.
 *
 * @author Vladimir_Kuragin
 */
public class DynProg_Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        System.out.println(Arrays.toString(arr));
        long[] candies = new long[n];

        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        System.out.println(Arrays.toString(candies));
        return sum;
    }

//    static long candies(int n, int[] arr) {
//        System.out.println(Arrays.toString(arr));
//        long[] candies = new long[n];
//        long sum = 0;
//        long c = rec(arr, n - 1, candies);
//        for (int i = 0; i < n; i++) {
//            sum += candies[i];
//        }
//        System.out.println(Arrays.toString(candies));
//        return sum;
//    }
//
//    static long rec(int[] arr, int i, long[] candies) {
//        if (i < 0 || i >= arr.length) {
//            return 0;
//        }
//        if (candies[i] > 0) {
//            return candies[i];
//        }
//        long tmp = 0;
//        System.out.println(i);
//        long sl = rec(arr, i - 1, candies);
//
//        int l = get(arr, i-1);
//        int r = get(arr, i+1);
//        int cur = get(arr, i);
//
//        if (cur <= l && cur < r) {
//            tmp = 1;
//        } else if (cur > l && cur > r) {
//            tmp = sl + 1;
//        } else if (cur > r && r < 0) {
//            tmp = 1;
//        } else if (cur > r) {
//            tmp = 2;
//        } else {
//            tmp = sl + 1;
//        }
//        candies[i] = tmp;
//        return tmp;
//    }
//
//    static int get(int[] arr , int i) {
//        if (i<0 || i >= arr.length) {
//            return -1;
//        }
//        return arr[i];
//    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(input());
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }
        scanner.close();

        long result = candies(n, arr);
        System.out.println(result);

    }

    private static String input() {
        return "10\n" +
                "2\n" +
                "4\n" +
                "2\n" +
                "6\n" +
                "1\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "2\n" +
                "1\n"; // expected: 19
    }
}
