package page.utils;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CSVFileRule implements TestRule {
    // A field to hold the csv file reference
    private BufferedReader reader;

    // A constructor that takes the file name or path as an argument
    public CSVFileRule(String fileName) throws FileNotFoundException {
        // Initialize the reader with the file name or path
        reader = new BufferedReader(new FileReader(fileName));
    }

    // A getter method to access the reader
    public BufferedReader getReader() {
        return reader;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    // Invoke the base statement's evaluate method
                    base.evaluate();
                } finally {
                    // Close the reader in the finally block
                    reader.close();
                }
            }
        };
    }

}
