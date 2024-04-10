package com.demoshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartHelper extends BaseHelper {
    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnCartLink() {
        click(By.cssSelector("[href='/cart']"));
    }

    public int sizeOfItemsInCart(){
        if (isElementPresent(By.className("cart-item-row"))){
            return driver.findElements(By.className("cart-item-row")).size();
        }
        return 0;
    }
    public void addItemToCart(By locator){
        click(locator);
    }

    public void clearCart() {
        List<WebElement> items = driver.findElements(By.className("cart-item-row"));
        for (int i = 0; i < items.size(); i++) {
            click(By.name("removefromcart"));
        }
        click(By.name("updatecart"));
    }
}
