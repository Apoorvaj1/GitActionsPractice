package org.selenium.aj34.Pages_Playwright;

import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.aj34.Base.BaseClass;
import org.selenium.aj34.Base.BaseClass_Playwright;

public class HomePage_Playwright extends BaseClass_Playwright {

    public HomePage_Playwright(Page page){
        super(page);
    }

    private String logoutOption = "//a[text()=\"Logout\"][@class=\"list-group-item\"]";

    public void verifyLogoutOption(){
        scrollToSpecificElement(logoutOption);
        visibilityOfElement(logoutOption);

    }

    public void clickLogoutOption() {
        clickElement(logoutOption);
    }


}
