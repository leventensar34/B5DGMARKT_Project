package com.digimarkt.page;

import com.digimarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressBookEntriesPage extends BasePage{

    @FindBy(xpath = "//span[text()='My Account']")  //my accounta gelip tıklıyoruz
    public WebElement navigateToMyAccountBtn_loc;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right pt-account'][1]/li[1]/a") // dropdownda my accounta tıklıyoruz
    public WebElement dropDownMyAccountBtn_loc;

    // *** VERIFY için ***  get title ile My Account alınabilir.

    @FindBy(xpath = "//*[text()='Address Book']") // address booka tıklıyoruz
    public WebElement addressBookBtn_loc;

    // *** VERIFY için ***  get title ile Address Book alınabilir.

    @FindBy(xpath = "//*[text()='New Address']") // new adrese tıklıyoruz
    public WebElement newAddressBtn_loc;

    @FindBy(xpath = "//*[@name='firstname']") // first name e isim gönderiyoruz.
    public WebElement firstName_loc;
    @FindBy(xpath = "//*[@name='lastname']") //  isim gönderiyoruz.
    public WebElement lastName_loc;
    @FindBy(xpath = "//*[@name='company']") //  isim gönderiyoruz.
    public WebElement company_loc;
    @FindBy(xpath = "//*[@name='address_1']") //  isim gönderiyoruz.
    public WebElement address_1_loc;

    @FindBy(xpath = "//*[@name='address_2']") //  isim gönderiyoruz.
    public WebElement address_2_loc;
    @FindBy(xpath = "//*[@name='city']") //  isim gönderiyoruz.
    public WebElement city_loc;
    @FindBy(xpath = "//*[@name='postcode']") //  isim gönderiyoruz.
    public WebElement postcode_loc;
    @FindBy(xpath = "//select[@name='country_id']") //  drop downdan ülke seçiyoruz.
    public WebElement country_id_loc;
    @FindBy(xpath = "//select[@name='zone_id']") //  drop downdan ülke seçiyoruz.
    public WebElement zone_id_loc;  //  drop downdan bölge seçiyoruz.


    @FindBy(xpath = "//label[@class='radio-inline'][1]/input")  // default adres bölümünde YES butonu
    public WebElement defaultAddressBtnYes_loc;
    @FindBy(xpath = "//label[@class='radio-inline'][2]/input")  // default adres bölümünde NO butonu
    public WebElement defaultAddressBtnNo_loc;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn_loc;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible'][1]/text()") // *** VERIFY için***  "Your address has been successfully added"
    public WebElement successAddAddressAlert_loc;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible'][1]/text()") // *** VERIFY için***  "Your address has been successfully updated"
    public WebElement successUpdateAddressAlert_loc;

    @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")  // First Name must be between 1 and 32 characters!
    public WebElement firstNameDangerMessage_loc;
    @FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")  // Last Name must be between 1 and 32 characters!
    public WebElement lastNameDangerMessage_loc;
    @FindBy(xpath = "//div[text()='Address must be between 3 and 128 characters!']")  // Address must be between 3 and 128 characters!
    public WebElement address1DangerMessage_loc;
    @FindBy(xpath = "//div[text()='City must be between 2 and 128 characters!']")  // City must be between 2 and 128 characters!
    public WebElement cityDangerMessage_loc;
    @FindBy(xpath = "//div[text()='Postcode must be between 2 and 10 characters!']")  // Postcode must be between 2 and 10 characters!
    public WebElement postCodeDangerMessage_loc;
    @FindBy(xpath = "//div[text()='Please select a country!']")  // Please select a country!
    public WebElement selectCountryDangerMessage_loc;
    @FindBy(xpath = "//div[text()='Please select a region / state!']")  // Please select a region / state!
    public WebElement selectRegionDangerMessage_loc;



    //    public void addAddressInfo(String inputBoxName,String userInformation ){
//
//        WebElement placeholder = Driver.get().findElement(By.name(inputBoxName));
//    //    placeholder.clear();
//        placeholder.sendKeys(userInformation);
//
//    }

    public void selectCountry(String country){
        Select select=new Select(country_id_loc);
        select.selectByValue(country);
    }
    public void selectZone(String zone){
        Select select=new Select(zone_id_loc);
        select.selectByValue(zone);
    }



}
