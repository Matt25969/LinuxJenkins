package Test;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoTest {
	
	  WebDriver driver = null;

	    ExtentReports report;
	    ExtentTest test;
	    File currentDir = new File("");


	@Test
	public void DemoTest() throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver",currentDir.getAbsolutePath() + "\\web_driver/chromedriver.exe");
         driver = new ChromeDriver();
		
         report = new ExtentReports(currentDir.getAbsolutePath() + "\\demo_test.html", true);

         test = report.startTest("Demo Test");

         driver.manage().window().maximize();

         driver.get("http://thedemosite.co.uk");
         Thread.sleep(2000); // Let the user actually see something!
         String title = driver.getTitle();

         WebElement addAUser = driver.findElement(By.cssSelector(
                 "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
         addAUser.click();

         WebElement testUsernameField = driver.findElement(By.cssSelector(
                 "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
         testUsernameField.sendKeys("bert");
         Thread.sleep(1000);

         WebElement testPasswordField = driver.findElement(By.cssSelector(
                 "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
         testPasswordField.sendKeys("bert");
         Thread.sleep(1000);



         WebElement testButton = driver.findElement(By.cssSelector(
                 "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
         testButton.click();
         Thread.sleep(1000);

         test.log(LogStatus.INFO, "Set up user");

         WebElement login = driver.findElement(By.cssSelector(
                 "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
         login.click();



         WebElement loginUsernameField = driver.findElement(By.cssSelector(
                 "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
         loginUsernameField.sendKeys("bert");
         Thread.sleep(1000);
         WebElement loginPasswordField = driver.findElement(By.cssSelector(
                 "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
         loginPasswordField.sendKeys("bert");
         Thread.sleep(1000);
         WebElement loginButton = driver.findElement(By.cssSelector(
                 "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
         loginButton.click();
         Thread.sleep(1000);

         test.log(LogStatus.INFO, "Attempted to login");

         WebElement loginMessage = driver.findElement(By.cssSelector(
                 "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));

         assertEquals(loginMessage.getText(), "**Successful Login**");

         if (loginMessage.getText().equals("**Successful Login**")) {
             test.log(LogStatus.PASS, "Login valid");
         } else {
             test.log(LogStatus.FAIL, "Login failed");
         }

         driver.quit();
         report.endTest(test);
         report.flush();

		
		
		
	}

}
