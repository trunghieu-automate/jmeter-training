package runner;

import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import testcasse.LoginTest;
import testcasse.SeleniumDevTest;

public class ParallelRunner {

    public static void main(String[] args) {
        // Create a ParallelComputer object with parallel mode for classes and methods
        ParallelComputer pc = new ParallelComputer(true, true);
        // Run the test classes in parallel using the ParallelComputer object
        JUnitCore.runClasses(pc, SeleniumDevTest.class);
    }
}