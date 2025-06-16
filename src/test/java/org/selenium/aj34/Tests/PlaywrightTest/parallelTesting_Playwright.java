package org.selenium.aj34.Tests.PlaywrightTest;

import org.selenium.aj34.BaseTest_Playwright;
import org.selenium.aj34.utils.ConfigReader;
import org.testng.annotations.Test;

public class parallelTesting_Playwright extends BaseTest_Playwright {

    @Test
    public void test(){
        getPage().navigate("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
        mainPage.clickMyAccount();
        loginPage = mainPage.clickLogin();
        homePage = loginPage.enterLoginDetails();
        homePage.verifyLogoutOption();
        homePage.clickLogoutOption();
    }

    @Test
    public void test2(){
        getPage().navigate("https://www.amazon.in/?tag=msndeskstdin-21&ref=pd_sl_3oes7cd2fz_e&adgrpid=1324913168722107&hvadid=82807336663554&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=157422&hvtargid=kwd-82808007665574:loc-90&hydadcr=5620_2377278&msclkid=353df3ab8e281207a6f195456317b764");
        getPage().fill("//input[@id=\"twotabsearchtextbox\"]", ConfigReader.readKey("productName"));
        getPage().keyboard().press("Enter");


    }

}
