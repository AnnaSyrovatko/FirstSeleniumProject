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

        WebElement element = driver.findElement(By.tagName("form"));
        System.out.println(element.isDisplayed());

        List<WebElement> elements = driver.findElements(By.tagName("strong"));
        System.out.println(elements.size());

        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        paragraphs.forEach(x -> System.out.println(x.getText()));
    }
    @Test
    public void findElementByCssSelector(){

        driver.findElement(By.cssSelector("#small-searchterms"));
        driver.findElement(By.cssSelector("[action='/search']"));
        driver.findElement(By.cssSelector(".button-1.search-box-button"));
        driver.findElement(By.cssSelector("input#pollanswers-1"));
        driver.findElement(By.cssSelector("[for='pollanswers-1']"));

        driver.findElement(By.cssSelector("[href^='/reg']"));
        driver.findElement(By.cssSelector("[data-productid='16'] .button-2.product-box-add-to-cart-button"));
        driver.findElement(By.cssSelector("[class$='content-title']"));
        driver.findElement(By.cssSelector(".top-menu [href*='gift']"));
        driver.findElement(By.cssSelector(".nivo-prevNav"));
    }
    @Test
    public void findElementByXpath(){
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//*[@action='/search']"));
        driver.findElement(By.xpath("//*[contains(@class, 'search-box-button')]"));
        driver.findElement(By.xpath("//*[@id='pollanswers-1']"));
        driver.findElement(By.xpath("//label[text()='Excellent']"));

        driver.findElement(By.xpath("//*[starts-with(@href,'/reg')]"));
        driver.findElement(By.xpath("//div[@data-productid='16']//input[@type='button']"));
        driver.findElement(By.xpath("//*[contains(@class, 'content-title')]"));
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(.,'Gift')]"));
        driver.findElement(By.xpath("//*[@class='nivo-prevNav']"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
