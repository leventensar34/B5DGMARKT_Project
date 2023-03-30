package com.digimarkt.step_definitions;

import com.digimarkt.page.CartPage;
import com.digimarkt.page.CategoryPage;
import com.digimarkt.page.SecondLoginPage;
import com.digimarkt.page.WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WishListStepDefinitions {

    SecondLoginPage secondLoginPage = new SecondLoginPage();
    CategoryPage categoryPage = new CategoryPage();
    WishListPage wishListPage = new WishListPage();

    CartPage cartPage = new CartPage();

    @And("User clicks to {string}")
    public void userClicksTo(String arg0) {
    }

    @Then("User validates that the wish list is empty")
    public void userValidatesThatTheWishListIsEmpty() {
    }

    @And("User clicks {string}")
    public void userClicks(String link) {
        categoryPage.navigateToPageOrClickAButton(link);
    }

    @Then("User verifies that the user can see the product {string} in the wish list")
    public void userVerifiesThatTheUserCanSeeTheProductInTheWishList(String productName) {
        wishListPage.productInTheWishListValidation(productName);
    }

    @And("User clicks to {string} icon")
    public void userClicksToIcon(String arg0) {
    }

    @And("The user hover overs to {string} menu headers and clicks {string} sub menu headers")
    public void theUserHoverOversToMenuHeadersAndClicksSubMenuHeaders(String arg0, String arg1) {
        secondLoginPage.hoverOverToMenuHeadersAndSubMenuHeaders(arg0, arg1);
    }

    @And("User adds {string} item in his her wish list")
    public void userAddsItemInHisHerWishList(String productName) {
        categoryPage.addProductToWishList(productName);
    }

    @And("User adds product {string} from wish list to cart")
    public void userAddsProductFromWishListToCart(String productNameInWishList) {
        wishListPage.addProductFromWishListToCart(productNameInWishList);
    }

    @Then("User validates the success message adding to cart {string}")
    public void userValidatesTheSuccessMessage(String expectedSuccessMessage) {
        wishListPage.addingProductToCartValidateSuccessMessages(expectedSuccessMessage);
    }

    @Then("User validates the success message adding to wish list {string}")
    public void userValidatesTheSuccessMessageAddingToWishList(String expectedSuccessMessage) {
        wishListPage.addingProductToWishListValidateSuccessMessages(expectedSuccessMessage);
    }

    @Then("User validates that the item is in cart {string}")
    public void userValidatesThatTheItemIsInCart(String expectedProduct) {
        cartPage.valitadateThatTheProductInCart(expectedProduct);
    }

    @And("User clicks to cart button")
    public void userClicksToCartButton() {
        cartPage.userClicksToCartButton();
    }

    @And("User clicks remove button {string}")
    public void userClicksRemoveButton(String arg0) {
        wishListPage.removeElementFromWishList(arg0);
    }

    @Then("User validates that the item is not on the wish list anymore {string}")
    public void userValidatesThatTheItemIsNotOnTheWishListAnymore(String expectedElement) {
        wishListPage.validateThatTheItemIsNoMoreInWishList(expectedElement);
    }

}
