package vk.dev.trials.hackerrank.algorithms.rookie_rank_4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Easy1_ExamRush.
 *
 * @author vk
 * @since 16.02.2018
 */
public class Easy1_ExamRush {

    static int examRush(int[] tm, int t) {
        Arrays.sort(tm);
        int sum = 0;
        for (int i = 0; i < tm.length && sum <= t; i++) {
            sum += tm[i];
            if (sum >= t) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] tm = new int[n];
        for (int tm_i = 0; tm_i < n; tm_i++) {
            tm[tm_i] = in.nextInt();
        }
        int result = examRush(tm, t);
        System.out.println(result);
        in.close();
    }
}
