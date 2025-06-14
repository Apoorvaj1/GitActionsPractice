package org.selenium.aj34.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.aj34.Base.BaseClass;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver){
        super(driver);
    }

    By logoutOption = By.xpath("//a[text()=\"Logout\"][@class=\"list-group-item\"]");

    public void verifyLogoutOption(){
        scrollToSpecificElement(logoutOption);
        visibilityOfElement(logoutOption);

    }
}
