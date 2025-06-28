package org.selenium.aj34.Tests.Playwright_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Set;

public class Practice_Window_Selenium {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://letcode.in/window");
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("button#home")).click();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles.size());
        for(String handle:handles){
            if(!handle.equals(mainWindow)){
                driver.switchTo().window(handle);
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
