
package org.selenium.aj34.Tests.Playwright_Practice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import org.selenium.aj34.BaseTest_Playwright;
import org.testng.annotations.Test;

public class Practice2_Droppable extends BaseTest_Playwright {

    @Test
    public void test() throws InterruptedException {
       getPage().navigate("https://jqueryui.com/droppable/");
       var frame = getPage().frameLocator("//iframe[@class=\"demo-frame\"]");
       Locator draggable = frame.locator("//div[@id=\"draggable\"]");
       Locator droppable = frame.locator("//div[@id=\"droppable\"]");
       draggable.dragTo(droppable);

    }

}
