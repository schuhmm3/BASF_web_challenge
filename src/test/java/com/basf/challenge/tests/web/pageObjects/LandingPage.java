package com.basf.challenge.tests.web.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LandingPage extends BasePage {
    private final String URL = "qknows-qa.basf.com";
    private final String TITLE = "QKNOWS";

    // TODO: Identify better selector
    @FindBy(xpath = "(//div[@class='checkbox-box'])[1]")
    private WebElementFacade agreeCheckbox;

    @FindBy(xpath = "//div[@class='modal-dialog-control-submit']//button")
    private WebElementFacade proceedButton;

    @FindBy(id = "searchbar-activeinput")
    private WebElementFacade searchText;

    @FindBy(id = "searchbar-magnifier")
    private WebElementFacade searchButton;

    public void verifyLandingPage() {
        verifyCurrentURL(URL);
        agreeTerms();
        Assert.assertEquals("Title is not the expect one", TITLE, getDriver().getTitle());
    }

    public void initSearch() {
        verifyLandingPage();
    }

    public void agreeTerms() {
        waitAndClick(agreeCheckbox);
        waitAndClick(proceedButton);
    }

    public void enterCriteria(String query) {
        verifyCurrentURL(URL);

        searchText.waitUntilClickable();
        enterText(searchText, query);
        waitAndClick(searchButton);
    }

}
