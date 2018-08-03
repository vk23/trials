package vk.dev.trials.hackerrank.algorithms.implementation;

/**
 * Easy13_MinimumDistances.
 *
 * @author Vladimir_Kuragin
 */
public class Easy13_MinimumDistances {

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 4, 1, 7};
        int result = minimumDistances(arr);
        System.out.println(result);
    }

    static int minimumDistances(int[] arr) {
        int min = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            int left = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[left]) {
                    min = min > j - left ? j - left : min;
                    left = j;
                }
            }
        }
        return min == arr.length ? -1 : min;
    }

}
