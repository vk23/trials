package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Easy1_Kangaroo https://www.hackerrank.com/challenges/kangaroo.
 *
 * @author vk
 * @since 06.02.2018
 */
public class Easy1_Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 != x2 && v1 == v2) {
            return "NO";
        }
        int x = (x2 - x1) / (v1 - v2);
        int remainder = (x2 - x1) % (v1 - v2);
        return (x > 0 && remainder == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println("Input locations and velocities:");
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
