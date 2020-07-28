package vk.dev.trials.periodictable;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * PeriodicTable.
 *
 * @author vladimir_kuragin
 */
public class PeriodicTable {

    private static final String csvUrl = "https://gist.github.com/GoodmanSciences/c2dd862cd38f21b0ad36b8f96b4bf1ee/raw/1d92663004489a5b6926e944c1b3d9ec5c40900e/Periodic%2520Table%2520of%2520Elements.csv";

    private Map<String, ChemicalElement> elements;

    public Map<String, ChemicalElement> getElements() {
        if (elements == null || elements.isEmpty()) {
            fetchAndParseSource();
        }
        return elements;
    }

    private void fetchAndParseSource() {
        String csv = downloadCsv();
        try {
            CSVParser records = CSVParser.parse(csv, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            elements = records.getRecords()
                    .stream()
                    .map(this::parseElement)
                    .collect(Collectors.toMap(ChemicalElement::getSymbol, Function.identity()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ChemicalElement parseElement(CSVRecord csvRecord) {
        return new ChemicalElement(
                Integer.parseInt(csvRecord.get("AtomicNumber")),
                csvRecord.get("Symbol"),
                csvRecord.get("Element"),
                "",
                parseIntWithDefault(csvRecord.get("Period"), -1),
                parseIntWithDefault(csvRecord.get("Group"), -1),
                Double.parseDouble(csvRecord.get("AtomicMass"))
        );
    }

    private String downloadCsv() {
        String csv = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream input = new URL(csvUrl).openStream();
            IOUtils.copy(input, out);
            csv = out.toString(StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csv;
    }

    private static int parseIntWithDefault(String s, int def) {
        try {
            return Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return def;
        }
    }
}
