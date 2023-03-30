package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "cart")
    public WebElement cartButton;

    public void valitadateThatTheProductInCart(String expectedProduct) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().findElement(By.xpath("//td//a[text()='" + expectedProduct + "']")).isDisplayed());
    }

    public void userClicksToCartButton() {
        cartButton.click();
        BrowserUtils.waitFor(2);
    }

}
