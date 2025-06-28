package org.selenium.aj34.Tests;

import org.selenium.aj34.BaseTest;
import org.selenium.aj34.BaseTest_1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest_1 {

    @Test
    public void clickLogin(){
        mainPage.clickMyAccount();
        loginPage = mainPage.clickLogin();
        String url = loginPage.loginUrl();
        System.out.println("URL is "+url);
        Assert.assertEquals(url,"https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        homePage = loginPage.enterLoginDetails();
        homePage.verifyLogoutOption();
    }

}
