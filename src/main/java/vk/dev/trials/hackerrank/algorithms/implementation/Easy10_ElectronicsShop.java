package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.TreeSet;

/**
 * Easy10_ElectronicsShop.
 *
 * @author Vladimir_Kuragin
 */
public class Easy10_ElectronicsShop {

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                if (drive + keyboard <= b) {
                    set.add(drive + keyboard);
                }
            }
        }

        return set.isEmpty() ? -1 : set.last();
    }

    public static void main(String[] args) {
        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */
        int[] keyboards = {3, 1};
        int[] drives = {5, 2, 8};
        int budget = 10;
        int moneySpent = getMoneySpent(keyboards, drives, budget);
        System.out.println(moneySpent);
    }
}
