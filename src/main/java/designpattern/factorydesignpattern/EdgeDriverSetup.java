package designpattern.factorydesignpattern;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverSetup implements DriverSetup{

    public EdgeDriverSetup(){
        localDriver.set(new EdgeDriver());
    }

    @Override
    public RemoteWebDriver getDriver() {
        return localDriver.get();
    }

    @Override
    public void quitDriver() {

    }
}
