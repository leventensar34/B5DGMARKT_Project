package com.digimarkt.step_definitions;

import com.digimarkt.page.SecondLoginPage;
import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStep_Def {

    SecondLoginPage secondLoginPage = new SecondLoginPage();

    @Then("The user should be on the main page and can see the {string} text as title")
    public void the_user_should_be_on_the_main_page_and_can_see_the_text_as_title(String expectedMessage) {
        Assert.assertEquals(expectedMessage, Driver.get().getTitle());
    }

    @When("The user navigates to {string} module {string} tab")
    public void the_user_navigates_to_module_tab(String myAccountMenu, String loginTab) {

        secondLoginPage.navigatetoMyAccountDropdownMenu(myAccountMenu, loginTab);
    }

    @When("The user enters the personal username and password")
    public void the_user_enters_the_personal_username_and_password() {

        secondLoginPage.loginHomePage();
    }

    @Then("The user should be on the dashboard page and can see the {string} success message")
    public void the_user_should_be_on_the_dashboard_page_and_can_see_the_success_message(String expectedMessage) {
        expectedMessage += "\n×";
        BrowserUtils.waitFor(1);
        System.out.println(secondLoginPage.successMessage.getText());

        Assert.assertTrue(secondLoginPage.successMessage.getText().equals(expectedMessage));
        //Assert.assertEquals(expectedMessage, secondLoginPage.successMessage.getText());

    }
}
