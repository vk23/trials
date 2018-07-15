package vk.dev.trials.hackerrank.algorithms.implementation;


/**
 * Easy8_CountingValleys.
 *
 * @author vk
 * @since 14.09.2018
 */
public class Easy8_CountingValleys {

    static int countingValleys(int n, String s) {
        int result = 0;

        int level = 0;
        for (char c : s.toCharArray()) {
            if (c == 'D') {
                level--;
                continue;
            }
            level++;
            if (level == 0) {
                result++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int n = 8;
        String s = "UDDDUDUU";

        int result = countingValleys(n, s);
        System.out.printf("result = %d%n", result);
    }

}
