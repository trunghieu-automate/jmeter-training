package testcasse;

import org.junit.Rule;
import org.junit.Test;
import page.utils.CSVFileRule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class TestCSVFileRule {
    @Rule
    public CSVFileRule csvFileRule = new CSVFileRule("C:/datas/data.csv");

    public TestCSVFileRule() throws FileNotFoundException {
    }

    @Test
    public void readCsvFile() throws IOException, IOException {
        BufferedReader reader = csvFileRule.getReader();
        // Read a line from the csv file and assert something
        String line = reader.readLine();
        assertEquals("Hello", line);
        // Access the reader field from the rule object
    }
}
