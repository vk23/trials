package vk.dev.trials.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Task5.
 *
 * @author vk
 * @since 05.02.2018
 */
public class Task6 {

    // solution goes here
    static void plusMinus(int[] arr) {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
