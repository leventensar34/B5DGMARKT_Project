package com.digimarkt.step_definitions;

import com.digimarkt.page.AddressBookEntriesPage;
import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddressBookEntriesStep_Def {
    AddressBookEntriesPage addressBookEntriesPage = new AddressBookEntriesPage();


    @Given("The user can logın successfully")
    public void theUserCanLogınSuccessfully() {
    }

    @And("The user navigates to {string} module and click My Account button")
    public void theUserNavigatesToModuleAndClickMyAccountButton(String menu) {
        addressBookEntriesPage.navigatetoMyAccountToMyAccountMenu(menu);
    }

    @Then("The user should be navigate to the My Account page and able to see the {string} as title")
    public void the_user_should_be_navigate_to_the_my_account_page_and_able_to_see_the_as_title(String expectedTitle) {
        String actualTitleMyAccount= Driver.get().getTitle();
        Assert.assertEquals("Titles are match",expectedTitle,actualTitleMyAccount);
    }

    @When("The user goes and clicks on {string} button")
    public void the_user_goes_and_clicks_on_button(String button) {
        addressBookEntriesPage.navigateToAddressBookMenu(button);
    }

    @Then("The user should be navigate to the Address Book page and able to see the {string} as title")
    public void the_user_should_be_navigate_to_the_address_book_page_and_able_to_see_the_as_title(String expectedTitle) {
        String actualTitleAddressBook= Driver.get().getTitle();
        Assert.assertEquals("Titles are match",expectedTitle,actualTitleAddressBook);
    }

    @When("The user clicks on New Address button")
    public void theUserClicksOnNewAddressButton() {
        addressBookEntriesPage.newAddressBtn_loc.click();
    }

    @And("The user enters NEW {string} {string} {string} {string} {string} {string} {string} {string} {string} credentials")
    public void theUserEntersNEWCredentials(String name, String lname, String company, String address1, String address2, String city, String postCode, String country, String state) {
        addressBookEntriesPage.addNewAddress_mtd(name,lname,company,address1,address2,city,postCode,country,state);
    }

    @And("The user clicks the Continue button")
    public void theUserClicksTheContinueButton() {
        addressBookEntriesPage.continueBtn_loc.click();
    }

    @Then("The user verify {string}")
    public void the_user_verify(String expectedPopUpMessage) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(expectedPopUpMessage,addressBookEntriesPage.verifySuccesMessage_loc.getText());
    }

    @Then("The user verify Edit {string}")
    public void theUserVerifyEdit(String expectedVerifyMessage) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(expectedVerifyMessage,addressBookEntriesPage.verifyEditSuccesMessage_loc.getText());
    }

    @When("The user clicks on Edit button")
    public void theUserClicksOnEditButton() {
        addressBookEntriesPage.editAddressBtn_loc.click();
    }

    @And("The user UPDATES credentials {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void theUserUPDATESCredentials(String name, String lname, String company, String address1, String address2, String city, String postCode, String country, String state) {
        addressBookEntriesPage.editAddress_mtd(name,lname,company,address1,address2,city,postCode,country,state);
    }

    @And("The user enters {string} {string} {string} {string} {string} {string} {string} credentials")
    public void theUserEntersCredentials(String fname, String lname, String address1, String city, String pcode, String country, String region) {
        addressBookEntriesPage.invalidAddress_mtd(fname,lname,address1,city,pcode,country,region);
    }

    @Then("The dander message contains {string}")
    public void theDanderMessageContains(String expectedMessage) {
        Assert.assertEquals(expectedMessage,addressBookEntriesPage.verifyDangerMessage_loc.getText());
    }

    @Then("The warning message contains {string}")
    public void the_warning_message_contains(String expectedMessage) {
        Assert.assertEquals(expectedMessage,addressBookEntriesPage.verifySuccesMessage_loc.getText());
    }

    @And("The user switch Default Address from Yes to No")
    public void theUserSwitchDefaultAddressFromYesToNo() {
        addressBookEntriesPage.defaultAddressBtnNo_loc.click();
    }

    @When("The user clicks on Edit button again")
    public void theUserClicksOnEditButtonAgain() {
        addressBookEntriesPage.editAddressBtn_loc.click();
    }

    @Then("The user verify Default Address is on the {string}")
    public void theUserVerifyDefaultAddressIsOnThe(String expectedDefaultAddress) {
        String actualDefaultAddress = addressBookEntriesPage.defaultAddressBtnYes_loc.getText();
        Assert.assertNotEquals("Default address is macth",expectedDefaultAddress,actualDefaultAddress);
    }

}
