package com.ait.shop;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTest extends TestBase{

    @Test
    public void CreateNewAccountPositiveTest(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        clickOnRegistrationLink();
        fillRegistrationForm(new User().setFirstName("Emy")
                .setLastName("Noe")
                .setEmail("Noemie" + i + "@ya.com")
                .setPassword("urly-Hand" + i)
                .setConfirmPassword("urly-Hand" + i));
        clickOnRegistrationButton();
        Assert.assertTrue(isAccountNamePresent());
    }
}
