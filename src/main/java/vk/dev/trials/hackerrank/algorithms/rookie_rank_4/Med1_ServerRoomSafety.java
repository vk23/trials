package vk.dev.trials.hackerrank.algorithms.rookie_rank_4;

import java.util.Scanner;

/**
 * Med1_ServerRoomSafety.
 *
 * @author vk
 * @since 16.02.2018
 */
public class Med1_ServerRoomSafety {

    static String checkAll(int n, int[] height, int[] position) {
        // find leftMost and rightMost racks
        int leftMost = -1, rightMost = -1;
        for (int i = 0; i < n; i++) {
            if (leftMost < 0 && height[i] > 0) {
                leftMost = i;
            }
            if (height[i] > 0) {
                rightMost = i;
            }
        }
        if (leftMost < 0 || rightMost < 0) {
            return "NONE";
        }
        if (leftMost == rightMost) {
            return "BOTH";
        }

        boolean left = true, right = true;

        int prev = leftMost;
        for (int i = leftMost + 1; i <= rightMost; i++) {
            int fromPrev = position[i] - position[prev];
            if (height[prev] < fromPrev) {
                left = false;
                break;
            }
            if (height[i] > 0) {
                prev = height[prev] > height[i] + fromPrev
                        ? prev
                        : i;
            }
        }

        prev = rightMost;
        for (int i = rightMost - 1; i >= leftMost; i--) {
            int fromPrev = position[prev] - position[i];
            if (height[prev] < fromPrev) {
                right = false;
                break;
            }
            if (height[i] > 0) {
                prev = height[prev] > height[i] + fromPrev
                        ? prev
                        : i;
            }
        }

        if (left && right) return "BOTH";
        if (left) return "LEFT";
        if (right) return "RIGHT";
        return "NONE";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] position = new int[n];
        for (int position_i = 0; position_i < n; position_i++) {
            position[position_i] = in.nextInt();
        }
        int[] height = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            height[height_i] = in.nextInt();
        }
        String ret = checkAll(n, height, position);
        System.out.println(ret);
        in.close();
    }
}
