package org.lambdatest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class SeleniumPlayground {
    WebDriver driver;
    public SeleniumPlayground(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Visit LambdaTest homepage']")
    WebElement hdg_lambdaTest;

    @FindBy(xpath = "//section[@class='sp__main']//h1[text()='Selenium Playground']")
    WebElement hdg_seleniumPlayground;

    @FindBy(xpath = "//section/div[@class='container__selenium']/ul/li")
    List<WebElement> lst_playgroundItems;

    @FindBy(xpath = "//section/div[@class='container__selenium']/ul/li/a")
    List<WebElement> lst_lnk_playgroundItems;

    public SeleniumPlayground verifyHomePage(){
        Assert.assertTrue(hdg_lambdaTest.isDisplayed(), "Selenium Playground home page NOT validated");
        return this;
    }

    public SeleniumPlayground verifyHeading(){
        Assert.assertEquals(hdg_seleniumPlayground.getText(), "Selenium Playground", "Selenium Playground test NOT validated");
        return this;
    }

    public SeleniumPlayground verifyPlaygroundItemsSize(){
        Assert.assertEquals(lst_playgroundItems.size(), 43, "Playground Items size NOT validated");
        return this;
    }

    public SeleniumPlayground printPlaygroundItemsList(){
        for(WebElement playgroundItem : lst_lnk_playgroundItems)
            System.out.println(driver+": "+playgroundItem.getText());
        return this;
    }


}
