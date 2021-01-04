package adminModulePages;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.TestData;

public class Admin_NewAccountRegistration_Page extends TestData{
	public WebDriver driver;
	public String str = randomString();
	public String licenseNumber = randomLicense();
	public String ssnNumber = randomSSN();
	public String zipCodes = randomZipcode();
	public String email1 = randomEmail();

	public Admin_NewAccountRegistration_Page(WebDriver driver)
	{
		this.driver = driver;
	}

	//	TC001

	public By firstHeaderTab = By.linkText("Home"); 
	public WebElement firstHeaderTab()
	{
		return driver.findElement(firstHeaderTab);
	}

	public By secondHeaderTab = By.linkText("Patient Login");
	public WebElement secondHeaderTab()
	{
		return driver.findElement(secondHeaderTab);
	}

	public By thirdHeaderTab = By.linkText("Office Login");
	public WebElement thirdHeaderTab()
	{
		return driver.findElement(thirdHeaderTab);
	}

	public By fourthHeaderTab = By.linkText("About Us");
	public WebElement fourthHeaderTab()
	{
		return driver.findElement(fourthHeaderTab);
	}

	public By fifthHeaderTab = By.linkText("Contact Us");
	public WebElement fifthHeaderTab()
	{
		return driver.findElement(fifthHeaderTab);
	}

	public By clickOfficeLogin = By.linkText("Office Login");
	public WebElement clickOfficeLogin()
	{
		return driver.findElement(clickOfficeLogin);
	}

