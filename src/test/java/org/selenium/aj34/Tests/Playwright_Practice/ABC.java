package org.selenium.aj34.Tests.Playwright_Practice;

import org.testng.annotations.Test;

public class ABC {

    @Test
    public void test(){
        String name = System.getProperty("url");
        System.out.println("The url is "+name);
    }
}
