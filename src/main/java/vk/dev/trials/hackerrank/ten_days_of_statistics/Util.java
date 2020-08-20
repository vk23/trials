package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;

/**
 * Util.
 *
 * @author vladimir_kuragin
 */
public class Util {

    public static double mean(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (sum * 1.0) / arr.length;
    }

    public static double mean(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (sum * 1.0) / arr.length;
    }

    public static double median(int[] arr, int left, int right) {
        int mid = (right + 1 - left) / 2 + left;
        return ((right + 1 - left) % 2 == 0)
                ? (arr[mid - 1] + arr[mid]) / 2.0
                : arr[mid];
    }

    public static double calcMedianNotSorted(int[] arr, int from, int to) {
        Arrays.sort(arr);
        return median(arr, from, to);
    }

    public static double standardDeviation(int[] arr, double mean) {
        double sumOfSquaredDistances = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfSquaredDistances += Math.pow(arr[i] - mean, 2.0);
        }
        return Math.sqrt(sumOfSquaredDistances / arr.length);
    }

    public static double standardDeviation(double[] arr, double mean) {
        double sumOfSquaredDistances = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfSquaredDistances += Math.pow(arr[i] - mean, 2.0);
        }
        return Math.sqrt(sumOfSquaredDistances / arr.length);
    }

    public static int[] convert(List<Integer> integers) {
        int[] res = new int[integers.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = integers.get(i);
        }
        return res;
    }

    public static int[] convert(Integer[] integers) {
        int[] res = new int[integers.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = integers[i];
        }
        return res;
    }

    public static long factorial(long x) {
        if (x <= 1) {
            return 1;
        }
        return x * factorial(x - 1);
    }

    public static double erf(double z) {
        return erf(z, 1000);
    }

    public static double erf(double z, int numOfIntegrationSteps) {
        int sign = z < 0 ? -1 : 1;
        z = Math.abs(z);
        double dx = z / numOfIntegrationSteps;
        double xi = 0;
        double integral = 0;
        while (xi < z) {
            double pow = -(xi * xi);
            integral += Math.exp(pow) * dx;
            xi += dx;
        }
        double result = (2 / Math.sqrt(Math.PI)) * integral;
        return sign * result;
    }

    public static String matrixToString(double[][] x, int decimals) {
        if (x == null || x.length == 0) {
            return "Empty matrix";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                sb.append(String.format("%." + decimals + "f ", x[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static double[][] transpose(double[][] x) {
        if (x == null || x.length == 0) {
            return x;
        }

        int xHeight = x.length;
        int xWidth = x[0].length;

        double[][] res = new double[xWidth][xHeight];
        for (int i = 0; i < xHeight; i++) {
            for (int j = 0; j < xWidth; j++) {
                res[j][i] = x[i][j];
            }
        }
        return res;
    }

    public static int[][] transpose(int[][] x) {
        if (x == null || x.length == 0) {
            return x;
        }

        int xHeight = x.length;
        int xWidth = x[0].length;

        int[][] res = new int[xWidth][xHeight];
        for (int i = 0; i < xHeight; i++) {
            for (int j = 0; j < xWidth; j++) {
                res[j][i] = x[i][j];
            }
        }
        return res;
    }


    public static double[][] multiply(double[][] x, double[][] y) {
        if (x == null || y == null) {
            return null;
        }
        if (x.length == 0 || y.length == 0) {
            return new double[0][0];
        }
        if (x[0].length != y.length) {
            throw new IllegalArgumentException("Matrices with incompatible dimensions. Expected AxN & NxB");
        }
        int n = x[0].length;
        double[][] res = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        return res;
    }

    /** found somewhere on the internet */
    public static double[][] inverse(double[][] X) {
        X = clone(X);
        for (int n = X.length, i = 0; i < n; i++) {
            double pivot = X[i][i];
            for (int j = 0; j < n; j++)
                X[j][i] /= -pivot;
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    if (i != j && i != k)
                        X[j][k] += X[j][i] * X[i][k];
            for (int j = 0; j < n; j++)
                X[i][j] /= pivot;
            X[i][i] = 1 / pivot;
        }
        return X;
    }

    static double[][] clone(double[][] X) {
        return Arrays.stream(X)
                .map(doubles -> copyOf(doubles, doubles.length))
                .toArray(double[][]::new);
    }

}
