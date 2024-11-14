package designpattern.factorydesignpattern;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverSetup implements DriverSetup {

    public AndroidDriverSetup(){
        try {
            localDriver.set(new AndroidDriver(new URL(""), new DesiredCapabilities()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RemoteWebDriver getDriver() {
        return localDriver.get();
    }

    @Override
    public void quitDriver() {
        getDriver().quit();
    }
}
