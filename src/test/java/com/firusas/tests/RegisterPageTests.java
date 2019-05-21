package com.firusas.tests;

import com.firusas.pages.RegisterCompleatePage;
import com.firusas.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterPageTests {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Volumes/Home/Autotests/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://firusas.com/en/register");
    }

    @Test
    public void newkUserRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser();
        RegisterCompleatePage registerCompleatePage = new RegisterCompleatePage(driver);
        registerCompleatePage.checkRegisterComplete();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://firusas.com/en/register-complete");
    }

    @Test
    public void checkRequiredFields() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.massagesRequiredFields();
    }

    @Test
    public void checkPasswordConfirmation() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.passwordConfirmation();
    }

    @Test
    public void checkSignUpPopup() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.signUpPopup();
    }

    @Test
    public void checkTermsAndConditionsLink() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.termsAndConditions();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains("https://firusas.com/terms-and-conditions"));
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
