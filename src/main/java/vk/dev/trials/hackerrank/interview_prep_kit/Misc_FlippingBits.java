package vk.dev.trials.hackerrank.interview_prep_kit;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Misc_FlippingBits.
 *
 * @author Vladimir_Kuragin
 */
public class Misc_FlippingBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            System.out.printf("%d%n", flipBits(x));
        }
        sc.close();
    }

    private static long flipBits(long x) {
        int[] bits = new int[32];
        Arrays.fill(bits, 1);
        int i = 32;
        while (x > 0) {
            int rem = (int) (x % 2);
            bits[--i] =rem == 0 ? 1 : 0;
            x = x >> 1;
        }
        System.out.println(join(bits));
        return Long.parseLong(join(bits), 2);
    }

    private static String join(int[] a) {
        return Arrays.stream(a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    private static String input() {
        return "2\n" +
                "4\n" +
                "123456\n"; // expected: 4294967291 4294843839
    }
}
