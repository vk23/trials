package vk.dev.trials.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Task10.
 *
 * @author vk
 * @since 05.02.2018
 */
public class Task10 {

    // solution goes here
    static String timeConversion(String s) {
        String str = s.trim();
        boolean pm = isPM(str);

        String time = str.substring(0, str.length() - 2);
        String hoursStr = time.substring(0, time.indexOf(":"));
        String timeWithoutHours = time.substring(time.indexOf(":"));

        int hours = Integer.parseInt(hoursStr);
        boolean twelve = hours == 12;
        if (pm) {
            hours = twelve ? 12 : hours + 12;
        } else {
            hours = twelve ? 0 : hours;
        }
        return String.format("%02d", hours) + timeWithoutHours;
    }

    static boolean isPM(String s) {
        assert s != null : "Cannot be null";

        String lowerCase = s.toLowerCase();
        if (lowerCase.endsWith("am")) {
            return false;
        } else if (lowerCase.endsWith("pm")) {
            return true;
        } else {
            throw new IllegalArgumentException("Unknown date format");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }

}
