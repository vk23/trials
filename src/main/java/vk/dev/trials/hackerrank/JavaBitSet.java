package vk.dev.trials.hackerrank;


import java.util.BitSet;
import java.util.Scanner;

/**
 * JavaBitSet.
 *
 * @author Vladimir_Kuragin
 */
public class JavaBitSet {

    static class BitSets {
        private BitSet b1;
        private BitSet b2;

        public BitSets(int N) {
            b1 = new BitSet(N);
            b2 = new BitSet(N);
        }

        public BitSet set(int i) {
            return i == 1 ? b1 : b2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        BitSets bitSets = new BitSets(N);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            String command = sc.next();
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            BitSet left = null;
            BitSet right = null;
            switch (command) {
                case "SET":
                    left = bitSets.set(num1);
                    left.set(num2);
                    break;
                case "FLIP":
                    left = bitSets.set(num1);
                    left.flip(num2);
                    break;
                case "AND":
                    left = bitSets.set(num1);
                    right = bitSets.set(num2);
                    left.and(right);
                    break;
                case "OR":
                    left = bitSets.set(num1);
                    right = bitSets.set(num2);
                    left.or(right);
                    break;
                case "XOR":
                    left = bitSets.set(num1);
                    right = bitSets.set(num2);
                    left.xor(right);
                    break;
                default:
                    System.out.println("default");
                    break;
            }

            System.out.println(bitSets.set(1).cardinality() + " " + bitSets.set(2).cardinality());
        }

        sc.close();
    }
}
