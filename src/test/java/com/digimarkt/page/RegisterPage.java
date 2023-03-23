package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//*[text()='Register Account']")
    public WebElement verifyRegisterWindowsMessage;

    @FindBy(id = "input-firstname")
    public WebElement registerFirstNameInputBox;

    @FindBy(id = "input-lastname")
    public WebElement registerLastNameInputBox;

    @FindBy(id = "input-register-email")
    public WebElement registerEmailInputBox;

    @FindBy(id = "input-telephone")
    public WebElement registerTelephoneInputBox;

    @FindBy(id = "input-register-password")
    public WebElement registerPasswordInputBox;

    @FindBy(id = "input-confirm")
    public WebElement registerPasswordConfirmInputBox;

    @FindBy(name = "agree")
    public WebElement registerPrivacyPolicyInputBox;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement registerContinueBtn;

    @FindBy(xpath = "//*[text()='Your Account Has Been Created!']")
    public WebElement verifyCreatedAccountMessage;

    @FindBy(xpath = "//*[text()='Continue']")
    public WebElement createdAccountContinueBtn;

    @FindBy(xpath = " //*[text()=' Warning: E-Mail Address is already registered!']")
    public WebElement sameEmailWarningMessage;

    @FindBy(xpath = " //*[@class='form-group required has-error']/div")
    public WebElement verifyErrorMessage;





    public void positiveRegisterCredential_Mtd(String firstname, String lastname, String email, String telephone, String password, String passwordConfirm) {

        registerFirstNameInputBox.sendKeys(firstname);
        BrowserUtils.waitFor(2);
        registerLastNameInputBox.sendKeys(lastname);
        BrowserUtils.waitFor(2);
        registerEmailInputBox.sendKeys(email);
        BrowserUtils.waitFor(2);
        registerTelephoneInputBox.sendKeys(telephone);
        BrowserUtils.waitFor(2);
        registerPasswordInputBox.sendKeys(password);
        BrowserUtils.waitFor(2);
        registerPasswordConfirmInputBox.sendKeys(passwordConfirm);
        BrowserUtils.waitFor(2);
    }


}
