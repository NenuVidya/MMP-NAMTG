

package patinetModulePages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.TestData;

public class Patient_Login_Page extends TestData{
	public WebDriver driver;
	public String str = randomString();
	public String licenseNumber = randomLicense();
	public String ssnNumber = randomSSN();
	public String zipCodes = randomZipcode();
	public String email1 = randomEmail();
	
	public Patient_NewAccountRegistration_Page pnar;
	
	public Patient_Login_Page(WebDriver driver)
	{
		this.driver = driver;
	}

	//	TC001
	/*Bringing all the object page methods from "Patient_NewAccountRegistration_Page" class to Admin_Login_Tests class*/

	//TC002

	public void vLoginNRegisterButtons() throws InterruptedException
	{
		By[] vLoginNRegisterButtons = {loginButton, registerButton};
		for(int i=0; i<vLoginNRegisterButtons.length;i++)
		{
			boolean vLNR = driver.findElement(vLoginNRegisterButtons[i]).isDisplayed();
			Assert.assertTrue(vLNR);
		}
		Thread.sleep(1000); 
	}

	By loginButton = By.linkText("Login"); 
	public WebElement loginButton()
	{
		return driver.findElement(loginButton);
	}

	By registerButton = By.linkText("Register");
	public WebElement registerButton()
	{
		return driver.findElement(registerButton);
	}
	
	public void vPLoginPageURL() throws IOException
	{
		loginPageTestData();
		String expectedPatientLoinPageURL = prop.getProperty("pLoginPageURL");
		System.out.println("Expected Patient login page URL: " +expectedPatientLoinPageURL);
		String actualPatientLoinPageURL = driver.getCurrentUrl();
		System.out.println("Actual Patient login page URL: " +actualPatientLoinPageURL);
		
		Assert.assertEquals(actualPatientLoinPageURL, expectedPatientLoinPageURL);
	}
	
	public void vLabels_TextBoxes_Links_ButtonsWay1() throws InterruptedException
	{
		WebElement[] result = {userNameLabel(), passwordLabel(), userNameTextBox(), passwordTextBox(), forgotUPLink(), signInButton(), 
				plpRegisterButton()};
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = result[i].isDisplayed();
			Assert.assertTrue(r1);
		}
		Thread.sleep(1000); 
	}
	
	public void vLabels_TextBoxes_Links_ButtonsWay2() throws InterruptedException
	{
		By[] result = {userNameLabel, passwordLabel, userNameTextBox, passwordTextBox, forgotUPLink, signInButton, 
				plpRegisterButton};
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = driver.findElement(result[i]).isDisplayed();
			Assert.assertTrue(r1);
		}
		Thread.sleep(1000); 
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

	//	//a[contains(text(),'forgot Username / Password')]

	By plpRegisterButton = By.xpath("//body[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/p[7]/a[1]/input[1]");
	public WebElement plpRegisterButton()
	{
		return driver.findElement(plpRegisterButton);
	}
	
	/*public By userName = By.id("username");
	public void userName() throws IOException
	{
		loginPageTestData();
		driver.findElement(userName).sendKeys(prop.getProperty("pSKUserName"));
	}*/
	
	public By userName = By.id("username");
	public void userName() throws IOException, InterruptedException
	{
		pnar = new Patient_NewAccountRegistration_Page(driver);
		System.out.println("pnar un: " +pnar.un); //Patient_NewAccountRegistration_Page.un
		driver.findElement(userName).sendKeys(pnar.un); //Patient_NewAccountRegistration_Page.un
	}

	public By password = By.id("password");
	public void password() throws IOException
	{
		loginPageTestData();
		driver.findElement(password).sendKeys(prop.getProperty("pSKPassword")); //OR Ria12345
	}
	
	public void enterValidPatientCredtials() throws IOException, InterruptedException
	{
		userName();
		password();
	}
	
	By signInButton = By.xpath("//body/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/p[6]/input[1]"); 
	public WebElement signInButton()
	{
		return driver.findElement(signInButton);
	}

	public void handlingPopUp() throws IOException
	{
		Alert alert = driver.switchTo().alert();

		/*String expectedLoginErrorMessage = prop.getProperty("pvLoginErrorMessage");
		String actualLoginErrorMessage = alert.getText();
		System.out.println("Successful Registration Message: " +actualLoginErrorMessage);

		Assert.assertEquals(actualLoginErrorMessage, expectedLoginErrorMessage);*/

		alert.accept(); //clicked "OK" button on pop-up window

	}
	
	

	
		
	}
	
	













































	//Nothing is working :(

	/*public WebElement[] headerTabs()
	{
		WebElement[] a = {driver.findElement(By.linkText("Home")), driver.findElement(By.linkText("Patient Login")), 
						  driver.findElement(By.linkText("Office Login")), driver.findElement(By.linkText("About Us")),
						  driver.findElement(By.linkText("Contact Us"))};
		this.a = a;

		return a;

	}*/


	/*public WebElement[] headerTabs()
	{
		driver.findElement(By.linkText("Home"));
		driver.findElement(By.linkText("Patient Login")); 
		driver.findElement(By.linkText("Office Login"));
		driver.findElement(By.linkText("About Us"));
		driver.findElement(By.linkText("Contact Us"));

		return headerTabs();

	}*/





