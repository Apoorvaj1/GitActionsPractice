package org.selenium.aj34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.selenium.aj34.Pages.HomePage;
import org.selenium.aj34.Pages.LoginPage;
import org.selenium.aj34.Pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected HomePage homePage;

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Parameters({"browser","headless"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browserName, @Optional("false") String headless){
        browserName = browserName.toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(headless);
        if(driver.get()==null){
            if(browserName.equals("chrome")){
                ChromeOptions chromeOptions = new ChromeOptions();
                if(isHeadless){
                    chromeOptions.addArguments("--headless");  // CI-friendly headless mode
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("window-size=1920,1080");
                }
                driver.set(new ChromeDriver(chromeOptions));
            } else if (browserName.equals("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                if(isHeadless){
                    edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("--disable-gpu");
                    edgeOptions.addArguments("window-size=1920,1080");
                }
                driver.set(new EdgeDriver(edgeOptions));
            } else if (browserName.equals("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                if(isHeadless){
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("window-size=1920,1080");
                }
                driver.set(new FirefoxDriver(options));
            } else {
                throw new RuntimeException("Browser not supported: " + browserName);
            }
        }
        WebDriver currentDriver = getDriver();
        if(driver.get()!=null){
            currentDriver.manage().window().maximize();
            currentDriver.manage().deleteAllCookies();
            currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            currentDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            this.mainPage = new MainPage(currentDriver);
            this.loginPage = new LoginPage(currentDriver);
            this.homePage = new HomePage(currentDriver);
        }
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        if(driver.get()!=null){
            Thread.sleep(2000);
            driver.get().quit();
            driver.remove();
        }
    }
}
