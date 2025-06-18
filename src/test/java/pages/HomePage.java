package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeLoginPopup() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='login_header_disable']/div/div/div[2]/a")).click();
        } catch (Exception e) {
            System.out.println("Login popup not present.");
        }
    }
}
