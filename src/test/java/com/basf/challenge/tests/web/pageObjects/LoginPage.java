package com.basf.challenge.tests.web.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import util.Consts;

public class LoginPage extends BasePage {
    private final String URL = "keycloak.qknows.basf.com/auth/realms/dev/protocol/openid-connect/auth";

    @FindBy(id = "username")
    private WebElementFacade userText;

    @FindBy(id = "password")
    private WebElementFacade passwordText;

    @FindBy(id = "kc-login")
    private WebElementFacade submitButton;

    public void login() {
        getDriver().get(getBaseUrl());
        verifyCurrentURL(URL);

        shouldBeVisible(userText);
        enterText(userText, Consts.DEFAULT_USER);
        shouldBeVisible(passwordText);
        enterText(passwordText, Consts.DEFAULT_PASSWORD);
        submitButton.submit();
    }


}
