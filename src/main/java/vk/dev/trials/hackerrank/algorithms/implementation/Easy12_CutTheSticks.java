package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy12_CutTheSticks.
 *
 * @author Vladimir_Kuragin
 */
public class Easy12_CutTheSticks {

    static List<Integer> cutTheSticks(int[] arr) {

        List<Integer> result = new ArrayList<>();
        result.add(arr.length);
        int min;
        while (true) {
            min = findMin(arr);
            if (min < 0) {
                break;
            }
            arr = cut(min, arr);
            result.add(arr.length);
        }
        return result;
    }

    private static int[] cut(int min, int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : arr) {
            if (i > min) {
                result.add(i - min);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int findMin(int[] arr) {
        int result = arr[0];
        boolean allEqual = true;
        for (int i : arr) {
            if (allEqual && i != result) {
                allEqual = false;
            }
            if (i < result) {
                result = i;
            }
        }

        return allEqual ? -1 : result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 3, 2, 1};
        List<Integer> result = cutTheSticks(arr);
        System.out.println(result);
    }
}
