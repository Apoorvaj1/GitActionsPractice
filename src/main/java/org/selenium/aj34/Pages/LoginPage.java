package org.selenium.aj34.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.aj34.Base.BaseClass;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    By emailAddress = By.cssSelector("#input-email");
    By password = By.cssSelector("#input-password");
    By loginButton = By.xpath("//input[@type=\"submit\"]");

    public String loginUrl(){
        return driver.getCurrentUrl();
    }

    public void enterEmailAddress() {
        enterText(emailAddress,"ravi123@gmail.com");
    }

    public void enterPassword(){
        enterText(password,"Rules@123");
    }

    public void clickLogin(){
        clickElement(loginButton);
    }

    public HomePage enterLoginDetails(){
        enterEmailAddress();
        enterPassword();
        clickLogin();
        return new HomePage(driver);
    }
}
