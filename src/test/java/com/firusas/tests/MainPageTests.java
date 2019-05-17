package com.firusas.tests;

import com.firusas.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTests {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Volumes/Home/Autotests/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://firusas.com");
    }

    @Test
    public void checkPhoneLink() {
        MainPage mainPage = new MainPage(driver);
        mainPage.checkToCallLink();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
