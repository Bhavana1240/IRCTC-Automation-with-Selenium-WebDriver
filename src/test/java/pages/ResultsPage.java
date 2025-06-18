package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ScreenshotUtil;

import java.time.Duration;

public class ResultsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void filterTimeSlots() {
        driver.findElement(By.xpath("//span[text()='Early Morning']")).click();
        driver.findElement(By.xpath("//span[text()='Morning']")).click();
        driver.findElement(By.xpath("//span[text()='Mid Day']")).click();
    }

    public void clickFirstSleeperAndBookNow() throws InterruptedException {
        WebElement firstTrain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'train-heading')])[1]")));
        WebElement classBlock = firstTrain.findElement(By.xpath("ancestor::div[contains(@class,'ng-star-inserted')]//td[1]"));
        classBlock.click();
        WebElement dateCell = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(., 'Mon, 28 Jul')]//div[contains(@class, 'pre-avl')]")));
        dateCell.click();
        WebElement bookNowBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'train_Search') and contains(text(),'Book Now')])[1]")));
        bookNowBtn.click();
        try {
            driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='login_header_disable']/div/div/div[2]/a")).click();
        } catch (Exception e) {
            System.out.println("Login popup not present.");
        }
        driver.findElement(By.xpath("//span[text()='Yes']")).click();
        
        
        ScreenshotUtil.takeScreenshot(driver, "AfterBookNow");

    }
}
