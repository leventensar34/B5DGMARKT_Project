package com.digimarkt.step_definitions;

import com.digimarkt.page.CurrencyFunctionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CurrencyFunctionStep_Def {

    CurrencyFunctionPage currencyFunctionPage=new CurrencyFunctionPage();

    @Given("The user selects  {string}")
    public void the_user_selects(String currency) {
        currencyFunctionPage.currencySelectMtd(currency);
    }

    @When("The user goes to {string} page from Category")
    public void the_user_goes_to_page_from_category(String categoryName) {
        currencyFunctionPage.categorySelectMtd(categoryName);

    }
    @Then("The user sees that the currency on the products has changed to {string}")
    public void the_user_sees_that_the_currency_on_the_products_has_changed_to(String currencyOfProduct) {
        currencyFunctionPage.currencyOfProductVerifyMtd(currencyOfProduct);
    }

    @When("The user select a product and adds the selected product to the cart")
    public void the_user_select_a_and_adds_the_selected_product_to_the_cart() {
        currencyFunctionPage.addToCartMtd();

    }
    @When("The user goes to cart")
    public void the_user_goes_to_cart() {
        //currencyFunctionPage.goesToCart();
        currencyFunctionPage.cartBtn.click();
    }
    @When("The user goes to checkout page")
    public void the_user_goes_to_checkout_page() {
        currencyFunctionPage.goesToCheckOutMtd();

    }
    @When("The user selects the I want to use a new address and goes to the Delivery Details")
    public void the_user_selects_the_and_goes_to_the_billing_details() {
        currencyFunctionPage.newAdressSelectMtd();
    }
    @When("The user enters {string},{string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters(String firstName, String lastName, String adress1, String city,  String postCode, String country, String regionState) {
        currencyFunctionPage.billingDetailEntersMtd(firstName, lastName, adress1, city, postCode, country, regionState);

    }
    @When("The user selects the I want to use an existing address")
    public void the_user_selects_the_i_want_to_use_a_existing_address() {
        currencyFunctionPage.existingAdresSelectMtd();

    }
    @When("The user confirms Term&Condition")
    public void the_user_confirms_term_condition() {

        currencyFunctionPage.paymentAgreeMtd();

    }
    @Then("The user sees that the product currency is {string}")
    public void the_user_sees_that_the_product_prices_and_currency_are(String expectedCurrency) {

        currencyFunctionPage.currencyVerifyMetod(expectedCurrency);

    }
    @When("The user confirms your their order")
    public void the_user_confirms_your_their_order() {
        currencyFunctionPage.confirmOrderBtn.click();

    }
    @Then("The user verifies that the order was completed successfully")
    public void the_user_verifies_that_the_order_was_completed_successfully() {
        String actualVerifyMesaage = currencyFunctionPage.orderVerifyMessageText.getText();
        System.out.println("actualVerifyMesaage = " + actualVerifyMesaage);
        Assert.assertEquals("Your Order Has Been Placed!", currencyFunctionPage.orderVerifyMessageText.getText());

    }

    @Then("The user should be see that the product currency is the same as the default currency.")
    public void the_user_should_be_see_that_the_product_currency_is_the_same_as_the_default_currency() {
       currencyFunctionPage.currencyVerifyMetod();

    }

}
