package designpattern.factorydesignpattern;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface DriverSetup {

    ThreadLocal<RemoteWebDriver> localDriver = new ThreadLocal<RemoteWebDriver>();

    public RemoteWebDriver getDriver();

    public void quitDriver();
}
