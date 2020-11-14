package com.basf.challenge.tests.web.serenitySteps;

import com.basf.challenge.tests.web.pageObjects.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {

    LoginPage loginPage;

    @Step
    public void openBrowser() { loginPage.openBrowserAndMaximize(); }

    @Step
    public void login() {
        loginPage.openBrowserAndMaximize();
        loginPage.login();
    }

}