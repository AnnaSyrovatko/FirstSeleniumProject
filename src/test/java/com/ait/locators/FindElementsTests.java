package com.ait.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        // wait for el-s to be loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void findElementsByTagName() {
        //find el by tag name
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

    }
    @Test
    public void findElementByLocators(){
        // id - best strategy but for dynamic id
        driver.findElement(By.id("city"));
        // class name
        driver.findElement(By.className("input-container"));
        // name By.name()
        //link text
        driver.findElement(By.linkText( "Let the car work"));
        // partial link
        driver.findElement(By.partialLinkText("work"));
    }
    @Test
    public void findElementByCssSelector(){
        // tag name = tag name;
        //id -> #id (css selector)
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));
        //class name -> .className
        driver.findElement(By.cssSelector(".input-container"));
        // [name='key']
        driver.findElement(By.cssSelector("[for='city'"));
        driver.findElement(By.cssSelector("[href='/search'"));
        //contains -> *
        driver.findElement(By.cssSelector("[href*='car'"));
        //starts -> ^=/key
        driver.findElement(By.cssSelector("[href^='/let'"));
        //end on -> $
        driver.findElement(By.cssSelector("[href$='work']"));
    }
    @Test
    public void findElementByXpath(){
        //xPath //tag|*[@attr='value']
        driver.findElement(By.xpath("//h1"));
        // id -> tag[@id='idName']
        driver.findElement(By.xpath("//*[@id='city']"));
        // class name -> //*[@class='Name']
        driver.findElement(By.xpath("//*[@class='input-container']"));
        // contains -> //*contains[@attr,'value']
        driver.findElement(By.xpath("//*[contains(@href,'car')]"));
        driver.findElement(By.xpath("//*[starts-with(@href,'/let')]"));


        driver.findElement(By.xpath("//span[text()=' Never mistaken for anything else ']"));
        driver.findElement(By.xpath("//span[.=' Never mistaken for anything else ']"));
        driver.findElement(By.xpath("//span[contains(.,'mistakes')]"));
        driver.findElement(By.xpath("//span[contains(text(),'mistakes')]"));
        // //input[@id='username']/..
        // //div/a - child
        // //div//a  - any level child

        //tag1[.tag2[@attr='value']]
        //*[@id='firstName' or @name='lastName']
        //*[@id='firstName' and @name='lastName']
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
