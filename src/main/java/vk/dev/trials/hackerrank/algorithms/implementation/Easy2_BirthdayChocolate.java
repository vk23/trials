package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Easy2_BirthdayChocolate.
 *
 * @author vk
 * @since 07.02.2018
 */
public class Easy2_BirthdayChocolate {

    static int solve(int size, int[] arr, int sum, int num) {
        // special case
        if (size == 1) {
            return sum == arr[0] ? 1 : 0;
        }

        int result = 0;
        // sum of digits for current window
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            // sum up until windows is full
            if (i < num) {
                tmp += arr[i];
            } else {
                // update window sum by subtracting very left item and adding current one
                tmp -= arr[i - num];
                tmp += arr[i];
            }
            // now check if tmp sum satisfies task's condition
            if (i >= num - 1 && tmp == sum) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for (int s_i = 0; s_i < n; s_i++) {
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
