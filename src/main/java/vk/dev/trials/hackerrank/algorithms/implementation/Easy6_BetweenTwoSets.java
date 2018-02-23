package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Easy6_BetweenTwoSets.
 *
 * @author vk
 * @since 22.02.2018
 */
public class Easy6_BetweenTwoSets {

    static int getTotalX(int[] a, int[] b) {
        long lcm = a[0];
        for (int i = 1; i < a.length; i++) {
            lcm = lcm(lcm, a[i]);
        }
        long gcd = b[0];
        for (int i = 1; i < b.length; i++) {
            gcd = gcd(gcd, b[i]);
        }

        int result = 0;
        int i = 1;
        while (lcm * i <= gcd) {
            if (gcd % (lcm * i) == 0) {
                result++;
            }
            i++;
        }
        return result;
    }

    static long gcd(long x, long y) {
        if (x == y) {
            return x;
        }
        long lesser = x > y ? y : x;
        long greater = x > y ? x : y;
        long rem = greater % lesser;
        return rem == 0 ? lesser : gcd(lesser, rem);
    }

    static long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
