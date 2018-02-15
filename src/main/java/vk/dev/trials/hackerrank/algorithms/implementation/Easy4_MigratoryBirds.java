package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.*;

/**
 * Easy4_MigratoryBirds.
 *
 * @author vk
 * @since 15.02.2018
 */
public class Easy4_MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : ar) {
            map.merge(i, 1, Integer::sum);
        }
        Integer max = map.values()
                .stream()
                .reduce(Math::max)
                .orElseThrow(() -> new RuntimeException("No maximum found?"));

        return map.entrySet()
                .stream()
                .filter(entry -> max.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("No minimum found?"));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
