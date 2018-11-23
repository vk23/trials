package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * Day7_SpearmansRankCorrelationCoefficient.
 *
 * @author Vladimir_Kuragin
 */
public class Day7_SpearmansRankCorrelationCoefficient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        double[] X = new double[n];
        double[] Y = new double[n];
        for (int i = 0; i < n; i++) {
            X[i] = sc.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            Y[i] = sc.nextDouble();
        }
        sc.close();

        int[] rankX = rank(X);
        int[] rankY = rank(Y);
        System.out.printf("%s%n%s%n", Arrays.toString(rankX), Arrays.toString(rankY));

        double coeff = spearmansRankCorrelationCoeff(rankX, rankY);
        System.out.printf("%.3f%n", coeff);
    }

    private static double spearmansRankCorrelationCoeff(int[] rankX, int[] rankY) {
        int sum = 0;
        int n = rankX.length;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(rankX[i] - rankY[i], 2);
        }
        return 1 - ((6.0 * sum) / (n * (n*n - 1)));
    }

    private static String input() {
        return "10\n" +
                "10 9.8 8 7.8 7.7 1.7 6 5 1.4 2 \n" +
                "200 44 32 24 22 17 15 12 8 4\n";
    }

    private static int[] rank(double[] arr) {
        double[] tmp = new double[arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        Arrays.sort(tmp);
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            double v = arr[i];
            res[i] = position(tmp, v) + 1;
        }
        return res;
    }

    private static int position(double[] a, double v) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
