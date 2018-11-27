package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Locale;
import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.mean;
import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.standardDeviation;

/**
 * Day8_LeastSquareRegressionLine.
 * The regression line is given by Y^ = a + bX.
 *
 * @author Vladimir_Kuragin
 */
public class Day8_LeastSquareRegressionLine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        sc.useLocale(Locale.US);
        int n = 5;
        double[] X = new double[n];
        double[] Y = new double[n];
        for (int i = 0; i < n; i++) {
            X[i] = sc.nextDouble();
            Y[i] = sc.nextDouble();
        }
        sc.close();

        double pearsonsCorrelationCoeff = Day7_PearsonCorrelationCoefficient.pearsonsCorrelationCoeff(n, X, Y);
        double meanX = mean(X);
        double meanY = mean(Y);
        double sigmaX = standardDeviation(X, meanX);
        double sigmaY = standardDeviation(Y, meanY);

        double b = pearsonsCorrelationCoeff * (sigmaY / sigmaX);
        double a = meanY - b * meanX;

        double res = a + b * 80;
        System.out.printf("%.3f%n", res);
    }

    private static String input() {
        return "95 85\n" +
                "85 95\n" +
                "80 70\n" +
                "70 65\n" +
                "60 70\n";
    }
}
