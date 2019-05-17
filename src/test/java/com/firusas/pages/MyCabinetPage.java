package com.firusas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyCabinetPage {
    public MyCabinetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    /*My Cabinet page*/
    @FindBy(id = "DashboardLinkHeader")
    private WebElement myAccountLink;


    /*Methods*/
    public void checkUserLoginMyCabinet() {
        Assert.assertEquals("MY ACCOUNT", myAccountLink.getText());
        System.out.println("User in my cabinet");
    }
}
