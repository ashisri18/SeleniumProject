package designpattern.factorydesignpattern;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class IosDriverSetup implements DriverSetup {

    public IosDriverSetup(){
        try {
            localDriver.set(new IOSDriver(new URL("")));
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

    }
}
