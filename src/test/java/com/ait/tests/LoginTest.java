package com.ait.tests;

import com.demoshop.data.UserData;
import com.demoshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){ // rewrite precondition - too time-consuming element search
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void loginPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegistrationForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAccountNamePresent());
    }
    @Test
    public void loginNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegistrationForm(new User().setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.className("message-error")));
    }
}

