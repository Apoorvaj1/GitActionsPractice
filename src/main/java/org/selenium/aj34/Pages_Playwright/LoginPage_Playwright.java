package org.selenium.aj34.Pages_Playwright;

import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.aj34.Base.BaseClass;
import org.selenium.aj34.Base.BaseClass_Playwright;
import org.selenium.aj34.Pages.HomePage;
import org.selenium.aj34.utils.ConfigReader;

public class LoginPage_Playwright extends BaseClass_Playwright {

    public LoginPage_Playwright(Page page){
        super(page);
    }

    private String emailAddress = "#input-email";
    private String password = "#input-password";
    private String loginButton = "//input[@type=\"submit\"]";

    public String loginUrl(){
        return page.url();
    }

    public void enterEmailAddress() {
        enterText(emailAddress, ConfigReader.readKey("email"));
    }

    public void enterPassword(){
        enterText(password,ConfigReader.readKey("password"));
    }

    public void clickLogin(){
        clickElement(loginButton);
    }

    public HomePage_Playwright enterLoginDetails(){
        enterEmailAddress();
        enterPassword();
        clickLogin();
        return new HomePage_Playwright(page);
    }
}
