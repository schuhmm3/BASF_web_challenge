package com.basf.challenge.tests.web.gherkinGlueCode;

import com.basf.challenge.tests.web.serenitySteps.LandingSteps;
import com.basf.challenge.tests.web.serenitySteps.LoginSteps;
import com.basf.challenge.tests.web.serenitySteps.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchGlueCode {

    @Steps
    LoginSteps loginSteps;

    @Steps
    LandingSteps landingSteps;

    @Steps
    ResultsSteps resultsSteps;

    @Given("^a logged in user$")
    public void givenRegisteredUser() { loginSteps.login(); }

    @When("^performing a search with the following word ([^\"]*)$")
    public void search(String query) {
        landingSteps.initSearch();
        landingSteps.enterCriteria(query);
    }

    @Then("^each abstract of the top (\\d+) search results contains the word ([^\"]*)$")
    public void resultsContainsTheWord(int nRows, String query) {
        resultsSteps.checkAbstract(nRows, query);
    }
}
