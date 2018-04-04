package Test;


import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumTest {
	
	File currentDir = new File("");

	@Test
	public void testQA() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",currentDir.getAbsolutePath() + "\\web_driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.qa.com/");
		Thread.sleep(2000); // Let the user actually see something!
		assertEquals(driver.getCurrentUrl(), "https://www.qa.com/");

		driver.quit();

	}

}
