package vk.dev.trials.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Easy1_CamelCase.
 *
 * @author vk
 * @since 10.02.2018
 */
public class Easy1_CamelCase {

    static int camelcase(String s) {
        return s.split("[A-Z]").length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}
