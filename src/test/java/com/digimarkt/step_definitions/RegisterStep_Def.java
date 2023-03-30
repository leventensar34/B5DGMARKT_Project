package com.digimarkt.step_definitions;

import com.digimarkt.page.RegisterPage;
import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RegisterStep_Def {

    RegisterPage registerPage=new RegisterPage();

    @Given("The user can first login successfully")
    public void the_user_can_first_login_successfully() {

    }
    @Then("The user verify that the Register Account page message {string}")
    public void the_user_verify_that_the_register_account_page_message(String expectedMessage) {
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expectedMessage,registerPage.verifyRegisterWindowsMessage.getText());
    }
    @Then("The user enters all the personal credential {string} {string} {string} {string} {string} {string}")
    public void the_user_enters_all_the_personal_credential(String firstname, String lastname, String email, String telephone, String password, String passwordConfirm) {

        registerPage.positiveRegisterCredential_Mtd(firstname, lastname, email, telephone, password, passwordConfirm);
    }
    @Then("The user click the Privacy Policy and Continue box button")
    public void the_user_click_the_privacy_policy_and_continue_box_button() {

        registerPage.registerPrivacyPolicyInputBox.click();
        BrowserUtils.waitFor(1);
        registerPage.registerContinueBtn.click();
    }
    @Then("The user verify that the succesfully message {string}")
    public void the_user_verify_that_the_succesfully_message(String expectedMessage) {
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expectedMessage,registerPage.verifyCreatedAccountMessage.getText());

    }

    @And("The user click the Continue button")
    public void theUserClickTheContinueButton() {
        BrowserUtils.waitFor(1);
        registerPage.createdAccountContinueBtn.click();
    }

    @Then("The user verify that on the main Account page and see the {string} text as title")
    public void theUserVerifyThatOnTheMainAccountPageAndSeeTheTextAsTitle(String expectedMessage) {

        Assert.assertEquals(expectedMessage, Driver.get().getTitle());
    }

    @Then("The user verify that the error message {string}")
    public void theUserVerifyThatTheErrorMessageMessage(String expectedMessage) {
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expectedMessage,registerPage.verifyErrorMessage.getText());
    }
}
