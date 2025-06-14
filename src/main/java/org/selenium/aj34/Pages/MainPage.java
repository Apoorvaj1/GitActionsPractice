package org.selenium.aj34.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.aj34.Base.BaseClass;

public class MainPage extends BaseClass {

    public MainPage(WebDriver driver){
        super(driver);
    }

    private By myAccount = By.xpath("//span[text()=\"My Account\"]");
    private By login = By.xpath("//a[text()=\"Login\"]");

    public void clickMyAccount() {
        actions.moveToElement(driver.findElement(myAccount)).perform();
        clickElement(myAccount);
    }

    public LoginPage clickLogin(){
        actions.moveToElement(driver.findElement(login)).perform();
        clickElement(login);
        wait.until(ExpectedConditions.jsReturnsValue(
                "return document.readyState=='complete'"));
        return new LoginPage(driver);
    }
}
