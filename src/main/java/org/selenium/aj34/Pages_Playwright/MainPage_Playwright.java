package org.selenium.aj34.Pages_Playwright;

import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.aj34.Base.BaseClass;
import org.selenium.aj34.Base.BaseClass_Playwright;
import org.selenium.aj34.Pages.LoginPage;

public class MainPage_Playwright extends BaseClass_Playwright {

    public MainPage_Playwright(Page page){
        super(page);
    }

    private String myAccount = "//span[text()=\"My Account\"]";
    private String login = "//a[text()=\"Login\"]";

    public void clickMyAccount() {
        hoverSpecificElement(myAccount);
        clickElement(myAccount);
    }

    public LoginPage_Playwright clickLogin(){
        hoverSpecificElement(login);
        clickElement(login);
        return new LoginPage_Playwright(page);
    }
}
