package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Easy7_DrawingBook.
 *
 * @author vk
 * @since 09.07.2018
 */
public class Easy7_DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        boolean firstHalf = n >> 1 >= p;
//        System.out.printf("%d >= %d - %b%n", n>>1, p, firstHalf);
        if (firstHalf) {
            return p >> 1;
        } else {
            int offset = n % 2 == 0 ? 1 : 0;
            return (n - p + offset) >> 1;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        int result = pageCount(n, p);
        System.out.println(result);

        scanner.close();
    }
}
