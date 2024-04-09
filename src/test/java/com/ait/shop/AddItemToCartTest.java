package com.ait.shop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("Noemie@ya.com").setPassword("urly-Hand42"));
        clickOnLoginButton();
    }
    @Test
    public void addItemToCartTest1(){
        //add product
        click(By.xpath("//input[contains(@onclick,'31')]"));
        pause(1000);
        clickOnCartLink();
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/141-inch-laptop']")));
    }

    @Test
    public void addItemToCartTest2(){
        clickOnCartLink();
        int sizeBefore = sizeOfItemsInCart();
        clickOnMainPage();
        click(By.xpath("//input[contains(@onclick,'31')]"));
        pause(1000);
        clickOnCartLink();
        int sizeAfter = sizeOfItemsInCart();
        Assert.assertEquals(sizeBefore, sizeAfter - 1);
    }

    private void clickOnMainPage() {
        click(By.cssSelector("[href='/']"));
    }
    public int sizeOfItemsInCart(){

        if (isElementPresent(By.className("cart-item-row"))){
            return driver.findElements(By.className("cart-item-row")).size();
        }
        return 0;
    }




}
