package com.ait.tests;

import com.demoshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(app.getUser().isAccountNamePresent()){
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void CreateNewAccountPositiveTest(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillLoginRegistrationForm(new User().setFirstName("Emy")
                .setLastName("Noe")
                .setEmail("Noemie" + i + "@ya.com")
                .setPassword("urly-Hand" + i)
                .setConfirmPassword("urly-Hand" + i));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAccountNamePresent());
    }
}
