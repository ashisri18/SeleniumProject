package org.lambdatest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class IFrameDemo {

    WebDriver driver;
    String originalWindow;

    public IFrameDemo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "iFrame Demo")
    WebElement lnkTxt_iFrameDemo;

    @FindBy(tagName = "h1")
    WebElement hdg_iFramePage;

    @FindBy(xpath = "//p[normalize-space()='Simple iFrame containing Editor']")
    WebElement txt_iFrameHeading;

    @FindBy(id = "iFrame1")
    WebElement iFrame;

    @FindBy(xpath = "//div[@contenteditable='true']")
    WebElement edtBx_iFrameContent;

    WebElement getTxt_iFrameHeading(){
        return driver.findElement(RelativeLocator.with(By.tagName("p")).above(iFrame));
    }

    public IFrameDemo openIFrameInNewTab(){
        originalWindow = driver.getWindowHandle();
        String iFrameDemoLink = lnkTxt_iFrameDemo.getAttribute("href");
        driver.switchTo().newWindow(WindowType.TAB);
        String iFrameTab = driver.getWindowHandle();
        driver.get(iFrameDemoLink);
        System.out.println("Page Title: "+driver.getTitle());
        return this;
        }

    public void enterTextInIFrame(){
        System.out.println("Page Heading: "+hdg_iFramePage.getText());
        driver.switchTo().frame(iFrame);
        edtBx_iFrameContent.sendKeys("Writing sample text inside the iFrame...");
        try {Thread.sleep(500);} catch (InterruptedException ignored){}
        driver.switchTo().defaultContent();
        String actualIFrameHeading = txt_iFrameHeading.getText();
        String expectedIFrameHeading = "Simple iFrame containing Editor";
        Assert.assertEquals(actualIFrameHeading, expectedIFrameHeading, "iFrame heading NOT validated");
        System.out.println("iFrame successfully executed...");

        driver.switchTo().window(originalWindow);
        try {Thread.sleep(500);} catch (InterruptedException ignored){}
    }


}
