package com.demoshop.fw;

import com.demoshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountNamePresent() {
        return isElementPresent(By.cssSelector("ul:nth-child(1) .account"));
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }
    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[value='Log in']"));
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

}
