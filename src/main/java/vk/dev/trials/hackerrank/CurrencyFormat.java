package vk.dev.trials.hackerrank;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * CurrencyFormat.
 *
 * @author Vladimir_Kuragin
 */
public class CurrencyFormat {

    public static void main(String[] args) {
        double amount = 12324.134;
        String result = format(amount);
        System.out.println(result);
    }

    private static String format(double amount) {
        return String.format("%s%n%s%n%s%n%s%n%s%n",
                NumberFormat.getCurrencyInstance(Locale.forLanguageTag("ru-RU")).format(amount),
                NumberFormat.getCurrencyInstance(Locale.US).format(amount),
                NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-In")).format(amount),
                NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount),
                NumberFormat.getCurrencyInstance(Locale.FRANCE).format(amount)
        );
    }
}
