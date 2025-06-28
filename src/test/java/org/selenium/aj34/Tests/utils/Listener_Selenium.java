package org.selenium.aj34.Tests.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.selenium.aj34.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener_Selenium implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName());
        try {
            screenshotTaker.takeScreenshot(BaseTest.getDriver());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (BaseTest.getDriver() != null) {
            System.out.println("Capturing screenshot for failed test: " + getTestMethodName(result));
            byte[] screenshot = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment(
                    "Screenshot on Failure", "image/png", "png", screenshot
            );
        } else {
            System.out.println("Driver is null; cannot capture screenshot.");
        }

        Allure.getLifecycle().addAttachment(
                "Failure Log", "text/plain", null,
                (getTestMethodName(result) + " failed and screenshot was taken!").getBytes()
        );

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getName());
    }
}
