package vk.dev.trials.hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * Medium1_ColumnEncryption.
 *
 * @author vladimir_kuragin
 */
public class Medium1_ColumnEncryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.trim();

        // compute dimensions
        int len = s.length();
        int sqrt = Double.valueOf(Math.sqrt(len)).intValue();
        int rows = sqrt, cols = sqrt;

        boolean rowInced = true;
        while (rows * cols < len) {
            if (rowInced) {
                cols++;
            } else {
                rows++;
            }
            rowInced = !rowInced;
        }
        System.out.printf("rows=%d, cols=%d%n", rows, cols);

        // encrypt
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int ind = i + j * cols;
                if (ind >= len) {
                    break;
                }
                sb.append(s.charAt(ind));
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private static final Scanner scanner = new Scanner(input());

    private static String input() {
        return "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots";
//        return "chillout";
    }

    private static String expectedOutput() {
        return "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau";
//        return "clu hlt io";
    }

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();
        String encrypted = encryption(s);
        System.out.println("encrypted: " + encrypted);
        System.out.println("expected == result: " + expectedOutput().equals(encrypted));
        scanner.close();
    }
}