	public void vHomePageHeaderTabsWay1()
	{
		//Validating HomePage Header tabs by calling "WebElement" methods in to "WebElement[]" array: Step4
		WebElement[] result = {firstHeaderTab(), 
				secondHeaderTab(), 
				thirdHeaderTab(),
				fourthHeaderTab(), 
				fifthHeaderTab()};
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = result[i].isDisplayed();
			Assert.assertTrue(r1);
		}

	}

	public void vHomePageHeaderTabsWay2()
	{
		//Validating HomePage Header tabs by calling "By" data/return type variables in to "By[]" array: Step4
		By[] headerTabs = {firstHeaderTab, 
				secondHeaderTab, 
				thirdHeaderTab, 
				fourthHeaderTab, 
				fifthHeaderTab};
		for(int i=0; i<headerTabs.length; i++)
		{
			boolean headerTabs1 = driver.findElement(headerTabs[i]).isDisplayed();
			Assert.assertTrue(headerTabs1);
		}
		
	}


	//TC002

	By vLoginPageMessage = By.xpath("//h2[contains(text(),'If you are a doctor and looking for simple ways to')]");
	public WebElement vLoginPageMessage() throws IOException
	{
		loginPageTestData();
		String expectedLoginPageMessage = prop.getProperty("aExpectedMessage");
		System.out.println("\nExpected Login Message: " +expectedLoginPageMessage);
		String actualLoginPageMessage = driver.findElement(By.xpath("//h2[contains(text(),'If you are a doctor and looking for simple ways to')]")).getText();
		System.out.println("Actual Login Message: " +actualLoginPageMessage);
		Assert.assertEquals(actualLoginPageMessage, expectedLoginPageMessage);
		return driver.findElement(vLoginPageMessage);
	}

	public void vARegistraionPageURL1() throws IOException
	{
		registrationPageTestData();
		String expectedRegistraionpageURL = prop.getProperty("aUrl1");
		System.out.println("\nExpected Admin Registration Page URL: " +expectedRegistraionpageURL);
		String actualRegistraionpageURL = driver.getCurrentUrl();
		System.out.println("Actual Admin Registration Page URL: " +actualRegistraionpageURL);

		Assert.assertEquals(actualRegistraionpageURL, expectedRegistraionpageURL);
	}

	public void vLabels_TextBoxes_Links_ButtonsWay1() throws InterruptedException
	{
		WebElement[] result = {userNameLabel(), passwordLabel(), userNameTextBox(), passwordTextBox(), forgotUPLink(), signInButton(), 
				registerButton()};
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
				registerButton};
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = driver.findElement(result[i]).isDisplayed();
			Assert.assertTrue(r1);
		}
		Thread.sleep(1000); 
	}

	/*By loginButton = By.linkText("Login");*/ //OR
	By loginButton = By.xpath("//body/section[@id='features']/div[@id='welcome']/div[1]/div[2]/a[1]"); 
	public WebElement loginButton()
	{
		return driver.findElement(loginButton);
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

	By signInButton = By.xpath("//body/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/p[6]/input[1]"); 
	public WebElement signInButton()
	{
		return driver.findElement(signInButton);
	}

	By registerButton = By.xpath("//body[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/p[7]/a[1]/input[1]");
	public WebElement registerButton()
	{
		return driver.findElement(registerButton);
	}

	public void vARegistraionPageURL2() throws IOException
	{
		registrationPageTestData();
		String expectedRegistraionpageURL = prop.getProperty("aUrl2");
		System.out.println("\nExpected Admin Registration Page URL: " +expectedRegistraionpageURL);
		String actualRegistraionpageURL = driver.getCurrentUrl();
		System.out.println("Actual Admin Registration Page URL: " +actualRegistraionpageURL);

		Assert.assertEquals(actualRegistraionpageURL, expectedRegistraionpageURL);
	}
	//TC003	

	//creating locator variables and its driver find element methods
	//Registraion Fields / Personal Details:
	public By firstName = By.id("firstname");
	public void firstName()
	{
		driver.findElement(firstName).sendKeys(str);
	}

	public By lastName = By.id("lastname");
	public void lastName()
	{
		driver.findElement(lastName).sendKeys(str);
	}
	
	public By userName = By.id("username");
	public void userName() throws IOException
	{
		registrationPageTestData();
		driver.findElement(userName).sendKeys(str); //
	}
	
	public By password = By.id("password");
	public void password() throws IOException
	{
		registrationPageTestData();
		driver.findElement(password).sendKeys(prop.getProperty("aSKPassword")); //str
	}

	public By confirmPassword = By.id("cpassword");
	public void confirmPassword() throws IOException
	{
		registrationPageTestData();
		driver.findElement(confirmPassword).sendKeys(prop.getProperty("aSKPassword")); //str
	}
	
	public By email = By.id("officecode");
	public void email() throws IOException
	{
		driver.findElement(email).sendKeys(email1 +"@gmail.com");
	}

	By clickSaveButton = By.name("save"); /*I did not give public access" modifier" for this By return type, because i'm not calling 
												this variable "clickSaveButton" in any other class yet*/	
	public WebElement clickSaveButton()
	{
		return driver.findElement(clickSaveButton);
	}

	public void handlingPopUp() throws IOException
	{
		Alert alert = driver.switchTo().alert();

		String expectedSuccessfullRegistrationValidation = prop.getProperty("aTYValidation");
		String actualSuccessfullRegistrationValidation = alert.getText();
		System.out.println("\nSuccessful Registration Message: " +actualSuccessfullRegistrationValidation);

		Assert.assertEquals(actualSuccessfullRegistrationValidation, expectedSuccessfullRegistrationValidation);

		alert.accept(); //clicked "OK" button on pop-up window

	}

	/*FirstWay of entering valid values: 
	 *By Creating locator "BY" variables (for ex:By clickPatientLogin = By.linkText("Patient Login"); 
	 *Then creating methods for driver elements (for ex: public WebElement clickPatientLogin() OR  public void firstName())
	 *And then creating one more method (for ex: enterValidValues()) to call all these driver element methods in one place... 
	 *So that this single method (enterValidValuesWay1()) can be called in test class to run the test)*/

	public void enterValidValuesWay1() throws IOException, InterruptedException
	{
		firstName();
		lastName();
		userName();
		password();
		confirmPassword();
		email();
		/*clickSaveButton().click();
		handlingPopUp();*/
	}

	/*SecondWay of entering valid values: 
	 *By Creating locator "BY" variables (for ex:By clickPatientLogin = By.linkText("Patient Login"); 
	 *Then creating one more method (for ex: enterValidValuesWay2()), in which, i created BY[] (for ex: By[] values) to call all these locator 
	 *variables in one array... 
	 *And then i have created String[] (for ex: String[] testData) to send all the send key values 
	 *So that this single method (enterValidValuesWay2) can be called in test class to run the test)*/

	//creating locator variables and its driver find element methods
	/*Third Way of entering valid values*/
	public void enterValidValuesWay2() throws IOException //using arrays and for loops
	{
		registrationPageTestData();

		/*	creating "By[]" array to call By variables*/
		By[] values = {firstName, lastName, userName, password, confirmPassword, email, };

		/*	creating "String[]" array to call sendkeys variables / values from .properties file & random methods */
		String[] testData = {str, str, prop.getProperty("aSKUserName"), prop.getProperty("aSKPassword"), 
							 prop.getProperty("aSKConfirmPassword"), email1 +"@gmail.com"};

		for(int i=0, j=0; i<values.length & j<testData.length; i++, j++) //Note: Created parallel for loop, not nested for loop
		{
			driver.findElement(values[i]).sendKeys(testData[i]);

		}

		/*		creating "String[]" array to call sendkeys variables / values from .properties file*/
		/*String[] testData = {prop.getProperty("SKFirstname"), prop.getProperty("SKLastname"), prop.getProperty("SKDOB"), 
						prop.getProperty("SKLicense"), prop.getProperty("SKSSN"), prop.getProperty("SKState"), 
						prop.getProperty("SKCity"), prop.getProperty("SKAddress"), prop.getProperty("SKZipcode"),
						prop.getProperty("SKAge"), prop.getProperty("SKHeight"), prop.getProperty("SKWeight"),
						prop.getProperty("SKPharma"), prop.getProperty("SKPharmaAddress"), prop.getProperty("SKEmail"),
						prop.getProperty("SKPassword"), prop.getProperty("SKUserName"), prop.getProperty("SKConfirmPassword"),
						prop.getProperty("SKanswerOfSecretQuestion")};

				for(int i=0, j=0; i<values.length & j<testData.length; i++, j++) //Note: Created parallel for loop, not nested for loop
				{
					driver.findElement(values[i]).sendKeys(testData[i]);

				}*/
		clickSaveButton().click();
		handlingPopUp();

	}


	public WebElement firstNameWay3()
	{
		return driver.findElement(firstName); 
	}

	public WebElement lastNameWay3()
	{
		return driver.findElement(lastName);
	}
	
	public WebElement userNameWay3() throws IOException
	{
		return driver.findElement(userName);
	}
	
	public WebElement passwordWay3() throws IOException
	{
		return driver.findElement(password);
	}

	public WebElement confirmPasswordWay3() throws IOException
	{
		return driver.findElement(confirmPassword);
	}
	
	public WebElement emailWay3() throws IOException
	{
		return driver.findElement(email);
	}

	/*public WebElement clickSaveButtonWay3()
	{
		return driver.findElement(clickSaveButton);
	}

	public void handlingPopUpWay3() throws IOException
	{
		Alert alert = driver.switchTo().alert();

		String expectedSuccessfullRegistrationValidation = prop.getProperty("TYValidation");
		String actualSuccessfullRegistrationValidation = alert.getText();
		System.out.println("Successful Registration Message: " +actualSuccessfullRegistrationValidation);

		Assert.assertEquals(actualSuccessfullRegistrationValidation, expectedSuccessfullRegistrationValidation);

		alert.accept(); //clicked "OK" button on pop-up window

	}*/

	public void enterValidValuesWay3() throws IOException, InterruptedException
	{
		//third way!! of Entering valid values to all the mandatory fields by calling "WebElement" methods: Step6
		registrationPageTestData();

		firstNameWay3().sendKeys(str);
		lastNameWay3().sendKeys(str);
		userNameWay3().sendKeys(prop.getProperty("aSKUserName"));
		passwordWay3().sendKeys(prop.getProperty("aSKPassword"));
		confirmPasswordWay3().sendKeys(prop.getProperty("aSKConfirmPassword"));
		emailWay3().sendKeys(email1 +"@gmail.com");
		
		clickSaveButton().click();
		handlingPopUp();

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


}


