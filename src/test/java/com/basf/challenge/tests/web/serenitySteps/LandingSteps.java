package com.basf.challenge.tests.web.serenitySteps;

import com.basf.challenge.tests.web.pageObjects.LandingPage;
import net.thucydides.core.annotations.Step;

public class LandingSteps {

    LandingPage landingPage;

    @Step
    public void verifyLandingPage() { landingPage.verifyLandingPage(); }

    @Step
    public void initSearch() { landingPage.initSearch(); }

    @Step
    public void enterCriteria(String query) {
        landingPage.enterCriteria(query);
    }

}