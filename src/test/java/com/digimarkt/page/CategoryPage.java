package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends BasePage {



    @FindBy(xpath = "//div[@class='caption']")
    public List<WebElement> productCaptions;

    public void addProductToWishList(String productNames) {
        int timer = 0;
        for (WebElement w : productCaptions) {
            if (w.getText().contains(productNames)) {
                break;
            }
            timer++;
            System.out.println(w.getText());
        }
        System.out.println(timer);
        new Actions(Driver.get()).moveToElement(productCaptions.get(timer)).perform();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("(//*[@class='button-wishlist'])[" + (timer + 1) + "]")).click();
        BrowserUtils.waitFor(2);
    }



}
