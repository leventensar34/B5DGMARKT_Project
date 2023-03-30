package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LikeIconPage extends BasePage{

    @FindBy(id = "wishlist-total")
    public WebElement goWishListIcon_loc;

    @FindBy(xpath = "//div[@class='caption']")
    public List<WebElement> productCaptions;

    @FindBy(xpath = "//div[@class='alert alert-fix alert-success alert-dismissible']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successMessage1;

    @FindBy(xpath = "//td[@class='text-left']//a")
    public List<WebElement> wishListElements;

    @FindBy(xpath = "//button[@data-original-title='Add to Cart']")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//a[@data-original-title='Remove']")
    public List<WebElement> removeButtons;

    @FindBy(xpath = "(//a[.='Edit Account'])[1]")
    public WebElement seeWishlistPage_loc;
    @FindBy(xpath = "//i[@class='fa fa-refresh']")
    public WebElement seeCartPage_loc;
    public void scrollTO(){
        BrowserUtils.scrollToElement(seeWishlistPage_loc);
    }
    public void scrollTO2(){
        BrowserUtils.scrollToElement(seeCartPage_loc);
    }
    public void categorySelect(String category){
        Driver.get().findElement(By.xpath("(//img[@alt='"+category+"'])[2]")).click();

    }
    public void wishRemoveCart_Mtd(String tab){
        Driver.get().findElement(By.xpath("//*[@data-original-title='"+tab+"']")).click();
    }
    public void addProductToWishList(String productNames) {
        int timer = 0;
        for (WebElement w : productCaptions) {
            if (w.getText().contains(productNames)) {
                break;
            }
            timer++;
        }
        new Actions(Driver.get()).moveToElement(productCaptions.get(timer)).perform();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("(//*[@class='button-wishlist'])[" + (timer + 1) + "]")).click();
        BrowserUtils.waitFor(2);
    }
    public void addingProductToWishListValidateSuccessMessages(String expectedSuccessMessage) {
        expectedSuccessMessage = "Success: You have added " + expectedSuccessMessage;
        String actualSuccessMessage = successMessage.getText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
        BrowserUtils.waitFor(3);
    }
    public void productInTheWishListValidation(String expectedProductName) {
        boolean flag = false;
        for (WebElement w : wishListElements) {
            if (w.getText().contains(expectedProductName)) {
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }
    public void valitadateThatTheProductInCart(String expectedProduct) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().findElement(By.xpath("//td//a[text()='" + expectedProduct + "']")).isDisplayed());

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
    public void removeProductToWishListValidateSuccessMessages(String expectedSuccessMessage) {
        String actualSuccessMessage = successMessage1.getText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
        BrowserUtils.waitFor(3);
    }
}
