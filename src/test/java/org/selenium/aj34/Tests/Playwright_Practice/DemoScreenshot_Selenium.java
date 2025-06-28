package org.selenium.aj34.Tests.Playwright_Practice;

import org.selenium.aj34.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DemoScreenshot_Selenium extends BaseTest {

    @Test
    public void test() throws IOException {
        getDriver().get("https://www.google.com");
        Assert.assertEquals(getDriver().getTitle(),"Yahoo");
    }
}
