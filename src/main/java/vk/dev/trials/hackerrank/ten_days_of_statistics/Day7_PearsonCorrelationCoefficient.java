package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Scanner;

import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.mean;
import static vk.dev.trials.hackerrank.ten_days_of_statistics.Util.standardDeviation;

/**
 * Day7_PearsonCorrelationCoefficient.
 *
 * @author Vladimir_Kuragin
 */
public class Day7_PearsonCorrelationCoefficient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(input());
        int n = sc.nextInt();
        double[] X = new double[n];
        double[] Y = new double[n];
        for (int i = 0; i < n; i++) {
            X[i] = Double.parseDouble(sc.next());
        }
        for (int i = 0; i < n; i++) {
            Y[i] = Double.parseDouble(sc.next());
        }
        sc.close();

        double correlationCoeff = pearsonsCorrelationCoeff(n, X, Y);
        System.out.printf("%.3f%n", correlationCoeff);
    }

    private static double pearsonsCorrelationCoeff(int n, double[] X, double[] Y) {
        double meanX = mean(X);
        double sigmaX = standardDeviation(X, meanX);
        double meanY = mean(Y);
        double sigmaY = standardDeviation(Y, meanY);

        double denominator = n * sigmaX * sigmaY;
        double numerator = 0; // covariance of X and Y
        for (int i = 0; i < n; i++) {
            numerator += (X[i] - meanX) * (Y[i] - meanY);
        }
        return numerator/denominator;
    }

    private static String input() {
        return "10\n" +
                "10 9.8 8 7.8 7.7 7 6 5 4 2 \n" +
                "200 44 32 24 22 17 15 12 8 4\n";
    }
}
