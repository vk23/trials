package vk.dev.trials.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Easy4_DayOfTheProgrammer.
 *
 * @author vk
 * @since 15.02.2018
 */
public class Easy4_DayOfTheProgrammer {

    private static final int TRANSITION_YEAR = 1918;
    private static final int REGULAR_FEB_DAYS = 28;
    private static final int TRANSITION_YEAR_SHIFT_DAYS = 13;

    static String solve(int year) {
        int daysInFeb = daysInFeb(year);
        int[] dayAndMonth = calcDayAndMonth(daysInFeb);
        return String.format("%02d.%02d.%d", dayAndMonth[0], dayAndMonth[1], year);
    }

    static int daysInFeb(int year) {
        if (year < TRANSITION_YEAR) {
            return year % 4 == 0
                    ? REGULAR_FEB_DAYS + 1
                    : REGULAR_FEB_DAYS;
        } else if (year > TRANSITION_YEAR) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)
                    ? REGULAR_FEB_DAYS + 1
                    : REGULAR_FEB_DAYS;
        } else {
            return REGULAR_FEB_DAYS - TRANSITION_YEAR_SHIFT_DAYS;
        }
    }

    static int[] calcDayAndMonth(int daysInFeb) {
        int day = 0;
        int month = 0;
        int currentMonthDays = 0;

        while (month < 12) {
            month++;

            // switch after august
            if (month >= 8) {
                currentMonthDays = month % 2 == 0 ? 31 : 30;
            } else {
                currentMonthDays = month % 2 == 0 ? 30 : 31;
            }
            // february
            if (month == 2) {
                currentMonthDays = daysInFeb;
            }
            day += currentMonthDays;

            if (day >= 256) {
                break;
            }
        }
        int dayOfMonth = currentMonthDays - (day - 256);
        return new int[]{dayOfMonth, month};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
