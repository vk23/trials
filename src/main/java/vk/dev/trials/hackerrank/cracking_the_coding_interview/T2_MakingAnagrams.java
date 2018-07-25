package vk.dev.trials.hackerrank.cracking_the_coding_interview;

public class T2_MakingAnagrams {

    static int makeAnagram(String a, String b) {
        StringBuilder aNew = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            String c = a.substring(i, i + 1);
            if (b.contains(c)) {
                b = b.replaceFirst(c, "");
            } else {
                aNew = aNew.append(c);
            }
        }
        return aNew.length() + b.length();
    }

    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        int result = makeAnagram(a, b);
        System.out.println(result);
    }
}
