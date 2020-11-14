package com.basf.challenge.tests.web.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ResultsPage extends BasePage {
    private final String url = "qknows-qa.basf.com/result";

    private final String XPATH_ROW_TITLE = "(//div[@class='search-result-title'])[@ROW_NUMBER@]/a";

    @FindBy(xpath = "//p[@class='abstract-wrapper']")
    private WebElementFacade abstractText;

    public void clickinRowTitle(int rowNumber) {
        verifyCurrentURL(url);

        final By byRowTitle = getDynamicXpath(XPATH_ROW_TITLE, "@ROW_NUMBER@", Integer.toString(rowNumber));
        waitAndClick(byRowTitle);
// Workaround: Sometimes after clicking title cursor hovers to Persons and the popup avoid clicking in next row title
        moveTo(byRowTitle);
    }

    public void verifyAbstract(String query) {
        abstractText.getText();
        Assert.assertTrue("Asbtract doesn't contain expected word", abstractText.getText().contains(query));
    }

}
