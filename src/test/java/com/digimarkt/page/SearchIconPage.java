package com.digimarkt.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchIconPage extends BasePage {

    @FindBy(xpath = "//*[@class='dropdown-toggle search-button']")
    public WebElement searchIcon;

    @FindBy(xpath = "//*[@id='text-search']")
    public WebElement searchFunctionField;

    @FindBy(xpath = "//*[@id='btn-search-category']")
    public WebElement searchBtnInSearch;

    @FindBy(xpath = "//*[text()='There is no product that matches the search criteria.']")
    public WebElement verifyNoProductText;





}
