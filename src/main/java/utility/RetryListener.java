package utility;

import org.testng.IAnnotationTransformer;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*public class RetryListener implements IAnnotationTransformer {

    public void transformer(ITestAnnotation annotation, Class testClass,
                            Constructor testConstructor, Method testMethod){
        annotation.getRetryAnalyzerClass();
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

}*/

public class RetryListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer(result) == null) {
            result.getMethod().setRetryAnalyzerClass(RetryAnalyzer.class);
        }
    }
}
