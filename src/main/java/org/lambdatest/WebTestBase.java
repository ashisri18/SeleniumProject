package org.lambdatest;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebTestBase {

    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public DesiredCapabilities cap = new DesiredCapabilities();

    @Parameters({"browserName"})
    @BeforeTest
    public void driverSetup(String browserName) throws MalformedURLException {
        ChromeOptions chromeOptions;
        EdgeOptions edgeOptions;
        if (browserName.equalsIgnoreCase("Chrome")){
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("chrome");
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.merge(cap);
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver.set(new ChromeDriver(chromeOptions));
        } else if (browserName.equalsIgnoreCase("Edge")) {
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("MicrosoftEdge");
            edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless");
            edgeOptions.addArguments("--disable-gpu");
            edgeOptions.addArguments("--no-sandbox");
            edgeOptions.merge(cap);
            cap.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
            driver.set(new EdgeDriver(edgeOptions));
        }
//        driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), cap));
//        driver.set(new ChromeDriver());
        getDriver().get("https://www.lambdatest.com/selenium-playground/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().window().maximize();
        String pageTitle = getDriver().getTitle();
        System.out.println(browserName+"@"+getDriver()+": Web Page: "+ pageTitle+" launch successfully...");
    }

    public RemoteWebDriver getDriver(){
        return driver.get();
    }

    @AfterTest
    public void driverTearDown(){
        getDriver().close();
        System.out.println(getDriver()+": Tab closed successfully...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getDriver().quit();
        System.out.println(getDriver()+": driver quit successfully...");
    }
}
