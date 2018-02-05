package vk.dev.trials.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Task5.
 *
 * @author vk
 * @since 05.02.2018
 */
public class Task5 {

    // solution goes here
    static int diagonalDifference(int[][] a) {
        assert a.length > 0 && a.length == a[0].length;
        int last = a.length - 1;

        int x = 0, y = 0;
        for (int i = 0; i <= last; i++) {
            x += a[i][i];
            y += a[i][last - i];
        }

        return Math.abs(x - y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
