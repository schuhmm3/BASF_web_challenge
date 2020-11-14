package com.basf.challenge.tests.web.serenitySteps;

import com.basf.challenge.tests.web.pageObjects.ResultsPage;
import net.thucydides.core.annotations.Step;

public class ResultsSteps {

    ResultsPage resultsPage;

    @Step
    public void checkAbstract(int nRows, String query) {
        for (int ix = 1; ix <= nRows; ix++) {
            resultsPage.clickinRowTitle(ix);
            resultsPage.verifyAbstract(query);
        }
    }

}