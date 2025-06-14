package org.selenium.aj34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browserName){
        browserName = browserName.toLowerCase();
        if(driver.get()==null){
            if(browserName.equals("chrome")){
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");  // CI-friendly headless mode
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
                driver.set(new ChromeDriver(chromeOptions));
            } else if (browserName.equals("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--disable-gpu");
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--user-data-dir=/tmp/edge-profile-" + System.currentTimeMillis());
                driver.set(new EdgeDriver(edgeOptions));
            } else if (browserName.equals("firefox")) {
                driver.set(new FirefoxDriver());
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
        }
    }


    @AfterMethod
    public void tearDown(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }
}
