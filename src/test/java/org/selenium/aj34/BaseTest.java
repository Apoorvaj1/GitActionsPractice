package org.selenium.aj34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
                driver.set(new ChromeDriver());
            } else if (browserName.equals("edge")) {
                driver.set(new EdgeDriver());
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
