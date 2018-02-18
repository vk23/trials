package vk.dev.trials.hackerrank.algorithms.rookie_rank_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Med2_HeightOfBST.
 *
 * @author vk
 * @since 17.02.2018
 */
public class Med2_HeightOfBST {
    private static Map<Integer, Integer> sums = new HashMap<>();

    static class TreeNode<T extends Comparable<T>> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;
    }

    static int[] heightAndTotalHeight(int[] arr) {
        if (arr.length == 1) {
            return new int[]{0, 0};
        }
        TreeNode<Integer> root = buildTree(arr);

        int rootHeight = height(root);
        Integer sum = sums.values().stream().reduce(Integer::sum).orElse(0);
        return new int[]{rootHeight, sum};
    }


    private static int height(TreeNode<Integer> node) {
        int leftHeight = node.left == null ? 0 : height(node.left) + 1;
        int rightHeight = node.right == null ? 0 : height(node.right) + 1;
        int max = Math.max(leftHeight, rightHeight);
        sums.put(node.value, max);
        return max;
    }

    private static TreeNode<Integer> buildTree(int[] arr) {
        TreeNode<Integer> root = new TreeNode<>();
        root.value = arr[0];
        for (int i = 1; i < arr.length; i++) {
            put(root, arr[i]);
        }
        return root;
    }

    private static void put(TreeNode<Integer> node, Integer value) {
        if (node.value.equals(value)) {
            return;
        }
        if (node.value > value) {
            if (node.left == null) {
                node.left = new TreeNode<>();
                node.left.value = value;
            } else {
                put(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode<>();
                node.right.value = value;
            } else {
                put(node.right, value);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arrSize = Integer.parseInt(scan.nextLine().trim());
        int[] arr = new int[arrSize];

        String[] arrItems = scan.nextLine().split(" ");
        for (int arrItr = 0; arrItr < arrSize; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;

        }

        int[] result = heightAndTotalHeight(arr);
        System.out.println(Arrays.toString(result));
    }
}
