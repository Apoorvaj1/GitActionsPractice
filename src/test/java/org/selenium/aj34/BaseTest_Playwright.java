package org.selenium.aj34;

import com.microsoft.playwright.*;
import org.selenium.aj34.Pages_Playwright.HomePage_Playwright;
import org.selenium.aj34.Pages_Playwright.LoginPage_Playwright;
import org.selenium.aj34.Pages_Playwright.MainPage_Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BaseTest_Playwright {

    private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
    protected MainPage_Playwright mainPage;
    protected HomePage_Playwright homePage;
    protected LoginPage_Playwright loginPage;

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getContext() {
        return tlContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    @Parameters({"browserType", "headless"})
    @BeforeMethod
    public void setUp(@Optional("edge") String browserType, @Optional("false") String headless){
        browserType = browserType.toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(headless);
        if(tlPlaywright.get() ==null){
            tlPlaywright.set(Playwright.create());
            List<String> options = new ArrayList<>();
            options.add("--start-maximized");
            if(browserType.equals("chromium")){
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setArgs(options).setHeadless(Boolean.parseBoolean(headless))));
            } else if (browserType.equals("chrome")) {
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setArgs(options).setHeadless(Boolean.parseBoolean(headless))));
            } else if (browserType.equals("firefox")) {
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setArgs(options).setHeadless(Boolean.parseBoolean(headless))));
            } else if (browserType.equals("webkit")) {
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setArgs(options).setHeadless(Boolean.parseBoolean(headless))));
            } else if (browserType.equals("edge")) {
                if (isHeadless) {
                    tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(Boolean.parseBoolean(headless))));
                } else {
                    tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setArgs(options).setChannel("msedge").setHeadless(Boolean.parseBoolean(headless))));
                }
            }
            else {
                throw new RuntimeException("Browser not supported: " + browserType);
            }
        }
        if(tlContext.get() == null){
            if(isHeadless){
                tlContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(1920,1080)));
            }
            else{
                tlContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(null).setRecordVideoDir(Paths.get("videos/")).setRecordVideoSize(800,600)));
            }
        }
        if (tlPage.get() == null) {
            tlPage.set(getContext().newPage());
        }
        Page currentPage = getPage();
        if (currentPage != null) {
            currentPage.setDefaultTimeout(30000);
            this.mainPage = new MainPage_Playwright(currentPage);
            this.loginPage = new LoginPage_Playwright(currentPage);
            this.homePage = new HomePage_Playwright(currentPage);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (tlPage.get() != null) {
            tlPage.get().close();
            tlPage.remove();
        }
        if (tlContext.get() != null) {
            tlContext.get().close();
            tlContext.remove();
        }
        if (tlBrowser.get() != null) {
            tlBrowser.get().close();
            tlBrowser.remove();
        }
        if (tlPlaywright.get() != null) {
            tlPlaywright.get().close();
            tlPlaywright.remove();
        }
    }
}
