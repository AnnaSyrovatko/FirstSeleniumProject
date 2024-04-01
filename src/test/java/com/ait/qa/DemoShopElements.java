package com.ait.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DemoShopElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByTagName(){

        WebElement form = driver.findElement(By.tagName("form")); // The only unique enabled tag
        System.out.println(form.isDisplayed());

        List<WebElement> strongList = driver.findElements(By.tagName("strong"));
        System.out.println(strongList.size());

        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        paragraphs.forEach(x -> System.out.println(x.getText()));

        WebElement element = driver.findElement(By.className("ico-register"));
        System.out.println(element.getText());


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
