package org.selenium.aj34;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.selenium.aj34.Pages.HomePage;
import org.selenium.aj34.Pages.LoginPage;
import org.selenium.aj34.Pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest_1 {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected HomePage homePage;

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Parameters({"browser","headless","remote","env"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browserName, @Optional("false") String headless,@Optional("") String isRemote,@Optional("qa") String envSelect) throws MalformedURLException {
        browserName = browserName.toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(headless);
        String url="";
        if(isRemote.equalsIgnoreCase("local")){
            if(driver.get()==null){
                if(browserName.equals("chrome")){
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if(isHeadless){
                        chromeOptions.addArguments("--headless");  // CI-friendly headless mode
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver.set(new ChromeDriver(chromeOptions));
                } else if (browserName.equals("edge")) {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if(isHeadless){
                        edgeOptions.addArguments("--headless");
                        edgeOptions.addArguments("--disable-gpu");
                    }
                    driver.set(new EdgeDriver(edgeOptions));
                } else if (browserName.equals("firefox")) {
                    FirefoxOptions options = new FirefoxOptions();
                    if(isHeadless){
                        options.addArguments("--headless");
                        options.addArguments("--disable-gpu");
                    }
                    driver.set(new FirefoxDriver(options));
                } else {
                    throw new RuntimeException("Browser not supported: " + browserName);
                }
                switch (envSelect.toLowerCase()){
                    case "qa":
                        url = "https://naveenautomationlabs.com/opencart/index.php?route=common/home";
                        break;
                    case "uat":
                        url = "https://www.google.com";
                        break;
                    default:
                        System.out.println("Check URL again");
                        break;
                }
            }
        }
        if(isRemote.equalsIgnoreCase("remote")){
            if(driver.get()==null){
                DesiredCapabilities capabilities = new DesiredCapabilities();
                String remoteURL="http://localhost:4444/wd/hub";
                if(org.selenium.aj34.utils.ConfigReader.readKey("os").equalsIgnoreCase("windows")){
                    capabilities.setPlatform(Platform.WIN11);
                } else if (org.selenium.aj34.utils.ConfigReader.readKey("os").equalsIgnoreCase("mac")) {
                    capabilities.setPlatform(Platform.MAC);
                }
                else {
                    System.out.println("No matching os");
                }
                switch (browserName.toLowerCase()){
                    case "chrome":
                        capabilities.setBrowserName("chrome");
                        driver.set(new RemoteWebDriver(new URL(remoteURL),capabilities));
                        break;
                    default:
                        System.out.println("Check once again");
                        break;
                }
                switch (envSelect.toLowerCase()){
                    case "qa":
                        url = "https://naveenautomationlabs.com/opencart/index.php?route=common/home";
                        break;
                    case "uat":
                        url = "https://www.google.com";
                        break;
                    default:
                        System.out.println("Check URL again");
                        break;
                }
            }
        }
        WebDriver currentDriver = getDriver();
        if(driver.get()!=null){
            if(isHeadless){
                currentDriver.manage().window().setSize(new Dimension(1920, 1080));
            } else {
                currentDriver.manage().window().maximize();
            }
            currentDriver.manage().deleteAllCookies();
            currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            currentDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            currentDriver.get(url);
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
