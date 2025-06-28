package org.selenium.aj34.Tests.Playwright_Practice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.selenium.aj34.BaseTest_Playwright;
import org.testng.annotations.Test;

public class Practice2_DropDown extends BaseTest_Playwright {

    @Test(enabled = false)
    public void test() throws InterruptedException {
        getPage().navigate("https://letcode.in/dropdowns");
        getPage().locator("//select[@id=\"superheros\"]").selectOption(new SelectOption().setLabel("Batman"));
        Thread.sleep(2000);

    }

    @Test
    public void test2() throws InterruptedException {
        getPage().navigate("https://letcode.in/dropdowns");
        Locator dropDown = getPage().locator("//select[@id=\"lang\"]");
        Locator options = dropDown.locator("option");
        System.out.println(options.count());
        for(int i=0;i<options.count();i++){
            System.out.println(options.nth(i).textContent());
        }
        dropDown.selectOption(new SelectOption().setIndex(options.count()-1));
        getPage().waitForLoadState(LoadState.LOAD);
        getPage().waitForLoadState();
        getPage().bringToFront();


        Thread.sleep(2000);
    }
}
