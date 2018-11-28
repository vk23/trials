package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Locale;
import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.inverse;
import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.matrixToString;
import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.multiply;
import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.transpose;

/**
 * Day9_MultipleLinearRegression.
 * Y = X * B => B = ((XT*X)^-1)*XT*Y -- T - transposition, ^-1 - inversion.
 *
 * @author Vladimir_Kuragin
 */
public class Day9_MultipleLinearRegression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        sc.useLocale(Locale.US);
        int m = sc.nextInt();
        int n = sc.nextInt();
        double[][] Y = new double[n][1];
        double[][] F = new double[n][m + 1];
        for (int i = 0; i < n; i++) {
            F[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                F[i][j] = sc.nextDouble();
            }
            Y[i][0] = sc.nextDouble();
        }
        int q = sc.nextInt();
        double[][] F2 = new double[q][m + 1];
        for (int i = 0; i < q; i++) {
            F2[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                F2[i][j] = sc.nextDouble();
            }
        }
        sc.close();

        double[][] FTF = multiply(transpose(F), F);
        double[][] invFTF = inverse(FTF);
        double[][] FTY = multiply(transpose(F), Y);
        double[][] B = multiply(invFTF, FTY);
        System.out.println(matrixToString(B, 3));

        double[][] F2B = multiply(F2, B);
        System.out.println(matrixToString(F2B, 2));
    }

    private static String input() {
        return "2 7\n" +
                "0.18 0.89 109.85\n" +
                "1.0 0.26 155.72\n" +
                "0.92 0.11 137.66\n" +
                "0.07 0.37 76.17\n" +
                "0.85 0.16 139.75\n" +
                "0.99 0.41 162.6\n" +
                "0.87 0.47 151.77\n" +
                "4\n" +
                "0.49 0.18\n" +
                "0.57 0.83\n" +
                "0.56 0.64\n" +
                "0.76 0.18\n";
    }
}
