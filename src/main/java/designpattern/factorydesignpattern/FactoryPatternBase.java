package designpattern.factorydesignpattern;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class FactoryPatternBase {
    public RemoteWebDriver driver;
    DriverSetup driverSetup;

    @Parameters({"platformName"})
    @BeforeTest
    public void initializeDriver(String platformName){
        driverSetup = DriverSetupFactory.getDriverSetup(platformName);
        driver = driverSetup.getDriver();
    }

    @AfterTest
    public void tearDownDriver(){
        driverSetup.quitDriver();
    }
}
