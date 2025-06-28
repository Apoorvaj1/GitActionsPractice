package org.selenium.aj34.Tests.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class screenshotTaker {

    public static void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File desc = new File(System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png");
        FileUtils.copyFile(src,desc);
    }
}
