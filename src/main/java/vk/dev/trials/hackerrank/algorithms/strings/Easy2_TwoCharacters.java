package vk.dev.trials.hackerrank.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Easy2_TwoCharacters.
 *
 * @author vk
 * @since 10.02.2018
 */
public class Easy2_TwoCharacters {

    static int twoCharacters(String s) {
        if (s.length() < 2) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Set<Character> letters = new HashSet<>();
        for (char c : chars) {
            letters.add(c);
        }

        int result = 0;
        for (Character x : letters) {
            for (Character y : letters) {
                if (x.equals(y)) continue;
                Character prev = null;
                int sum = 0;
//                String tmp = "";
                for (int i = 0; i < chars.length; i++) {
                    Character c = chars[i];
                    if (c.equals(x) || c.equals(y)) {
                        if (c.equals(prev)) {
                            sum = 0;
                            break;
                        } else {
                            prev = c;
                            sum++;
//                            tmp += c;
                        }
                    }
                }
//                System.out.format("x=%s, y=%s, string=%s, length=%d%n", x, y, tmp, sum);
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = twoCharacters(s);
        System.out.println(result);
        in.close();
    }
}
