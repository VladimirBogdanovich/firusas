package com.firusas.tests;

import com.firusas.pages.LoginPage;
import com.firusas.pages.MainPage;
import com.firusas.pages.MyCabinetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Volumes/Home/Autotests/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://firusas.com/en");
    }

    @Test
    public static void checkLogin() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains("https://firusas.com/en/cabinet-main"));
        MyCabinetPage myAccount = new MyCabinetPage(driver);
        myAccount.checkUserLoginMyCabinet();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
