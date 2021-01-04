package adminModulePages;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.TestData;

public class Admin_Login_Page extends TestData{
	public WebDriver driver;
	public String str = randomString();
	public String licenseNumber = randomLicense();
	public String ssnNumber = randomSSN();
	public String zipCodes = randomZipcode();
	public String email1 = randomEmail();

	public Admin_Login_Page(WebDriver driver)
	{
		this.driver = driver;
	}

	//	TC001
	/*Bringing all the object page methods from "Admin_NewAccountRegistration_Page" class to Admin_Login_Tests class*/
	public void vLoginPageURL() throws IOException, InterruptedException
	{
		loginPageTestData();
		String expectedLoginpageURL = prop.getProperty("aLoginPageURL");
		System.out.println("\nExpected Admin Registration Page URL: " +expectedLoginpageURL);
		String actualLoginpageURL = driver.getCurrentUrl();
		System.out.println("Actual Admin Registration Page URL: " +actualLoginpageURL);

		Assert.assertEquals(actualLoginpageURL, expectedLoginpageURL);
		Thread.sleep(2000);
	}

	//TC002
	public void enterValidCredentials() throws IOException
	{
		loginPageTestData();
		userNameTextBox().sendKeys(prop.getProperty("aSKUserName")); 
		passwordTextBox().sendKeys(prop.getProperty("aSKPassword"));
	}

	By userNameLabel = By.xpath("//label[contains(text(),'Username')]"); 
	public WebElement userNameLabel()
	{
		return driver.findElement(userNameLabel);
	}

	By passwordLabel = By.xpath("//label[contains(text(),'Password')]"); 
	public WebElement passwordLabel()
	{
		return driver.findElement(passwordLabel);
	}

	By userNameTextBox = By.id("username"); 
	public WebElement userNameTextBox()
	{
		return driver.findElement(userNameTextBox);
	}

	By passwordTextBox = By.id("password"); 
	public WebElement passwordTextBox()
	{
		return driver.findElement(passwordTextBox);
	}

	By forgotUPLink = By.xpath("//a[contains(text(),'forgot Username / Password')]"); 
	public WebElement forgotUPLink()
	{
		return driver.findElement(forgotUPLink);
	}

	By registerButton = By.xpath("//body[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/p[7]/a[1]/input[1]");
	public WebElement registerButton()
	{
		return driver.findElement(registerButton);
	}

//	By emailID = By.id("email"); //Enter valid email id to get a new password in the event of forgotten password
	By emailID = By.xpath("//input[@id='email']");
	public WebElement emailID() throws IOException
	{
		return driver.findElement(emailID);
	}
	
	public void enterEmailID() throws IOException
	{
		loginPageTestData();
		emailID().sendKeys(prop.getProperty("aSKEmailID"));
		System.out.println(prop.getProperty("aSKEmailID"));
	}
	
//	By emailSendButton = By.xpath("//input[@type = 'submit']"); //OR
	By emailSendButton = By.xpath("//body/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/p[2]/input[1]");
	public WebElement emailSendButton() throws IOException
	{
		return driver.findElement(emailSendButton);
	}
	
	By homeTab = By.xpath("//span[contains(text(),'Claim Center')]");
	public WebElement homeTab()
	{
		return driver.findElement(homeTab);
	}
	
	By UsersTab = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]");
	public WebElement UsersTab()
	{
		return driver.findElement(UsersTab);
	}
	
	By claimCenter = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]");
	public WebElement claimCenter()
	{
		return driver.findElement(claimCenter);
	}
	
	By patientsTab = By.xpath("//span[contains(text(),'Patients')]");
	public WebElement patientsTab()
	{
		return driver.findElement(patientsTab);
	}
	
	By inidateAvailabilityTab = By.xpath("//span[contains(text(),'Indicate Availability')]");
	public WebElement inidateAvailabilityTab()
	{
		return driver.findElement(inidateAvailabilityTab);
	}
	
	By messagesTab = By.xpath("//span[contains(text(),'Messages')]");
	public WebElement messagesTab()
	{
		return driver.findElement(messagesTab);
	}
	
	By logOutTab = By.xpath("//span[contains(text(),'Logout')]");
	public WebElement logOutTab()
	{
		return driver.findElement(logOutTab);
	}	
	
	public void vAdministratorHomePageTabs()
	{
		WebElement[] allTabs = {homeTab(), UsersTab(), claimCenter(), patientsTab(), inidateAvailabilityTab(), messagesTab(), logOutTab()};
		for(int i=0; i<allTabs.length;i++)
		{
			boolean al1 = allTabs[i].isDisplayed();
			Assert.assertTrue(al1);
		}
		
		
	}


}


