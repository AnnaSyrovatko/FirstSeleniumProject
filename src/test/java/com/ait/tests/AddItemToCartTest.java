package com.ait.tests;

import com.demoshop.data.ProductsData;
import com.demoshop.data.UserData;
import com.demoshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(app.getUser().isAccountNamePresent()){
            app.getUser().clickOnLogOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegistrationForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addItemToCartTest1(){
        app.getCart().addItemToCart(By.xpath(ProductsData.PRODUCT_IN_CATALOGUE));
        app.getCart().pause(1000);
        app.getCart().clickOnCartLink();
        Assert.assertTrue(app.getCart().isElementPresent(By.cssSelector(ProductsData.PRODUCT_NAME)));
    }

    @Test
    public void addItemToCartTest2(){
        int sizeBefore = app.getCart().sizeOfItemsInCart();
        app.getCart().addItemToCart(By.xpath(ProductsData.PRODUCT_IN_CATALOGUE));
        app.getCart().pause(1000);
        app.getCart().clickOnCartLink();
        int sizeAfter = app.getCart().sizeOfItemsInCart();
        Assert.assertEquals(sizeBefore, sizeAfter - 1);
    }

    @AfterMethod
    public void postCondition(){
        app.getCart().clearCart();
    }


}
