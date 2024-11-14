package org.lambdatest;

import designpattern.factorydesignpattern.FactoryPatternBase;
import org.testng.annotations.Test;

public class FactoryPatternTest extends FactoryPatternBase {

    @Test
    public void launchAmazon(){
        driver.get("https://www.amazon.com");
        try {
            Thread.sleep(2000);
            driver.manage().window().maximize();
            Thread.sleep(2000);
            System.out.println(driver.getTitle());
            System.out.println("Amazon.com open for "+ driver);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
