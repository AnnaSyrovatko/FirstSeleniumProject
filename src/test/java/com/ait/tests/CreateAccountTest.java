package com.ait.tests;

import com.demoshop.models.User;
import com.demoshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test(dataProvider = "addNewUserFromCsvFile", dataProviderClass = DataProviders.class)
    public void CreateNewAccountPositiveTest(User user){
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAccountNamePresent());
    }
}
