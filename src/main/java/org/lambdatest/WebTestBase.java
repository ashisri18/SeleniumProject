package org.lambdatest;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        if (browserName.equalsIgnoreCase("Chrome")){
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("chrome");
            ChromeOptions options = new ChromeOptions();
            options.merge(cap);
        } else if (browserName.equalsIgnoreCase("Edge")) {
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("MicrosoftEdge");
            EdgeOptions options = new EdgeOptions();
            options.merge(cap);
        }
//        driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), cap ));
        driver.set(new ChromeDriver());
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
