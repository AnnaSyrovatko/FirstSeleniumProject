package com.ait.shop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginPositiveTest(){
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("Noemie@ya.com").setPassword("urly-Hand42"));
        clickOnLoginButton();
        Assert.assertTrue(isAccountNamePresent());
    }
}

