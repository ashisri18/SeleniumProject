package org.lambdatest;

import org.lambdatest.pageobject.SeleniumPlayground;
import org.testng.annotations.Test;

public class SampleTest extends WebTestBase{

    @Test
    public void VerifyAndPrintPlaygroundItems(){
        SeleniumPlayground seleniumPlayground = new SeleniumPlayground(getDriver());
        seleniumPlayground.verifyHomePage()
                .verifyHeading()
                .verifyPlaygroundItemsSize()
                .printPlaygroundItemsList();
    }
}
