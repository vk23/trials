package vk.dev.trials.hackerrank;


import java.util.TreeSet;

/**
 * SubstringComparisons.
 *
 * @author Vladimir_Kuragin
 */
public class SubstringComparisons {

    public static String getSmallestAndLargestUsingTree(String str, int n) {
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < str.length() - n + 1; i++) {
            String sub = str.substring(i, i + n);
            set.add(sub);
        }
        return set.first() + "\n" + set.last();
    }

    public static String getSmallestAndLargest(String str, int n) {
        String smallest = str.substring(0, n);
        String largest = str.substring(0, n);
        for (int i = 1; i < str.length() - n + 1; i++) {
            String sub = str.substring(i, i + n);
            if (sub.compareTo(smallest) < 0) {
                smallest = sub;
            }
            if (sub.compareTo(largest) > 0 ) {
                largest = sub;
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        String str = "welcometojava";
        int n = 3;
        String result = getSmallestAndLargest(str, n);
        String result2 = getSmallestAndLargestUsingTree(str, n);
        System.out.println(result);
        System.out.println("===================================");
        System.out.println(result2);
    }
}
