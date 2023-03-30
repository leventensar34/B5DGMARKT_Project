package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartIconPage extends BasePage{
    @FindBy(id = "cart-total")
    public WebElement homePageCartIcon_loc;

    @FindBy(xpath = "//i[@class='fa fa-shopping-cart']")
    public WebElement fromPopupViewCart_loc;

    @FindBy(xpath = "//div[@id='cart']")
    public WebElement cartIcon_loc;

    @FindBy(xpath = "//*[text()=' Checkout']")
    public WebElement checkout_loc;

    @FindBy(xpath = "//h1[text()='Checkout']")
    public WebElement verifyCheckout_loc;

    @FindBy(id = "button-payment-address")
    public WebElement firstCont_loc;

    @FindBy(id = "button-shipping-address")
    public WebElement secondCont_loc;

    @FindBy(id = "button-shipping-method")
    public WebElement thirdCont_loc;

    @FindBy(name = "agree")
    public WebElement agreement_loc;

    @FindBy(id = "button-payment-method")
    public WebElement fourthCont_loc;

    @FindBy(id = "button-confirm")
    public WebElement confirmBtn_loc;

    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    public WebElement verifyOrder_loc;

    public void checkoutPageCredentias_Mtd(){
        firstCont_loc.click();
        BrowserUtils.waitFor(2);
        secondCont_loc.click();
        BrowserUtils.waitFor(2);
        thirdCont_loc.click();
        BrowserUtils.waitFor(2);
        agreement_loc.click();
        fourthCont_loc.click();
        BrowserUtils.waitFor(1);
        confirmBtn_loc.click();
    }

}
