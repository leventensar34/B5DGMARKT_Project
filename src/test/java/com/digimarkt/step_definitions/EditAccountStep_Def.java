package com.digimarkt.step_definitions;

import com.digimarkt.page.EditAccountPage;
import com.digimarkt.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class EditAccountStep_Def {

    EditAccountPage editAccountPage=new EditAccountPage();

    @And("The user navigates to My Account module My Account button")
    public void theUserNavigatesToMyAccountModuleMyAccountButton() {
        editAccountPage.myAccount_Mtd();
    }
    @And("The user clicks {string} button")
    public void the_user_clicks_button(String editButton) {
        editAccountPage.editAccount_Mtd(editButton);
    }
    @Given("The user updates {string} {string} {string} {string}")
    public void theUserUpdates(String firstName, String lastName, String eMAil, String telephone) {
        editAccountPage.editUserAccount_Mtd(firstName, lastName, eMAil, telephone);
    }
    @And("The user clicks the Continue button")
    public void theUserClicksTheContinueButton() {
        editAccountPage.continueBtn_loc.click();
    }
    @Then("The user verify {string}")
    public void theUserVerify(String expectedMessage) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(expectedMessage, editAccountPage.successMessage_loc.getText());
    }
    @Then("The user verify dangers {string}")
    public void theUserVerifyDangers(String expectedMessage) {
        editAccountPage.verifyWarningMessage_mtd();
       Assert.assertEquals(expectedMessage, editAccountPage.dangerMessages_loc.getText());
    }
    @Then("The user verify that a danger error {string}")
    public void theUserVerifyThatADangerError(String expectedMessage) {
        editAccountPage.verifyDangerMessageForEdit(expectedMessage);
    }
}
