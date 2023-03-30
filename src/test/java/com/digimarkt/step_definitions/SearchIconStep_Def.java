package com.digimarkt.step_definitions;

import com.digimarkt.page.SearchIconPage;
import com.digimarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchIconStep_Def {

    SearchIconPage searchIconPage = new SearchIconPage();

    @Given("The user should be login in homepage")
    public void the_user_should_be_login_in_homepage() {

    }
    @When("The user clicks search icon button")
    public void the_user_clicks_search_icon_button() {
        searchIconPage.searchIcon.click();
    }
    @Then("The user should be able to see search line")
    public void the_user_should_be_able_to_see_search_line() {
        Assert.assertEquals("Search entire store here ...", searchIconPage.
                                searchFunctionField.getAttribute("placeholder"));
    }
    @Then("The user types {string} in search field and click search button")
    public void the_user_types_in_search_field_and_click_search_button(String item) {
        searchIconPage.searchFunctionField.click();
        searchIconPage.searchFunctionField.sendKeys(item);
        searchIconPage.searchBtnInSearch.click();
    }

    @Then("The user verify that title of searched product {string}")
    public void theUserVerifyThatTitleOfSearchedProduct(String expectedResult) {
        Assert.assertEquals(expectedResult, Driver.get().getTitle());


    }

    @Then("The user verify that NOT found message {string}")
    public void theUserVerifyThatNOTFoundMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, searchIconPage.verifyNoProductText.getText());

    }
}

