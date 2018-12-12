package vk.dev.trials.hackerrank.interview_prep_kit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Greedy_Florist.
 *
 * @author Vladimir_Kuragin
 */
public class Greedy_Florist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int minimumCost = getMinimumCost(k, arr);
        System.out.println(minimumCost);
    }

    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);

        int sum = 0;
        int round = 1;

        for (int i = c.length - 1; i >= 0; i = i - k) {
            for (int j = 0; j < k && i - j >= 0; j++) {
                sum += c[i - j] * round;
            }
            round++;
        }
        return sum;
    }

//    static String input() {
//        return "5 3\n" +
//                "1 3 5 7 9\n"; //expected: 29
//    }

    static String input() {
        return "50 3\n" +
                "390225 426456 688267 800389 990107 439248 240638 15991 874479 568754 729927 980985 132244 488186 5037 721765 251885 28458 23710 281490 30935 897665 768945 337228 533277 959855 927447 941485 24242 684459 312855 716170 512600 608266 779912 950103 211756 665028 642996 262173 789020 932421 390745 433434 350262 463568 668809 305781 815771 550800\n"
                ; //expected: 163578911
    }

}
