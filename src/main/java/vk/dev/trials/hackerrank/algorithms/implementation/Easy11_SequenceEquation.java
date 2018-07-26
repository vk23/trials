package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.Arrays;

/**
 * Easy11_SequenceEquation.
 *
 * @author Vladimir_Kuragin
 */
public class Easy11_SequenceEquation {

    // Complete the permutationEquation function below.
    static Integer[] permutationEquation(Integer[] a) {
        Integer[] result = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            int index1 = find(a, i + 1);
            int index2 = find(a, index1 + 1);
            result[i] = index2 + 1;
        }
        return result;
    }

    private static int find(Integer[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(x)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer[] p = {2, 3, 1};
        Integer[] result = permutationEquation(p);
        System.out.println(Arrays.asList(result));
    }
}
