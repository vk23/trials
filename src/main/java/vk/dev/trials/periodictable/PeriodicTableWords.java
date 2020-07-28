package vk.dev.trials.periodictable;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PeriodicTableWords.
 *
 * @author vladimir_kuragin
 */
public class PeriodicTableWords {

    public static void main(String[] args) {

        Map<String, ChemicalElement> elements = new PeriodicTable().getElements();

        Arrays.asList("AmErICaN", "AcTiON", "BrUNCH", "Bebokazkscvckvsdf", "YUPPIEs", "SOCIOPaTh", "SiNGaPoRe", "NONAlCoHoLiC")
                .stream()
                .map(word -> compose(elements, word))
                .forEach(PeriodicTableWords::print);
    }

    private static void print(Pair<String, List<ChemicalElement>> pair) {
        boolean eq = eq(pair.getKey(), pair.getValue());
        System.out.printf("%20s == %-50s ---> %b%n",
                pair.getKey(),
                pair.getValue().stream().map(ChemicalElement::getSymbol).collect(Collectors.toList()).toString(),
                eq);
    }

    private static Pair<String, List<ChemicalElement>> compose(Map<String, ChemicalElement> elements, String word) {
        List<String> elementNames = elements.values()
                .stream()
                .map(ChemicalElement::getSymbol)
                .collect(Collectors.toList());

        List<String> found = findWord(elementNames, word, 0);
        Collections.reverse(found);
        List<ChemicalElement> foundElements = found.stream()
                .map(elements::get)
                .collect(Collectors.toList());

        return Pair.of(word, foundElements);
    }

    private static boolean eq(String word, List<ChemicalElement> elementList) {
        List<String> symbols = elementList.stream()
                .map(ChemicalElement::getSymbol)
                .collect(Collectors.toList());
        return String.join("", symbols).equalsIgnoreCase(word);
    }

    private static List<String> findWord(List<String> elementNames, /*List<String> tmp,*/ String word, int i) {
        if (i >= word.length()) {
            return /*String.join("", tmp).equalsIgnoreCase(word) ? tmp :*/ new ArrayList<>();
        }

        String str = null;
        List<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        boolean found = false;
        if (i + 1 <= word.length()) {
            str = findElement(elementNames, word.substring(i, i + 1));
            if (str != null) {
                found = true;
                list1 = findWord(elementNames, word, i + 1);
                list1.add(str);
            }
        }
        if (i + 2 <= word.length()) {
            str = findElement(elementNames, word.substring(i, i + 2));
            if (str != null) {
                found = true;
                list2 = findWord(elementNames, word, i + 2);
                list2.add(str);
            }
        }

        return found ?
                (list1.size() >= list2.size()) ? list1 : list2
                : new ArrayList<>();
    }

    private static String findElement(List<String> elementNames, String str) {
        return elementNames.stream()
                .filter(s -> s.equalsIgnoreCase(str))
                .findFirst()
                .orElse(null);
    }


}
