package vk.dev.trials.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Task7.
 *
 * @author vk
 * @since 05.02.2018
 */
public class Task7 {

    // solution goes here
    static void staircase(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = j < n - i - 1 ? ' ' : '#';
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }

}
