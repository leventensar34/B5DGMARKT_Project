package com.digimarkt.page;

import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressBookEntriesPage extends BasePage{

    @FindBy(xpath = "//*[text()='New Address']")
    public WebElement newAddressBtn_loc;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[2]/a[1]")
    public WebElement editAddressBtn_loc;

    @FindBy(xpath = "//*[@name='firstname']")
    public WebElement firstName_loc;

    @FindBy(xpath = "//*[@name='lastname']")
    public WebElement lastName_loc;

    @FindBy(xpath = "//*[@name='company']")
    public WebElement company_loc;

    @FindBy(xpath = "//*[@name='address_1']")
    public WebElement address_1_loc;

    @FindBy(xpath = "//*[@name='address_2']")
    public WebElement address_2_loc;

    @FindBy(xpath = "//*[@name='city']")
    public WebElement city_loc;

    @FindBy(xpath = "//*[@name='postcode']")
    public WebElement postcode_loc;

    @FindBy(xpath = "//select[@name='country_id']")
    public WebElement country_id_loc;

    @FindBy(xpath = "//select[@name='zone_id']")
    public WebElement zone_id_loc;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement verifySuccesMessage_loc;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement verifyEditSuccesMessage_loc;

    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[10]/div/label[1]")
    public WebElement defaultAddressBtnYes_loc;

    @FindBy(xpath = "//label[@class='radio-inline'][2]/input")
    public WebElement defaultAddressBtnNo_loc;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn_loc;

    @FindBy(xpath = "//div[@class='text-danger']")
    public WebElement verifyDangerMessage_loc;


    public void selectCountry(String country){
        BrowserUtils.waitFor(1);
        Select select=new Select(country_id_loc);
        select.selectByVisibleText(country);
    }

    public void selectZone(String zone){
        BrowserUtils.waitFor(1);
        Select select=new Select(zone_id_loc);
        select.selectByVisibleText(zone);
    }

    public void navigatetoMyAccountToMyAccountMenu(String module) {
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//span[text()='" + module + "']")).click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("(//*[text()='My Account'])[2]")).click();
        BrowserUtils.waitFor(1);
    }

    public void navigateToAddressBookMenu(String button){
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//*[text()='"+button+"']")).click();
    }

    public void addNewAddress_mtd(String firstname,String lastname,String company,String address1,String address2,String city,String postCode,String country,String zone){
        BrowserUtils.waitFor(1);
        firstName_loc.sendKeys(firstname);
        lastName_loc.sendKeys(lastname);
        company_loc.sendKeys(company);
        address_1_loc.sendKeys(address1);
        address_2_loc.sendKeys(address2);
        city_loc.sendKeys(city);
        postcode_loc.sendKeys(postCode);
        BrowserUtils.waitFor(1);
        selectCountry(country);
        selectZone(zone);
    }

    public void editAddress_mtd(String firstname,String lastname,String company,String address1,String address2,String city,String postCode,String country,String zone){
        BrowserUtils.waitFor(1);
        firstName_loc.clear();
        lastName_loc.clear();
        company_loc.clear();
        address_1_loc.clear();
        address_2_loc.clear();
        city_loc.clear();
        postcode_loc.clear();
        BrowserUtils.waitFor(2);
        firstName_loc.sendKeys(firstname);
        lastName_loc.sendKeys(lastname);
        company_loc.sendKeys(company);
        address_1_loc.sendKeys(address1);
        address_2_loc.sendKeys(address2);
        city_loc.sendKeys(city);
        postcode_loc.sendKeys(postCode);
        selectCountry(country);
        selectZone(zone);
    }

    public void invalidAddress_mtd(String firstname,String lastname,String address1,String city,String postCode,String country,String zone){
        BrowserUtils.waitFor(1);
        firstName_loc.sendKeys(firstname);
        lastName_loc.sendKeys(lastname);
        address_1_loc.sendKeys(address1);
        city_loc.sendKeys(city);
        postcode_loc.sendKeys(postCode);
        selectCountry(country);
        selectZone(zone);
    }
}
