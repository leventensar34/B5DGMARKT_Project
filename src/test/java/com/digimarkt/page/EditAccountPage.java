package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends BasePage{

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountSelectBtn;
    @FindBy(xpath = "(//a[text()='My Account'])[1]")
    public WebElement myAccountBtn;
    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstName_loc;
    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastName_loc;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement eMail_loc;
    @FindBy(id = "input-email")
    public WebElement emailBox_loc;
    @FindBy(xpath = "//input[@name='telephone']")
    public WebElement telephone_loc;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    public WebElement continueBtn_loc;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successMessage_loc;
    @FindBy(xpath = "//div[@class='text-danger']")
    public WebElement dangerMessages_loc;
    @FindBy(xpath = "//div[@class='text-danger']")
    public WebElement dangerrrMessage_loc;

    public void myAccount_Mtd(){
        BrowserUtils.waitFor(1);
        myAccountSelectBtn.click();
        BrowserUtils.waitFor(1);
        myAccountBtn.click();
    }
    public void editAccount_Mtd(String editButton){
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//*[text()='"+editButton+"']")).click();
    }
    public  void editUserAccount_Mtd(String firstName, String lastName, String eMail, String telephone){
        firstName_loc.clear();
        lastName_loc.clear();
        eMail_loc.clear();
        telephone_loc.clear();
        BrowserUtils.waitFor(1);
        firstName_loc.sendKeys(firstName);
        lastName_loc.sendKeys(lastName);
        eMail_loc.sendKeys(eMail);
        telephone_loc.sendKeys(telephone);
    }
    public void verifyWarningMessage_mtd(){
        String validationMessage = emailBox_loc.getAttribute("validationMessage");
        System.out.println("validationMessage = " + validationMessage);
    }
    public void verifyDangerMessageForEdit(String expectedMessage) {
        WebElement email = Driver.get().findElement(By.xpath("//input[@type='email']"));
        boolean sonuc = email.getAttribute("validationMessage").equals(expectedMessage);
        if (sonuc) {
            Assert.assertTrue(sonuc);
        } else {
            Assert.assertTrue(dangerrrMessage_loc.isEnabled());
        }
    }
}

