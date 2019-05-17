package com.firusas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    /*Login form*/
    @FindBy(xpath = "//*[@id=\"modals\"]/div/div/div/div/div[2]/div/input")
    private WebElement emailTextBox;
    @FindBy(xpath = "//*[@id=\"modals\"]//div[text()=\"The email field is required.\"]")
    private WebElement emailErrorMessage;
    @FindBy(xpath = "//*[@id=\"modals\"]/div/div/div/div/div[3]/div/input")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//*[@id=\"modals\"]//div[text()=\"The password field is required.\"]")
    private WebElement passwordErrorMessage;
    @FindBy(xpath = "//*[@id=\"modals\"]//div[text()=\"Sign in\"]")
    private WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"modals\"]//button[text()=\"Forgot password?\"]")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//*[@id=\"modals\"]//button[text()=\"Registration\"]")
    private WebElement registrationLink;
    @FindBy(xpath = "//*[@id=\"modals\"]/div/div/div/div/div[6]/div/button")
    private WebElement facebookButton;
    @FindBy(xpath = "//*[@id=\"modals\"]/div/div/div/div/div[6]/div/button[2]")
    private WebElement googlePlusButton;
    @FindBy(xpath = "//*[@id=\"modals\"]/div/div/div/button")
    private WebElement closeButton;

    /*Methods*/
    public void loginUser() {
        emailTextBox.clear();
        emailTextBox.sendKeys("firusastest@yandex.ua");
        passwordTextBox.clear();
        passwordTextBox.sendKeys("qwerty@33");
        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).click().perform();

    }
}
