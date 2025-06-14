package org.selenium.aj34;

import org.testng.annotations.Test;


public class Pro1Test extends BaseTest {

    @Test
    public void test1(){
        getDriver().get("https://www.facebook.com");
        System.out.println("Title: " + getDriver().getTitle());
    }
}
