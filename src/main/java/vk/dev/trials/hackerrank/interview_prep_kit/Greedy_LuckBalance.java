package vk.dev.trials.hackerrank.interview_prep_kit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Greedy_LuckBalance.
 *
 * @author Vladimir_Kuragin
 */
public class Greedy_LuckBalance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] contests = new int[n][2];
        for (int i = 0; i < n; i++) {
            contests[i][0] = sc.nextInt();
            contests[i][1] = sc.nextInt();
        }
        sc.close();

        int result = luckBalance(k, contests);
        System.out.printf("%d%n", result);
    }

    static int luckBalance(int k, int[][] contests) {
        List<Integer> important = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 1) {
                important.add(contests[i][0]);
            } else {
                result += contests[i][0];
            }
        }

        important.sort(Comparator.reverseOrder());
        for (Integer i : important) {
            if (k-- > 0) {
                result += i;
            } else {
                result -= i;
            }
        }
        return result;
    }

    static String input() {
        return "6 3\n" +
                "5 1\n" +
                "2 1\n" +
                "1 1\n" +
                "8 1\n" +
                "10 0\n" +
                "5 0\n"; //expected: 29
    }

//    static String input() {
//        return "8 5\n" +
//                "13 1\n" +
//                "10 1\n" +
//                "9 1\n" +
//                "8 1\n" +
//                "13 1\n" +
//                "12 1\n" +
//                "18 1\n" +
//                "13 1\n"; //expected: 42
//    }
}
