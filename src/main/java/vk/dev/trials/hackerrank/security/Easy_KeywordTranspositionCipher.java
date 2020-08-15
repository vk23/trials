package vk.dev.trials.hackerrank.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Easy_KeywordTranspositionCipher.
 *
 * @author vladimir_kuragin
 */
public class Easy_KeywordTranspositionCipher {

    private static final List<String> ABC = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));

    public static void main(String[] args) {
        final String keyword = keyword();
        final String encrypted = input();

        String decrypted = decrypt(keyword, encrypted);
        System.out.printf("%nRESULT:%n[%s] == [%s] = %b%n", decrypted, expectedResult(), expectedResult().equals(decrypted));
    }

    private static String decrypt(String keyword, String encrypted) {
        // get unique set of letters from the keyword (insert order matters)
        Set<String> set = new LinkedHashSet<>();
        for (char c : keyword.toCharArray()) {
            set.add(String.valueOf(c));
        }
        int cols = set.size();

        // populate crypto alphabet
        List<String> cryptoAlphabet = new ArrayList<>(ABC);
        cryptoAlphabet.removeAll(set);
        cryptoAlphabet.addAll(0, set);
        // TODO: re-arrange alphabet according to natural order of the keyword letters
        // TODO: transpose matrix

        // TODO: decrypt using the crypto alphabet
        String decrypted = "";

        System.out.println("set=" + set.toString());
        System.out.println("cryptoAlphabet=" + cryptoAlphabet.toString());

        return decrypted;
    }


    // ----------------------
    // TEST DATA

    private static String input() {
        return "LDXTW KXDTL NBSFX BFOII LNBHG ODDWN BWK";
    }

    private static String keyword() {
        return "SPORT";
    }

    private static String expectedResult() {
        return "ILOVE SOLVI NGPRO GRAMM INGCH ALLEN GES";
    }

}
