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
        Map<Character, Integer> counts = new HashMap<>();
        for (Character c : s.toCharArray()) {
            counts.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        System.out.println(counts);

        boolean foundOne = false;

        Integer[] values = counts.values().toArray(new Integer[0]);
        int freq = values[0];
        int deviant = values[0];
        for (int i = 1; i < values.length; i++) {
            if (freq == values[i]) {
                continue;
            }
            if (foundOne) {
                return "NO";
            }

            foundOne = true;
            if (i + 1 < values.length) {
                if (values[i + 1] == freq) {
                    freq = freq;
                    deviant = values[i];
                } else {
                    freq = values[i];
                    deviant = values[i - 1];
                }
            } else {

            }
        }

        if (foundOne) {
            System.out.println(deviant);
            if (deviant == 1 || deviant == freq + 1) {
                return "YES";
            } else {
                return "NO";
            }

        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
