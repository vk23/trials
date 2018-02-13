package vk.dev.trials.hackerrank.algorithms.strings;

import java.util.*;

/**
 * Med1_SherlockAndTheValidString.
 *
 * @author vk
 * @since 12.02.2018
 */
public class Med1_SherlockAndTheValidString {

    static String isValid(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (Character c : s.toCharArray()) {
            charCounts.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        System.out.println(charCounts);

        Map<Integer, Integer> countsOfCounts = new HashMap<>();
        for (Integer i:charCounts.values()) {
            countsOfCounts.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        System.out.println(countsOfCounts);

        Integer[] countKeys = countsOfCounts.keySet().toArray(new Integer[0]);

        // all chars equally distributed
        if (countKeys.length == 1) {
            return "YES";
        }

        // only one deviation is possible
        if (countKeys.length > 2) {
            return "NO";
        }

        Integer c0 = countsOfCounts.get(countKeys[0]);
        Integer c1 = countsOfCounts.get(countKeys[1]);

        // only one deviation is possible
        if (c0 != 1 && c1 != 1) {
            return "NO";
        }

        int deviate = 0, normal = 0;
        if (c0 == 1) {
            deviate = countKeys[0];
            normal = countKeys[1];
        } else {
            deviate = countKeys[1];
            normal = countKeys[0];
        }
        // deviate must be either 1 or normal+1
        return deviate == 1 || normal == deviate - 1
                ? "YES"
                : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
