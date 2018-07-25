package vk.dev.trials.hackerrank;


/**
 * Anagrams.
 *
 * @author Vladimir_Kuragin
 */
public class Anagrams {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        int size = a.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            String c = String.valueOf(a.charAt(i));
            if (b.contains(c)) {
                b = b.replaceFirst(c, "");
                count++;
            } else {
                break;
            }
        }
        return count == size;
    }

    public static void main(String[] args) {
        String a = "anagram";
        String b = "margana";

        String result = isAnagram(a, b)
                ? "Anagrams"
                : "Not Anagrams";
        System.out.println(result);
    }
}
