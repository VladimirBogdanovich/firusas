package com.firusas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterCompleatePage {
    public RegisterCompleatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    /*Register Compleate*/
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[1]/div[text()=\"Thank your signing up.\"]")
    private WebElement successfulRegistrationTitle;

    /*Methods*/
    public void checkRegisterComplete() {
        if (successfulRegistrationTitle.isDisplayed())
            System.out.println("Thank your signing up.");
    }
}
