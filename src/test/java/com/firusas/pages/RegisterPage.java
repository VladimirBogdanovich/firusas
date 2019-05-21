package com.firusas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class RegisterPage {
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    /*Register form*/
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/input")
    private WebElement emailTextBox;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[1]/div/div[2]")
    private WebElement emailError;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[2]/div/div/input")
    private WebElement firstNameTextBox;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]")
    private WebElement firstNameError;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[3]/div/div/input")
    private WebElement lasttNameTextBox;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[3]/div/div[2]")
    private WebElement lastNameError;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[4]/div/div[1]/input")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[4]/div/div[2]")
    private WebElement passwordError;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[5]/div/div/input")
    private WebElement passwordConfirmationTextBox;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[5]/div/div[2]")
    private WebElement passwordConfirmationError;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[6]/div/div/input")
    private WebElement dateOfBirthTextBox;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[6]/div/div[2]")
    private WebElement dateOfBirthError;
    @FindBy(xpath = "//*[@id=\"checkbox-marker-checked\"]/path")
    private WebElement checkboxMarker;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[9]/p/a")
    private WebElement termsAndConditionsLink;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[10]/button")
    private WebElement registerButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[3]/button")
    private WebElement alredyRegisteredLink;
    @FindBy(xpath = "//*[@id=\"modals\"]/div/div/div/div/div[1]")
    private WebElement signUpPopupText;
    @FindBy(xpath = "//*[@id=\"modals\"]/div/div/div/button")
    private WebElement signUpPopupButton;

    /*Methods*/
    public void registerUser() {
        emailTextBox.clear();
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(1000);
        emailTextBox.sendKeys("new_user" + random + "@test.com");
        firstNameTextBox.clear();
        firstNameTextBox.sendKeys("User");
        lasttNameTextBox.clear();
        lasttNameTextBox.sendKeys("Fiuser");
        passwordTextBox.clear();
        passwordTextBox.sendKeys("qwerty@22");
        passwordConfirmationTextBox.clear();
        passwordConfirmationTextBox.sendKeys("qwerty@22");
        dateOfBirthTextBox.clear();
        dateOfBirthTextBox.sendKeys("1222");
        registerButton.click();
    }

    public void massagesRequiredFields() {
        registerButton.click();
        Assert.assertEquals("The email field is required.", emailError.getText());
        Assert.assertEquals("The first name field is required.", firstNameError.getText());
        Assert.assertEquals("The last name field is required.", lastNameError.getText());
        Assert.assertEquals("The password field is required.", passwordError.getText());
        Assert.assertEquals("The password confirmation field is required.", passwordConfirmationError.getText());
    }

    public void passwordConfirmation() {
        passwordTextBox.sendKeys("qwerty@22");
        passwordConfirmationTextBox.sendKeys("qwerty@22");
        if (passwordConfirmationError.isDisplayed() == false) {
            Assert.fail("The password confirmation does not match.");
            System.out.println("The password confirmation does not match.");
        } else {
            System.out.println("The password is match");
        }
    }

    public void signUpPopup() {
        alredyRegisteredLink.click();
        Assert.assertEquals(signUpPopupText.getText(), "Sign in with Email");
        signUpPopupButton.click();

    }

    public void termsAndConditions() {
        termsAndConditionsLink.click();
    }
}

