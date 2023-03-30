package com.digimarkt.step_definitions;

import com.digimarkt.page.CartIconPage;
import com.digimarkt.page.LikeIconPage;
import com.digimarkt.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class CartIcon_StepDef {
    CartIconPage cartIconPage=new CartIconPage();
    LikeIconPage likeIconPage=new LikeIconPage();
    @When("The user navigates to Home Page Cart icon and click")
    public void the_user_navigates_to_home_page_cart_icon_and_click() {
        cartIconPage.homePageCartIcon_loc.click();
    }
    @Then("The user should be see {string} in popup window")
    public void the_user_should_be_see_in_popup_window(String product) {
        likeIconPage.valitadateThatTheProductInCart(product);
    }
    @When("The user navigates to View Cart button and click")
    public void the_user_navigates_to_view_cart_button_and_click() {
        cartIconPage.fromPopupViewCart_loc.click();
        BrowserUtils.waitFor(2);
    }
    @Then("The user should be see the chosen product {string} message in Wish List")
    public void theUserShouldBeSeeTheChosenProductMesageInWishList(String expectedMessage) {
        likeIconPage.scrollTO2();
        likeIconPage.productInTheWishListValidation(expectedMessage);
        BrowserUtils.waitFor(3);
    }
    @When("The user navigates to Cart Icon and go Checkout button and click")
    public void the_user_navigates_to_cart_icon_and_go_checkout_button_and_click() {
        cartIconPage.cartIcon_loc.click();
        BrowserUtils.waitFor(2);
        cartIconPage.checkout_loc.click();
        BrowserUtils.waitFor(2);
    }
    @Then("The user should be able to see Checkout Page")
    public void the_user_should_be_able_to_see_page() {
        Assert.assertEquals(cartIconPage.verifyCheckout_loc.getText(),"Checkout");
    }
    @When("The user should be enters valid Checkout credentials")
    public void the_user_should_be_enters_valid_checkout_credentials() {
       cartIconPage.checkoutPageCredentias_Mtd();

    }
    @Then("The user should be able to see {string} message")
    public void the_user_should_be_able_to_see_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,cartIconPage.verifyOrder_loc.getText());
    }
}
