package com.digimarkt.page;


import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;




public class CurrencyFunctionPage extends BasePage{

    @FindBy(xpath = "(//span[text()='Home'])[2]")
    public WebElement homeBtn;
    @FindBy(xpath = "(//img[@alt='Health & Beauty'])[2]")
    public WebElement categorySelectBtnHealtAndBeauty;
    @FindBy(xpath = "(//img[@alt='Televisions'])[2]")
    public WebElement categorySelectBtnTv;

    @FindBy(xpath = "(//img[@alt='Networking'])[2]")
    public WebElement categorySelectBtnNetworking;

    @FindBy(xpath = "(//img[@alt='TV Accessories'])[2]")
    public WebElement categorySelectBtnTvAccesories;

    @FindBy(xpath = "//span[text()='Currency']")
    public WebElement currencySelectBtn;

    @FindBy(xpath = "//button[text()='€ Euro']")
    public WebElement currencyName;

    @FindBy(xpath = "//a[text()='Cello C5020G4K 50\" Smart 4K LED-backlit LCD TV']")
    public WebElement verifyProduct_Tv;

    @FindBy(xpath = "//a[text()='ASUS ZenWiFi XD6 - Wi-Fi system (2 routers)']" )
    public WebElement verifyProduct_Routers;

    @FindBy(xpath = "//a[text()='C2G audio cable - 5 m']")
    public WebElement verifyProduct_TvAccesories;

    @FindBy(xpath = "(//p[@class='price'])[10]")
    public WebElement currencyVerifyProduct;

    @FindBy(xpath = "(//a[contains(text(),'C5020G4K')])[2]")
    public WebElement selectedProductPageBtn;
    @FindBy(xpath = "//button[text()='Add to Cart']")
    public WebElement selectedProductTvAddToCartBtn;

    @FindBy(xpath = "//button[@data-loading-text='Loading...']")
    public WebElement cartBtn;

    @FindBy(xpath = "(//input[@name='payment_address'])[2]")
    public WebElement newAdressRadioBtn;

    @FindBy(xpath = "//input[@value='guest']")
    public WebElement guestCheckoutBtn;

    @FindBy(xpath = "//input[@id='button-account'][@type='button']")
    public WebElement newCustomerContinueBtn;

    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    public WebElement firstNaneInputBox;
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    public WebElement lastNaneInputBox;
    @FindBy(xpath = "//input[@id='input-payment-email']")
    public WebElement emailInputBox;
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    public WebElement telephoneInputBox;
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    public WebElement adress1InputBox;
    @FindBy(xpath = "//input[@id='input-payment-city']")
    public WebElement cityInputBox;
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    public WebElement postCodeInputBox;
    @FindBy(xpath = "//select[@id='input-payment-country']")
    public WebElement countrySelectBtn;
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    public WebElement regionStateSelectBtn;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    public WebElement billingDetailContinueBtn;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    public WebElement deliveriDetailsContinueBtn;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    public WebElement deliveryMethodContinueBtn;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement paymentMethodTermConditionAgreeBtn;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    public WebElement paymentMethodContinueBtn;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr/td[5]")
    public WebElement confirmOrderPriceAndCurrencyOfProduct;

    @FindBy(xpath = "//input[@id='button-confirm']")
    public WebElement confirmOrderBtn;

    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    public WebElement orderVerifyMessageText;

    public void currencySelectMtd(String currencyName){
        currencySelectBtn.click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//button[text()='"+currencyName+"']")).click();
        BrowserUtils.waitFor(1);
    }

    public void categorySelectMtd(String categoryName){

       if(categoryName.equals("Televisions")){
           BrowserUtils.scrollToElement(categorySelectBtnTv);
           BrowserUtils.waitFor(1);
           categorySelectBtnTv.click();
           BrowserUtils.scrollToElement(verifyProduct_Tv);
       } else if (categoryName.equals("Networking")) {
           BrowserUtils.scrollToElement(categorySelectBtnNetworking);
           BrowserUtils.waitFor(1);
           categorySelectBtnNetworking.click();
           BrowserUtils.scrollToElement(verifyProduct_Routers);
       } else if (categoryName.equals("TV Accessories")) {
           BrowserUtils.scrollToElement(categorySelectBtnTvAccesories);
           BrowserUtils.waitFor(1);
           categorySelectBtnTvAccesories.click();
           BrowserUtils.scrollToElement(verifyProduct_TvAccesories);
       } else{
           BrowserUtils.scrollToElement(categorySelectBtnHealtAndBeauty);
           BrowserUtils.waitFor(1);
           Driver.get().findElement(By.xpath("(//a[contains(text(),'"+categoryName+"')])[3]")).click();
           BrowserUtils.scrollToElement(verifyProduct_Tv);
        }

    }

