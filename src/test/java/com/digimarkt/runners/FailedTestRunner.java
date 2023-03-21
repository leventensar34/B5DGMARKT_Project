package com.digimarkt.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/failed-html-reports.html"},
        features = "@target/rerun.txt",
        glue = "com/digimarkt/step_definitions"
)
public class FailedTestRunner {

}
