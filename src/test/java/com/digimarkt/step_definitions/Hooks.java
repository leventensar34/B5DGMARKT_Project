package com.digimarkt.step_definitions;

import com.digimarkt.page.FirstLoginPage;
import com.digimarkt.utilities.ConfigurationReader;
import com.digimarkt.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    FirstLoginPage firstLoginPage=new FirstLoginPage();


    @Before
    public void setup() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firstLoginPage.firstLogin();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screeshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screeshot, "image/png", "screenshot");
        }

        Driver.closeDriver();
    }
}
