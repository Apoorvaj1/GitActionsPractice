package org.selenium.aj34.Tests.Playwright_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class hoverAndSelectElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.myntra.com/");
        String resultProduct = "max1";
        String product = "Tops";
        int rounds = 0;
        boolean flag = false;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement kidsOption = driver.findElement(By.xpath("//a[text()=\"Kids\"][@class=\"desktop-main\"]"));
        action.moveToElement(kidsOption).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Kids\"][@class=\"desktop-main\"]")));
        action.moveToElement(driver.findElement(By.xpath("(//a[text()='"+product+"'])[1]"))).click().perform();
        WebElement price = driver.findElement(By.xpath("//div[@class=\"product-productMetaInfo\"]/h3[text()=\"max\"]/following-sibling::div"));
        while(rounds<4 && !flag){
            Thread.sleep(2000);
            List<WebElement> allProducts = driver.findElements(By.cssSelector(".product-productMetaInfo >h3"));
            for(WebElement productElement:allProducts){
                System.out.println(productElement.getText());
                if(productElement.getText().equals(resultProduct)){
                    System.out.println("Able to find max product");
                    js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",productElement);
                    price.click();
                    flag=true;
                    break;
                }
            }
            if(!flag){
                WebElement paginationText = driver.findElement(By.xpath("//div[@class=\"results-showMoreContainer\"]//li[@class=\"pagination-paginationMeta\"]"));
                WebElement nextButton = driver.findElement(By.xpath("//div[@class=\"results-showMoreContainer\"]//li[@class=\"pagination-next\"][text()=\"Next\"]"));
                js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",nextButton);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"results-showMoreContainer\"]//li[@class=\"pagination-paginationMeta\"]")));
                System.out.println(paginationText.getText());
                js.executeScript("arguments[0].click();",nextButton);
                rounds++;
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
