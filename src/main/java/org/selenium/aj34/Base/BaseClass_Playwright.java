package org.selenium.aj34.Base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BaseClass_Playwright {

    protected Page page;
    public BaseClass_Playwright(Page page){
        this.page = page;
    }

    public void clickElement(String locator) {
        page.locator(locator).click();
    }

    public void enterText(String locator, String text) {
        page.fill(locator, text);
    }
    public void visibilityOfElement(String locator) {
        page.locator(locator).isVisible();
    }

    public void hoverSpecificElement(String locator){
        page.locator(locator).hover();
    }

    public void scrollToSpecificElement(String locator) {
        Locator element = page.locator(locator);
        element.scrollIntoViewIfNeeded();
    }

    public String extractURL(){
        return page.url();
    }
}
