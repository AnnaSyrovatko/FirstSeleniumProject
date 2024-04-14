package com.ait.tests;

import com.demoshop.data.UserData;
import com.demoshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemFromCart extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegistrationForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        app.getCart().addItemToCart(By.xpath("//input[contains(@onclick,'31')]"));
        app.getCart().pause(1000);
        app.getCart().clickOnCartLink();
    }
    @Test
    public void deleteItemFromCartTest(){
        int sizeBefore = app.getCart().sizeOfItemsInCart();
        app.getCart().click(By.name("removefromcart"));
        app.getCart().click(By.name("updatecart"));
        int sizeAfter = app.getCart().sizeOfItemsInCart();
        Assert.assertEquals(sizeBefore - 1, sizeAfter);
    }
}
