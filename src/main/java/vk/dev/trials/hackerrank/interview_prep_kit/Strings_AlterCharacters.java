package vk.dev.trials.hackerrank.interview_prep_kit;

import java.util.Scanner;

/**
 * Strings_AlterCharacters.
 *
 * @author Vladimir_Kuragin
 */
public class Strings_AlterCharacters {

    static int alternatingCharacters(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            System.out.println(alternatingCharacters(sc.nextLine().trim()));
        }
        sc.close();
    }

    static String input() {
        return "5\n" +
                "AAAA\n" +
                "BBBBB\n" +
                "ABABABAB\n" +
                "BABABA\n" +
                "AAABBB\n"
                ;
    }
}
