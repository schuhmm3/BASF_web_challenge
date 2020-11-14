package com.basf.challenge.tests.web.gherkinGlueCode;

import com.basf.challenge.tests.web.serenitySteps.LandingSteps;
import com.basf.challenge.tests.web.serenitySteps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginGlueCode {

    @Steps
    LoginSteps loginSteps;

    @Steps
    LandingSteps landingSteps;

    @Given("a registered user$")
    public void givenAnUser() { loginSteps.openBrowser();}

    @When("They login with valid credentials$")
    public void login() {
        loginSteps.login();
    }

    @Then("^They will land into the QKnows QA page$")
    public void verifyLandingPage() {
        landingSteps.verifyLandingPage();
    }

}
