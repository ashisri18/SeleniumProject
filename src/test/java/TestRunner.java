import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        TestListenerAdapter adapter = new TestListenerAdapter();
        List<String> suites = new ArrayList<String>();

        testng.addListener(adapter);
        suites.add(args[0]);
        testng.setTestSuites(suites);
        testng.setParallel("parallel");
        testng.setSuiteThreadPoolSize(5);
        testng.setOutputDirectory("path to output");
        testng.run();
    }
}
