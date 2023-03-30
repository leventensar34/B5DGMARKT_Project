package com.digimarkt.step_definitions;

import com.digimarkt.page.LikeIconPage;
import com.digimarkt.utilities.BrowserUtils;
import io.cucumber.java.en.*;

public class LikeIcon_StepDef {
    LikeIconPage likeIconPage=new LikeIconPage();
    @When("The user navigates Category dropdown than choose {string} and click")
    public void the_user_navigates_category_dropdown_than_choose_and_click(String chooseCategory) {
        likeIconPage.categorySelect(chooseCategory);
    }
    @And("The user navigates {string} and click Like Icon")
    public void theUserNavigatesAndClickLikeIcon(String product) {
        likeIconPage.addProductToWishList(product);
    }
    @Then("The user should be see Success: You have added {string} mesage")
    public void the_user_should_be_see_success_you_have_added_mesage(String expectedMessage) {
        likeIconPage.addingProductToWishListValidateSuccessMessages(expectedMessage);
    }
    @When("The user navigates Wish List Icon and click")
    public void theUserNavigatesWishListIconAndClick() {
        likeIconPage.goWishListIcon_loc.click();
        BrowserUtils.waitFor(3);
    }
    @Then("The user should be see the chosen product {string} mesage in Wish List")
    public void theUserShouldBeSeeTheChosenProductMesageInWishList(String expectedMessage) {
        likeIconPage.scrollTO();
        likeIconPage.productInTheWishListValidation(expectedMessage);
        BrowserUtils.waitFor(4);
    }


    @Given("The user is on the Wish List page")
    public void theUserIsOnTheWishListPage() {
        likeIconPage.goWishListIcon_loc.click();
        BrowserUtils.waitFor(3);
    }
    @When("The user navigates chosen product's {string} icon and click")
    public void the_user_navigates_chosen_product_s_icon_and_click(String tab) {
        likeIconPage.wishRemoveCart_Mtd(tab);
        BrowserUtils.waitFor(3);
    }
    @Then("The user should be see {string} mesage")
    public void the_user_should_be_see_mesage(String expectedMessage) {
        likeIconPage.addingProductToWishListValidateSuccessMessages(expectedMessage);
    }
    @When("The user navigates chosen {string} Add to Cart icon and click")
    public void the_user_navigates_chosen_add_to_cart_icon_and_click(String chProd) {
        likeIconPage.addProductFromWishListToCart(chProd);
    }

    @When("The user navigates chosen {string} Remove icon and click")
    public void the_user_navigates_chosen_remove_icon_and_click(String product) {
        likeIconPage.removeElementFromWishList(product);
    }
    @Then("The user should be see {string} message")
    public void the_user_should_be_see_message(String mesage) {
        likeIconPage.removeProductToWishListValidateSuccessMessages(mesage);
    }

}
