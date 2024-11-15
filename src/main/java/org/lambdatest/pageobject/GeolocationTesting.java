package org.lambdatest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.browser.Browser;
import org.openqa.selenium.devtools.v125.browser.model.PermissionType;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.IOException;
import java.util.*;

public class GeolocationTesting {

    WebDriver driver;
    DevTools  devTools;

    public GeolocationTesting(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Geolocation Testing")
    WebElement lnkTxt_geolocationTesting;

    @FindBy(tagName = "h1")
    WebElement hdg_geolocationTestingPage;

    WebElement txt_geolocationDetails(String detailsOf){
        return driver.findElement(By.xpath("//p[text()=\""+detailsOf+"\"]/span"));
    }

    public GeolocationTesting openNewTabWithDifferentGeolocation(){
//        to set geolocation in new tab, first open the new tab then emulate location using dev tools
        driver.switchTo().newWindow(WindowType.TAB);

//        Using Chrome Devtools Protocol(CDP)
        devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();
        double latitude = 52.5043; // San Francisco Latitude
        double longitude = 13.4501;
        double accuracy = 5;
        devTools.send(Browser.resetPermissions(Optional.empty()));
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(latitude),
                Optional.of(longitude),
                Optional.of(accuracy)));

//        Without CDP
        /*Map<String, Object> corodinate = new HashMap<>();
        corodinate.put("latitude", 52.5043);
        corodinate.put("longitude", 13.4501);
        corodinate.put("accuracy", 5);
        ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", corodinate);*/

        driver.get("https://my-location.org");
        try{Thread.sleep(5000);} catch (InterruptedException ignored){}
        System.out.println("Page Title: "+driver.getTitle());
        return this;
    }
}
