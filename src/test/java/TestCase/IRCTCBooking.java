//package TestCase;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Scanner;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//import Base.BaseTest;
//
//public class IRCTCBooking extends BaseTest{
//   @Test
//	public void booking() throws InterruptedException {
//	   
//	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]"))));
//		driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]")).click();
//		Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"login_header_disable\"]/div/div/div[2]/a")).click();
//
//		//*[@id="login_header_disable"]/div/div/div[2]/a
//	   try {
////	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	        WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("//*[@id=\"login_header_disable\"]/div/div/div[2]/a")));  // Close (X) button on the popup
//	        if (closeBtn.isDisplayed()) {
//	            closeBtn.click();
//	            System.out.println("Login popup closed.");
//	            Thread.sleep(1000);
//	        }
//	    } catch (Exception e) {
//	        System.out.println("Login popup not present. Continuing...");
//	    } 
//		   
//	   
//	   Thread.sleep(1000);
//	   WebElement fromStation=driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input"));
//	   fromStation.click();
//	   Thread.sleep(1000);
//
//	   fromStation.sendKeys("Secunderabad");
//	   Thread.sleep(1000);
//	   fromStation.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//	   
//	   Thread.sleep(2000);
//	   
//	   WebElement toStation=driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input"));
//	   toStation.click();
//	   Thread.sleep(1000);
//
//	   toStation.sendKeys("Bengaluru");
//	   Thread.sleep(1000);
//	   toStation.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//	   
//	   Thread.sleep(2000);
//	   
////	   selecting the journey date
////	   step 1: open the calendar
//	   WebElement dateInput=driver.findElement(By.id("jDate"));
//	   dateInput.click();
//	   Thread.sleep(2000);
//
////	   Step 2: go till specified month
//	   while(true) {
//		   WebElement monthElem=driver.findElement(By.className("ui-datepicker-month"));
//		   WebElement yearElem=driver.findElement(By.className("ui-datepicker-year"));
//		   
//		   String month=monthElem.getText().trim();
//		   String year=yearElem.getText().trim();
//		   
//		   if(month.equals("July") && year.equals("2025"))
//			   break;
//		   else {
//			   WebElement nextButton=driver.findElement(By.cssSelector(".ui-datepicker-next"));
//			   nextButton.click();
//			   Thread.sleep(3000);
//		   }
//	   }
////	   select specified date
//	   List<WebElement> dates=driver.findElements(By.xpath("//td[not(contains(@class, 'ui-datepicker-other-month'))]/a[text()='28']"));
//	   for(WebElement date:dates) {
//		   if(date.isEnabled()) {
//			   date.click();
//			   break;
//		   }
//	   }
//	   
//	   Thread.sleep(2000);
////	   searching trains
//	   driver.findElement(By.xpath("//button[@class='search_btn train_Search']")).click();
//	   
//	   Thread.sleep(10000);
//	   
//	   driver.findElement(By.xpath("//span[text()='Early Morning']")).click();
//	   driver.findElement(By.xpath("//span[text()='Morning']")).click();
//	   driver.findElement(By.xpath("//span[text()='Mid Day']")).click();
//	   
////	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
////
////	// Wait until at least one train heading is visible
//	By trainHeadingLocator = By.xpath("//div[@class='col-sm-5 col-xs-11 train-heading']");
//	wait.until(ExpectedConditions.visibilityOfElementLocated(trainHeadingLocator));
////
////	// Get the list of trains fresh each time before interaction
//	List<WebElement> trainList = driver.findElements(trainHeadingLocator);
//	//
////		// Let's handle trains one by one
//		for (int i = 0; i < trainList.size(); i++) {
//		    // Re-find train list fresh each time to avoid stale elements
//		    trainList = driver.findElements(trainHeadingLocator);
//		    WebElement train = trainList.get(i);
//	        System.out.println(train.getText());
//	        Thread.sleep(2000);
//		}
//		System.out.println("The choosing and convinient train  :"+trainList.get(0));
//		List<WebElement> classBlocks = trainList.get(0).findElements(By.xpath(
//		        "(//div[contains(@class, 'train-heading')])[1]/ancestor::div[contains(@class,'ng-star-inserted')][1]//td"
//		    ));
//		    classBlocks.get(0).click();
//		    System.out.println(classBlocks.get(0).getText());
//		    WebElement date_element = wait.until(
//		    	    ExpectedConditions.elementToBeClickable((By.xpath("//td[contains(., 'Mon, 28 Jul')]//div[contains(@class, 'pre-avl')]")))
//		    	);
//		    date_element.click();
//		    System.out.println(date_element.getText());
//		    WebElement bookNowBtn = wait.until(ExpectedConditions.elementToBeClickable(
//		    	    By.xpath("(//button[contains(@class,'train_Search') and contains(text(),'Book Now')])[1]")));
//
//		    	bookNowBtn.click();
//	}
//}
//
package TestCase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Base.BaseTest;
import pages.HomePage;
import pages.SearchPage;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;
import pages.ResultsPage;

public class IRCTCBooking extends BaseTest {
    @Test
    public void bookTicket() throws Exception {
        ExtentTest test = extent.createTest("IRCTC Booking Test");
        ExtentReportManager.setTest(test);  // Store in ThreadLocal

        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver, prop);
        ResultsPage results = new ResultsPage(driver);

        home.closeLoginPopup();
        search.enterStations();
        search.selectJourneyDate();
        search.clickSearchTrains();
        Thread.sleep(10000);
        results.filterTimeSlots();
        results.clickFirstSleeperAndBookNow();

        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "AfterBookNow");
        ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);  // Now it works

        ExtentReportManager.getTest().pass("Booking steps completed successfully.");
    }
}
