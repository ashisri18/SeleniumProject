package designpattern.factorydesignpattern;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverSetup implements DriverSetup {

    public ChromeDriverSetup(){
        localDriver.set(new ChromeDriver());
    }

    @Override
    public RemoteWebDriver getDriver() {
        return localDriver.get();
    }

    @Override
    public void quitDriver() {

    }
}
