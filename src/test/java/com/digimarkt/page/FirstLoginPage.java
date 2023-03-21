package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstLoginPage extends BasePage {

    @FindBy(name = "email")
    public WebElement firstEmailInputBox;

    @FindBy(name = "password")
    public WebElement firstPasswordInputBox;

    @FindBy(name = "login")
    public WebElement firstLoginButton;

    @FindBy(xpath = "//input[@class='cbk_newsletter']")
    public WebElement popUpWindows;

    @FindBy(xpath = "//a[@class='a-close-newsletter']")
    public WebElement closePopUpBtn;

    public void firstLogin() {
        firstEmailInputBox.sendKeys(ConfigurationReader.get("firstEmail"));
        firstPasswordInputBox.sendKeys(ConfigurationReader.get("firstPassword"));
        firstLoginButton.click();
        BrowserUtils.waitFor(2);
        popUpWindows.click();
        closePopUpBtn.click();
    }
}
