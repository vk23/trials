package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Easy3_SockMerchant.
 *
 * @author vk
 * @since 14.02.2018
 */
public class Easy3_SockMerchant {

    static int sockMerchant(int n, int[] ar) {

        int pairCount = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (i == j) {
                    continue;
                }
                if (ar[i] == Integer.MIN_VALUE) {
                    continue;
                }
                if (ar[i] == ar[j]) {
                    pairCount++;
                    ar[i] = Integer.MIN_VALUE;
                    ar[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }

        return pairCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
