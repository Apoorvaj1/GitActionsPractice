package org.selenium.aj34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Pro2Test extends BaseTest {

    @Test
    public void test1(){
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.uber.com");
        System.out.println("Title: " + driver.getTitle());
    }
}
