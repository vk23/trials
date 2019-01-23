package vk.dev.trials.other;

/**
 * FindPatternsInString.
 *
 * @author Vladimir_Kuragin
 */
public class FindPatternsInString {

    public static void main(String[] args) {
        String text = text();
        String pattern = pattern();
        int count1 = countUsingIndexOf(text, pattern);
        System.out.printf("Count using index of = %d%n", count1);

        int count2 = countUsingArray(text, pattern);
        System.out.printf("Count using array = %d%n", count2);
    }

    private static int countUsingArray(String text, String pattern) {
        int count = 0;
        int index = 0;
        char[] chars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();

        while (index < chars.length) {
            char c = chars[index];
            if (c == patternChars[0]) {
                int i = checkPatternFromIndex(index, chars, patternChars);
                if (i == patternChars.length) {
                    count++;
                    index += i;
                    continue;
                }
            }
            index++;
        }
        return count;
    }

    private static int checkPatternFromIndex(int index, char[] chars, char[] patternChars) {
        char c;
        int i = 1;
        while (i < patternChars.length && index + i < chars.length) {
            c = chars[index + i];
            if (c == patternChars[i]) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }

    private static int countUsingIndexOf(String text, String pattern) {
        int count = 0;
        int index = 0;
        while (true) {
            index = text.indexOf(pattern, index);
            if (index >= 0) {
                count++;
                index++;
            } else {
                break;
            }
        }
        return count;
    }

    private static String pattern() {
        return "aabc";
    }

    private static String text() {
        return "aabc aabdc bcbaaabc bcx;.bc bvbcvbaabc. aaaaabc, abc \n" +
                "bbc; a\n" +
                "abc. aaabc"; // expected: 5
    }
}
