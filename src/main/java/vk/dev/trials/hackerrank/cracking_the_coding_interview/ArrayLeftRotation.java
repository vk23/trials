package vk.dev.trials.hackerrank.cracking_the_coding_interview;

import java.util.Arrays;

public class ArrayLeftRotation {

    private static int[] rotLeft(int[] arr, int offset) {
        int size = arr.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int index = (i + offset) % size;
            result[i] = arr[index];
        }

        return result;
    }

    public static void main(String[] args) {

        int offset = 4;
        int[] arr = {1, 2, 3, 4, 5};

        int[] result = rotLeft(arr, offset);
        System.out.println(Arrays.toString(result));
    }
}
