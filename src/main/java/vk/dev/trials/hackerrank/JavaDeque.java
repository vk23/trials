package vk.dev.trials.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

/**
 * JavaDeque.
 *
 * @author vladimir_kuragin
 */
public class JavaDeque {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        HashSet hashSet = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();

        long start = System.currentTimeMillis();
        int maxUnique = 0;
        int num = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            deque.addFirst(num);
            hashSet.add(num);
            if (deque.size() > m) {
                Object last = deque.removeLast();
                if (!deque.contains(last)) {
                    hashSet.remove(last);
                }
                maxUnique = Math.max(maxUnique, hashSet.size());
                if (maxUnique == m) {
                    break;
                }
            }
        }
        in.close();

        hashSet.add(num);
        maxUnique = Math.max(maxUnique, hashSet.size());

        System.out.println(maxUnique);
        long finish = System.currentTimeMillis();
        System.out.println("time: " + (finish - start) + " ms.");
    }
}
