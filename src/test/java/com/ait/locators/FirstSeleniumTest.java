package com.ait.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;
    //before - setUp
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        //driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com"); // with history
        driver.navigate().back();
        driver.navigate().forward();
        //driver.navigate().refresh()
    }
    @Test
    public void openGoogleTest(){
        System.out.println("Google is opened!");
    }
    //test - name
    //after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
        //driver.close(); - close one tab
    }
}
