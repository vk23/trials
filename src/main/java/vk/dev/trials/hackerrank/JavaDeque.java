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
        int n = in.nextInt();
        int m = in.nextInt();

        long start = System.currentTimeMillis();
        int maxUnique = 0;
        int unique = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addFirst(num);
            if (deque.size() > m) {
                deque.removeLast();
                unique = new HashSet(deque).size();
                maxUnique = Math.max(maxUnique, unique);
                if (maxUnique == m) {
                    break;
                }
            }
        }

        unique = new HashSet(deque).size();
        maxUnique = Math.max(maxUnique, unique);

        System.out.println(maxUnique);
        long finish = System.currentTimeMillis();
        System.out.println("time: " + (finish - start) + " ms.");
    }
}
