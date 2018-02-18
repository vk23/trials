package vk.dev.trials.hackerrank.algorithms.rookie_rank_4;

import java.util.*;

/**
 * Med3_WinningHandOfCards.
 *
 * @author vk
 * @since 17.02.2018
 */
//TODO: fix timeouts
public class Med3_WinningHandOfCards {

    static int M = 0;
    static int X = 0;

    static int winningHands(int m, int x, int[] a) {
        M = m;
        X = x;
        int total = 0;
        for (int dim = 1; dim <= a.length; dim++) {
            total += permuteAndCheckWinning(a, 0, 0, dim, -1);
        }
        return total;
    }

    static int permuteAndCheckWinning(int[] a, int left, int index, int dim, long accumulated) {
        if (index == dim) {
            return accumulated % M == X ? 1 : 0;
        }
        int sum = 0;
        for (int j = left; j < a.length; j++) {
            int rem = a[j] % M;
            if (X != 0 && rem == 0) {
                sum += 0;
                continue;
            }
            //if (X == 0) {
            //    sum += rem == 0 ? 1 : 0;
            //    continue;
            //}
            long tmpAcc = (index == 0)
                    ? rem
                    : (accumulated * rem) % M;
            sum += permuteAndCheckWinning(a, j + 1, index + 1, dim, tmpAcc);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        long before = new Date().getTime();
        int result = winningHands(m, x, a);
        long after = new Date().getTime();

        System.out.println(result);
        System.out.printf("Time: %d ms%n", after - before);
        in.close();
    }
}