    public void currencyOfProductVerifyMtd(String currencyOfProduct){

        String actualCurrency = currencyVerifyProduct.getText();
        System.out.println("actualCurrency = " + actualCurrency);
        Assert.assertTrue(actualCurrency.contains(currencyOfProduct));
    }

    public void addToCartMtd(){
        Driver.get().navigate().to("https://dgmarkt.com/index.php?route=product/product&path=60&product_id=7644236");
        selectedProductTvAddToCartBtn.click();
        Driver.get().navigate().back();
    }

    public void goesToCheckOutMtd(){
        Driver.get().navigate().to("https://dgmarkt.com/index.php?route=checkout/checkout");

    }

    public void newAdressSelectMtd(){

        BrowserUtils.scrollToElement(newAdressRadioBtn);

        if(!(newAdressRadioBtn.isSelected())) {
            newAdressRadioBtn.click();
        }

    }

    public void billingDetailEntersMtd(String firstName, String lastName, String adress1, String city, String postCode, String country, String regionState){

        firstNaneInputBox.sendKeys(firstName);
        lastNaneInputBox.sendKeys(lastName);
        adress1InputBox.sendKeys(adress1);
        cityInputBox.sendKeys(city);
        postCodeInputBox.sendKeys(postCode);
        selectCountry(country);
        selectRegionState(regionState);

        billingDetailContinueBtn.click();


    }

    public void selectCountry(String country){
        BrowserUtils.waitFor(1);
        Select select=new Select(countrySelectBtn);
        select.selectByVisibleText(country);
    }
    public void selectRegionState(String zone){
        BrowserUtils.waitFor(1);
        Select select=new Select(regionStateSelectBtn);
        select.selectByVisibleText(zone);
    }

    public void paymentAgreeMtd(){
        BrowserUtils.scrollToElement(paymentMethodTermConditionAgreeBtn);
        BrowserUtils.waitForClickablility(paymentMethodTermConditionAgreeBtn, 1);
        paymentMethodTermConditionAgreeBtn.click();
        BrowserUtils.waitFor(1);
        paymentMethodContinueBtn.click();

    }

    public void currencyVerifyMetod(String expectedCurrency){
        char expectedCurrency1 = expectedCurrency.charAt(0);
        BrowserUtils.waitFor(1);
        String actualPriseAndCurrency= Driver.get().findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td[5]")).getText();

        if((expectedCurrency1=='£') || (expectedCurrency1=='$')) {
            char actualCurrency = actualPriseAndCurrency.charAt(0);
            System.out.println("actualCurrency = " + actualCurrency);
            System.out.println("expectedCurrency1 = " + expectedCurrency1);
            Assert.assertTrue(expectedCurrency1==actualCurrency);
        }else{
            char actualCurrency = actualPriseAndCurrency.charAt(actualPriseAndCurrency.length()-1);
            System.out.println("actualCurrency = " + actualCurrency);
            System.out.println("expectedCurrency1 = " + expectedCurrency1);
            Assert.assertTrue(expectedCurrency1==actualCurrency);
        }


    }

    public void currencyVerifyMetod(){
        String expectetCurrencyText = currencySelectBtn.getText();
        BrowserUtils.waitForVisibility(confirmOrderPriceAndCurrencyOfProduct,1);
        String actualPriseAndCurrency= confirmOrderPriceAndCurrencyOfProduct.getText();
        System.out.println("expectetCurrencyText = " + expectetCurrencyText);
        System.out.println("actualPriseAndCurrency = " + actualPriseAndCurrency);

    }

    public void existingAdresSelectMtd(){

        BrowserUtils.scrollToElement(deliveriDetailsContinueBtn);
        BrowserUtils.waitFor(1);
        deliveriDetailsContinueBtn.click();

        BrowserUtils.scrollToElement(deliveryMethodContinueBtn);
        BrowserUtils.waitFor(1);
        deliveryMethodContinueBtn.click();


    }
}
