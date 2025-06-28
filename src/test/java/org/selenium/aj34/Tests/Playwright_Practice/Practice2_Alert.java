package org.selenium.aj34.Tests.Playwright_Practice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.selenium.aj34.BaseTest_Playwright;
import org.testng.annotations.Test;

public class Practice2_Alert extends BaseTest_Playwright {

    @Test
    public void test() throws InterruptedException {
        getPage().navigate("https://letcode.in/alert");
        getPage().onDialog(dialog ->{
            System.out.println(dialog.message());
            System.out.println(dialog.type());
            dialog.accept();
        });
        getPage().locator("//button[text()=\"Simple Alert\"]").click();
        Thread.sleep(3000);

    }

    @Test
    public void test2() throws InterruptedException {
        getPage().navigate("https://letcode.in/alert");
        getPage().onDialog(dialog ->{
            System.out.println(dialog.message());
            System.out.println(dialog.type());
            dialog.accept("Apoorv");
        });
        getPage().locator("//button[text()=\"Prompt Alert\"]").click();
        Thread.sleep(3000);
        getPage().locator("").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }
}
