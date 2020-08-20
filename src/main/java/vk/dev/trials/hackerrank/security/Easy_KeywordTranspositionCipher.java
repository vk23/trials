package vk.dev.trials.hackerrank.security;

import java.util.*;

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

        // re-arrange alphabet according to natural order of the keyword letters
        String[] sorted = new TreeSet<>(set).toArray(new String[set.size()]);
        int i = 0;
        int[] positions = new int[set.size()];
        for (String s : set) {
            for (int j = 0; j < sorted.length; j++) {
                if (s.equalsIgnoreCase(sorted[j])) {
                    positions[i++] = j;
                    break;
                }
            }
        }

        System.out.println("set=" + set.toString());
        System.out.println("cryptoAlphabet=" + cryptoAlphabet.toString());
        System.out.println("positions=" + Arrays.toString(positions));

        int rows = cryptoAlphabet.size() / cols;
        if (cryptoAlphabet.size() % cols > 0) {
            rows++;
        }
        String[][] matrix = new String[rows][cols];
        int k = 0;
        for (int r = 0; r < cryptoAlphabet.size(); r = ++k * cols) {
            for (int c = 0; c < cols && r + c < cryptoAlphabet.size(); c++) {
                String letter = cryptoAlphabet.get(r + c);
                int pos = positions[c];
                matrix[k][pos] = letter;
            }
            System.out.println(Arrays.toString(matrix[k]));
        }

        // transpose matrix
        List<String> cryptoAlphabetComplete = new ArrayList<>(cryptoAlphabet.size());
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                String s = matrix[r][c];
                if (s == null || "".equalsIgnoreCase(s.trim())) {
                    continue;
                }
                cryptoAlphabetComplete.add(s);
            }
        }
        System.out.println("cryptoAlphabetComplete=" + cryptoAlphabetComplete);

        // map crypto to normal alphabet
        Map<String, String> map = new HashMap<>();
        for (int j = 0; j < ABC.size(); j++) {
            map.put(cryptoAlphabetComplete.get(j), ABC.get(j));
        }
        map.put(" ", " ");

        // decrypt using the crypto alphabet
        String[] encryptedLetters = encrypted.split("");
        String decrypted = Arrays.stream(encryptedLetters)
                .map(map::get)
                .reduce("", String::concat);

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
