package vk.dev.trials.hackerrank.ten_days_of_statistics;

import java.util.Arrays;
import java.util.List;

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
//        System.out.printf("erf for z=%.3f, x=%.3f : --> %.3f%n", z, x, result);
        return sign * result;
    }
}
