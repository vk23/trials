package vk.dev.trials.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * JavaStack_BalancedParenthesis.
 *
 * @author vladimir_kuragin
 */
public class JavaStack_BalancedParenthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {

                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                Character peek = stack.peek();
                if (balanced(peek, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            System.out.println(stack.isEmpty());
        }

        sc.close();
    }

    private static boolean balanced(Character left, Character right) {
        return (left.equals('[') && right.equals(']'))
                || (left.equals('(') && right.equals(')'))
                || (left.equals('{') && right.equals('}'));
    }
}
