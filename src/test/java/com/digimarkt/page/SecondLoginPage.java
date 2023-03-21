package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondLoginPage extends BasePage {

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccount;

    @FindBy(id = "pt-login-link")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement usernameInputBox;

    @FindBy(id = "input-password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//span[text() = 'Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[text()='×']")
    public WebElement successMessage;

    public void loginHomePage() {
        usernameInputBox.sendKeys(ConfigurationReader.get("userLoginEmail"));
        BrowserUtils.waitFor(1);
        passwordInputBox.sendKeys(ConfigurationReader.get("userLoginPassword"));
        BrowserUtils.waitFor(1);
        loginButton.click();

    }
}
