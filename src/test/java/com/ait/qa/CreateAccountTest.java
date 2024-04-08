package com.ait.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTest extends TestBase{

    @Test
    public void CreateNewAccountPositiveTest(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        //click on Register Link
        click(By.cssSelector("[href='/register']"));
        //fill in required fields with valid data
        type(By.cssSelector("#FirstName"), "Emy");
        type(By.cssSelector("#LastName"), "Noe");
        type(By.cssSelector("#Email"), "Noemie" + i + "@ya.com");
        type(By.cssSelector("#Password"), "urly-Hand" + i);
        type(By.cssSelector("#ConfirmPassword"), "urly-Hand" + i);
        //click Register button
        click(By.cssSelector("#register-button"));
        //assert log out button is present
        Assert.assertTrue(isElementPresent(By.cssSelector("[value='Continue']")));

    }
}
