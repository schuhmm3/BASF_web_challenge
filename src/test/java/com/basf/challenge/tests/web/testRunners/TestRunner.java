package com.basf.challenge.tests.web.testRunners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//Default Test Runner. Used by the Gradle default "test" task.
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        features={"src/test/resources/features"},
//        tags={"@search"},
        glue = {"com.basf.challenge.tests.web.gherkinGlueCode"}
)
public class TestRunner {

}
