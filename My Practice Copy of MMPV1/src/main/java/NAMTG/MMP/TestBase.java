package NAMTG.MMP;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TestData;

public class TestBase extends TestData {
	public WebDriver driver;
	
	public void initiateBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public void launchApplication() throws IOException, InterruptedException
	{
		homePageTestData();
		driver.get(prop.getProperty("hUrl"));
//		"http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/"
		
		
//		Validating HomePage URL
		String expectedHomePageUrl = prop.getProperty("hUrl");
		System.out.println("Expected Home Page URL: " +expectedHomePageUrl);
		String actualHomePageUrl = driver.getCurrentUrl();
		System.out.println("Actual Home Page URL: " +actualHomePageUrl);
		
		AssertJUnit.assertEquals(actualHomePageUrl, expectedHomePageUrl);
		Thread.sleep(2000);
		
	}
	
//	@Test
	/*public void execute() throws IOException, InterruptedException
	{
		initiateBrowser();
		launchApplication();
		
	}*/

}
