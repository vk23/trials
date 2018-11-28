package vk.dev.trials.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * JavaArrayLeap.
 *
 * @author vladimir_kuragin
 */
public class JavaArrayLeap {

    public static boolean canWin(int leap, int[] game) {
        return canWin(leap, game, 0);
    }

    private static boolean canWin(int leap, int[] game, int index) {
        if (index < 0 || game[index] == 1) {
            return false;
        }

        if (index + 1 > game.length - 1 || index + leap > game.length - 1) {
            return true;
        }

        game[index] = 1;

        return canWin(leap, game, index + 1)
                || canWin(leap, game, index + leap)
                || canWin(leap, game, index - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(input());
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println(q + " -- " + n + "-" + leap + ":" + Arrays.toString(game));
            String answer = (canWin(leap, game)) ? "YES" : "NO";
            System.out.println(q + " -- " + n + "-" + leap + ":" + Arrays.toString(game));
            System.out.println(q + " -- " + answer);

        }
        scan.close();
    }

    private static String input() {
        return "4\n" +
                "6 2\n" +
                "0 1 0 1 0 1\n" +
                "10 6\n" +
                "0 0 1 1 0 0 1 1 0 0\n" +
                "10 3\n" +
                "0 0 1 1 0 0 1 1 0 0\n" +
                "9 4\n" +
                "0 1 1 0 0 1 1 0 1\n";
    }


}
