package com.digimarkt.page;


import com.digimarkt.utilities.BrowserUtils;
import com.digimarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public void navigatetoMyAccountDropdownMenu(String module, String tab) {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//span[text()='" + module + "']")).click();
        BrowserUtils.waitFor(2);

        Driver.get().findElement(By.xpath("//*[text()='" + tab + "']")).click();
        BrowserUtils.waitFor(1);

    }

    public void hoverOverToMenuHeadersAndSubMenuHeaders(String menuHeader, String subMenuHeader) {
        BrowserUtils.waitFor(2);
        new Actions(Driver.get()).moveToElement(Driver.get().findElement(By.xpath("//span[text()='" + menuHeader + "']"))).perform();


        Driver.get().findElement(By.xpath("//*[text()='" + subMenuHeader + "']")).click();
        BrowserUtils.waitFor(1);

    }

    public void navigateToPageOrClickAButton(String text) {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//*[text()='" + text + "']")));

    }
}
