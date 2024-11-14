package org.lambdatest;

import org.lambdatest.pageobject.IFrameDemo;
import org.lambdatest.pageobject.SeleniumPlayground;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import utility.RetryAnalyzer;

public class AdvancedConcepts extends WebTestBase{

    IFrameDemo iFrameDemo;
    SeleniumPlayground seleniumPlayground;
    int count;

    @Test()
    public void testSimpleIFrame(){
        iFrameDemo = new IFrameDemo(getDriver());
        iFrameDemo.openIFrameInNewTab()
                .enterTextInIFrame();

    }

    @Test(/*retryAnalyzer = RetryAnalyzer.class*/)
    public void reprintPlaygroundItemList(){
        seleniumPlayground = new SeleniumPlayground(getDriver());
        seleniumPlayground.printPlaygroundItemsList();
        count++;
        Assert.assertEquals(count, 2, "Execution count is not 2");
    }
}
