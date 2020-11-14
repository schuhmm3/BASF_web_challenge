package com.basf.challenge.tests.web.pageObjects;

import groovy.util.logging.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Consts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Slf4j
/*
BasePage to be extended by any single PageObject: Contains common methods that can be used in any Web automation project
 */
public class BasePage extends PageObject {
    private final String baseUrl = Consts.BASE_URL;

    protected WebDriverWait getDefaultWait() {
        return (getWaitSeconds(Consts.WAIT_SECONDS_MEDIUM));
    }

    WebDriverWait getWaitSeconds(int seconds) {
        return new WebDriverWait(getDriver(), seconds);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void openBrowserAndMaximize() {
        getDriver().manage().deleteAllCookies();

        String userAgent = (String) ((JavascriptExecutor) this.getDriver()).executeScript("return navigator.userAgent;");

        System.out.println("\n INFO (Open and Maximize)");
        System.out.println("\n ------------------------");
        System.out.println("\n USER AGENT: " + userAgent);

        this.getDriver().manage().window().maximize();

        // Make sure browser moves to foreground -> not option by default in Mac
        getDriver().switchTo().window(getDriver().getWindowHandle());

    }

    protected void scrollToElement(WebElementFacade element) {
        element.waitUntilPresent();
        new Actions(this.getDriver()).moveToElement(element).perform();
    }

    public void scrollToTop() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0,0)");
    }

    public String getHtmlForPage() {
        return getDriver().getPageSource();

    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    protected void enterText(WebElementFacade element, String text) {
        enterText(element.getWrappedElement(), text);
    }

    void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void waitABit(final long timeInMilliseconds) {
        getClock().pauseFor(timeInMilliseconds);
    }

    public void verifyCurrentURL(String url) {
        getWaitSeconds(Consts.WAIT_PAGE_LOAD).until(ExpectedConditions.urlContains(url));
    }

    protected WebElement findWebElementWithDynamicXpath(String xpathValue, String placeholder, String substitutionValue) {
        return getDriver().findElement(getDynamicXpath(xpathValue, placeholder, substitutionValue));
    }

    protected By getDynamicXpath(String xpathValue, String placeholder, String substitutionValue) {
        return By.xpath(getDynamicXpathAsString(xpathValue, placeholder, substitutionValue));
    }

    protected String getDynamicXpathAsString(String xpathValue, String placeholder, String substitutionValue) {
        return xpathValue.replace(placeholder, substitutionValue);
    }

    protected void waitAndClick(By elementToSelect) {
        WebElementFacade webElementToSelect = find(elementToSelect);
        waitAndClick(webElementToSelect);
    }

    protected void waitAndClick(WebElementFacade elementToSelect) {
        elementToSelect.waitUntilVisible().waitUntilClickable().click();
    }

}
