package vk.dev.trials.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Task9.
 *
 * @author vk
 * @since 05.02.2018
 */
public class Task9 {

    // solution goes here
    static int birthdayCakeCandles(int n, int[] ar) {
        int result = 0, max = Integer.MIN_VALUE;
        for (int i : ar) {
            if (i == max) {
                result++;
            } else if (i > max) {
                max = i;
                result = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }

}
