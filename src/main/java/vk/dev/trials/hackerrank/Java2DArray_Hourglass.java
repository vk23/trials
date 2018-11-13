package vk.dev.trials.hackerrank;

import java.util.Scanner;

/**
 * Java2DArray_Hourglass.
 *
 * @author vladimir_kuragin
 */
public class Java2DArray_Hourglass {

    private static final Scanner scanner = new Scanner(data());

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < 6 - 2; i++) {
            for (int j = 0; j < 6 - 2; j++) {
                int cur = calcHourglass(arr, i, j);
                sum = Math.max(sum, cur);
            }
        }

        System.out.println(sum);
        scanner.close();
    }

    private static int calcHourglass(int[][] arr, int x, int y) {
        int sum = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (i == x + 1 && (j == y || j == y + 2)) {
//                    System.out.println("skip:" + i + "," + j + "=" + arr[i][j]);
                    continue;
                }
                sum += arr[i][j];
            }
        }
        return sum;
    }

    private static String data() {
        return "-1 -1 0 -9 -2 -2\n" +
                "-2 -1 -6 -8 -2 -5\n" +
                "-1 -1 -1 -2 -3 -4\n" +
                "-1 -9 -2 -4 -4 -5\n" +
                "-7 -3 -3 -2 -9 -9\n" +
                "-1 -3 -1 -2 -4 -5\n";
    }
}