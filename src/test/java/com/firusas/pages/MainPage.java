package com.firusas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    /*Header*/
    @FindBy(xpath = "//*[@id='header']//span[text()='Let’s talk:']")
    private WebElement callToUsTitle;
    @FindBy(xpath = "//*[@id='header']//a[text()='+43720115278']")
    private WebElement callToUsNumber;
    @FindBy(xpath = "//*[@id='header']/div/div/div[text()='Your new online fashion destination']")
    private WebElement headerTitle;
    @FindBy(xpath = "//*[@id=\"header\"]/div[1]/div/div[3]/a[1]")
    private WebElement registerButton;
    @FindBy(id = "SignInModalHeader") //*[@id="header"]/div[1]/div/div[3]/button
    private WebElement loginButton;

    /*Footer*/
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[8]/div/div/div[2]/button/div")
    private WebElement iAgreeButton;


    /*Methods*/
    public void checkToCallLink() {
        Assert.assertEquals("+43720115278", callToUsNumber.getText());
        callToUsNumber.click();
    }

    public void clickRegisterButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(registerButton).click().perform();
    }

    public void clickLogin() {
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).click().perform();
    }
}
