package org.selenium.aj34.Tests.PlaywrightTest;

import org.selenium.aj34.BaseTest_Playwright;
import org.testng.annotations.Test;

public class LoginPageTest_Playwright extends BaseTest_Playwright {

    @Test
    public void test(){
        getPage().navigate("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
        mainPage.clickMyAccount();
        loginPage = mainPage.clickLogin();
        homePage = loginPage.enterLoginDetails();
        homePage.verifyLogoutOption();
        homePage.clickLogoutOption();
        System.out.println("Hello World");
    }

}
