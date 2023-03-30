package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class WishListPage extends BasePage {

    @FindBy(xpath = "//td[@class='text-left']//a")
    public List<WebElement> wishListElements;

    @FindBy(xpath = "//button[@data-original-title='Add to Cart']")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[@class='alert alert-fix alert-success alert-dismissible']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[@data-original-title='Remove']")
    public List<WebElement> removeButtons;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement wishListModifiedMessage;


    public void productInTheWishListValidation(String expectedProductName) {
        boolean flag = false;
        for (WebElement w : wishListElements) {
            System.out.println(w.getText());
            if (w.getText().contains(expectedProductName)) {
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }

    public void addProductFromWishListToCart(String productThatWillBeAdded) {
        int timer = 0;
        for (WebElement w : wishListElements) {
            if (w.getText().equals(productThatWillBeAdded)) {
                break;
            }
            timer++;
        }
        BrowserUtils.waitFor(2);
        addToCartButtons.get(timer).click();
        BrowserUtils.waitFor(2);
    }

    public void addingProductToCartValidateSuccessMessages(String expectedSuccessMessage) {
        expectedSuccessMessage = "Success: You have added " + expectedSuccessMessage + " to your shopping cart!\n×";
        String actualSuccessMessage = successMessage.getText();
        System.out.println(actualSuccessMessage);
        System.out.println(expectedSuccessMessage);
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }

    public void addingProductToWishListValidateSuccessMessages(String expectedSuccessMessage) {
        expectedSuccessMessage = "Success: You have added " + expectedSuccessMessage;
        String actualSuccessMessage = successMessage.getText();
        System.out.println(actualSuccessMessage);
        System.out.println(expectedSuccessMessage);
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
        BrowserUtils.waitFor(3);
    }

    public void removeElementFromWishList(String productThatWillBeRemoved) {
        int timer = 0;
        for (WebElement w : wishListElements) {
            if (w.getText().equals(productThatWillBeRemoved)) {
                break;
            }
            timer++;
        }
        BrowserUtils.waitFor(2);
        removeButtons.get(timer).click();
        BrowserUtils.waitFor(2);
    }

    public void wishListModifiedMessageValidation(String expectedMessage) {
        String actualMessage = wishListModifiedMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public void validateThatTheItemIsNoMoreInWishList(String expectedElement) {
        try {
            Assert.assertFalse(Driver.get().findElement(By.xpath("//td[@class='text-left']//a[text()='" + expectedElement + "']")).isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(true);
        }

        //Alternative Solution
        Assert.assertEquals(0, Driver.get().findElements(By.xpath("//td[@class='text-left']//a[text()='" + expectedElement + "']")).size());
    }
}
