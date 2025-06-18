package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class SearchPage {
    WebDriver driver;
    Properties prop;
    WebDriverWait wait;

    public SearchPage(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterStations() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Wait for 'from station' input to be visible
        WebElement fromStation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='origin']/span/input")));
        fromStation.click();
        fromStation.sendKeys(prop.getProperty("fromStation"));
        Thread.sleep(1000);
        fromStation.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        
        try {
            driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='login_header_disable']/div/div/div[2]/a")).click();
        } catch (Exception e) {
            System.out.println("Login popup not present.");
        }

        // Wait for 'to station' input
        WebElement toStation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='destination']/span/input")));
        toStation.click();
        toStation.sendKeys(prop.getProperty("toStation"));
        Thread.sleep(1000);
        toStation.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }


    public void selectJourneyDate() throws InterruptedException {
        driver.findElement(By.id("jDate")).click();
        while (true) {
            String month = driver.findElement(By.className("ui-datepicker-month")).getText().trim();
            String year = driver.findElement(By.className("ui-datepicker-year")).getText().trim();
            if (month.equals(prop.getProperty("journeyMonth")) && year.equals(prop.getProperty("journeyYear"))) break;
            driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
            Thread.sleep(1000);
        }
        List<WebElement> dates = driver.findElements(By.xpath("//td[not(contains(@class, 'ui-datepicker-other-month'))]/a[text()='" + prop.getProperty("journeyDay") + "']"));
        for (WebElement date : dates) {
            if (date.isEnabled()) {
                date.click();
                break;
            }
        }
    }

    public void clickSearchTrains() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='search_btn train_Search']")).click();
        Thread.sleep(2000);
     }
}
