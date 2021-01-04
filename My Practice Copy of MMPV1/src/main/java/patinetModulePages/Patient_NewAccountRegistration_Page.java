package patinetModulePages;

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import utilities.ProjectConfigurations;
import utilities.TestData;

public class Patient_NewAccountRegistration_Page extends TestData{
	public WebDriver driver;
	public String str = randomString();
	public String licenseNumber = randomLicense();
	public String ssnNumber = randomSSN();
	public String zipCodes = randomZipcode();
	public String email1 = randomEmail();
	

	public Patient_NewAccountRegistration_Page(WebDriver driver)
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

	public By clickPatientLogin = By.linkText("Patient Login");
	public WebElement clickPatientLogin()
	{
		return driver.findElement(clickPatientLogin);
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

	By vLoginPageMessage = By.xpath("//h1[contains(text(),'Now it is really simple to Claim your Insurance')]");
	public WebElement vLoginPageMessage() throws IOException
	{
		loginPageTestData();
		String expectedLoginPageMessage = prop.getProperty("pExpectedMessage");
		System.out.println("Expected Login Message: " +expectedLoginPageMessage);
		String actualLoginPageMessage = driver.findElement(By.xpath("//h1[contains(text(),'Now it is really simple to Claim your Insurance')]")).getText();
		System.out.println("Actual Login Message: " +actualLoginPageMessage);

		Assert.assertEquals(actualLoginPageMessage, expectedLoginPageMessage);
		return driver.findElement(vLoginPageMessage);
	}

	public void vLoginNRegisterButtons() throws InterruptedException
	{
		WebElement[] result = {loginButton(), registerButton()};
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = result[i].isDisplayed();
			Assert.assertTrue(r1);
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

	By upArrow = By.xpath("//i[@class = 'fa fa-arrow-up']");
	public WebElement clickUpArrow()
	{
		return driver.findElement(upArrow);
	}


	//TC003	

	//validate Registration Page Url:
	public void vPRegistrationPageURL() throws Exception
	{
		registrationPageTestData();
		String expectedUrl = prop.getProperty("pUrl");
		System.out.println("Expected Patient Registration Page URL: " +expectedUrl);
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Actual Patient Registration Page URL: " +actualUrl);

		Assert.assertEquals(actualUrl, expectedUrl);
	}

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

	public By DOB = By.id("datepicker");
	public void DOB() throws IOException
	{
		registrationPageTestData();
		driver.findElement(DOB).sendKeys(prop.getProperty("pSKDOB"));
	}

	public By license = By.id("license");
	public void license() throws IOException, InterruptedException
	{
		driver.findElement(license).sendKeys(licenseNumber);
		Thread.sleep(1000);

		/*WebElement l = driver.findElement(license);	
			l.sendKeys(licenseNumber);

			String val = l.getAttribute("value");
			System.out.println(l);

//			Assert.assertEquals(licenseNumber, l);*/
	}

	public By SSN = By.id("ssn");
	public void SSN() throws IOException
	{
//		driver.findElement(SSN).sendKeys(ssnNumber);
		driver.findElement(SSN).sendKeys(ssnNumber);
		System.out.println("Entered Patient SSN Number: " +ssnNumber);
		//Assert.assertEquals(ssnNumber, s);
	}
	
	public void captureSSN()
	{
		String ssn = ssnNumber;
		System.out.println("captured Patient SSN Number: " +ssn);
	}
			

	public By state = By.id("state");
	public void state() throws IOException
	{
		registrationPageTestData();
		driver.findElement(state).sendKeys(prop.getProperty("pSKState"));
	}

	public By city = By.id("city");
	public void city() throws IOException
	{
		registrationPageTestData();
		driver.findElement(city).sendKeys(prop.getProperty("pSKCity"));
	}

	public By address = By.id("address");
	public void address() throws IOException
	{
		registrationPageTestData();
		driver.findElement(address).sendKeys(prop.getProperty("pSKAddress"));
	}

	public By zipCode = By.id("zipcode");
	public void zipCode() throws IOException
	{
		driver.findElement(zipCode).sendKeys(zipCodes);
	}

	public By age = By.id("age");
	public void age() throws IOException
	{
		registrationPageTestData();
		driver.findElement(age).sendKeys(prop.getProperty("pSKAge"));
	}

	public By height = By.id("height");
	public void height() throws IOException
	{
		registrationPageTestData();
		driver.findElement(height).sendKeys(prop.getProperty("pSKHeight"));
	}

	public By weight = By.id("weight");
	public void weight() throws IOException
	{
		registrationPageTestData();
		driver.findElement(weight).sendKeys(prop.getProperty("pSKWeight"));
	}

	public By pharmacy = By.id("pharmacy");
	public void pharmacy() throws IOException
	{
		registrationPageTestData();
		driver.findElement(pharmacy).sendKeys(prop.getProperty("pSKPharma"));
	}

	public By pharmaAddress = By.id("pharma_adress");
	public void pharmaAddress() throws IOException
	{
		registrationPageTestData();
		driver.findElement(pharmaAddress).sendKeys(prop.getProperty("pSKPharmaAddress"));
	}

	//Registraion Fields / Account Details:
	public By email = By.id("email");
	public void email() throws IOException
	{
		driver.findElement(email).sendKeys(email1 +"@gmail.com");
	}

	public By password = By.id("password");
	public void password() throws IOException
	{
		registrationPageTestData();
		driver.findElement(password).sendKeys(prop.getProperty("pSKPassword")); 
//		System.out.println("PNARegistrationPWD: " +prop.getProperty("pSKPassword"));
	}
	
	public By userName = By.id("username");
	public void userName() throws IOException
	{
		driver.findElement(userName).sendKeys(str);
//		System.out.println("PRUserName: " +str);
	}
	
	public void capturedPatientRegisteredUserName() 
	{
		/*String un = "";
		System.out.println("Test w, local un: " +un);
		System.out.println("Test x, syso: " +driver.findElement(By.id("username")).getAttribute("value"));*/
		
		String un = driver.findElement(By.id("username")).getAttribute("value");
		System.out.println("Test y, locl un after assigning: " +un);
		Patient_NewAccountRegistration_Page.un=un;
	}
	
	public static String un;
	
	public void test()
	{
		System.out.println("Test public un in other method: " +un);
	}
	
	public By confirmPassword = By.id("confirmpassword");
	public void confirmPassword() throws IOException
	{
		registrationPageTestData();
		driver.findElement(confirmPassword).sendKeys(prop.getProperty("pSKPassword"));
	}

	public By securityQuestionAnswer = By.id("answer");
	public void securityQuestionAnswer() throws IOException
	{
		registrationPageTestData();
		driver.findElement(securityQuestionAnswer).sendKeys(prop.getProperty("pSKanswerOfSecretQuestion"));
	}

	By securityQuestion = By.id("security");
	public void selectSecurityQuestion()
	{
		Select selectSecretQ = new Select(driver.findElement(securityQuestion));
		//In above line, I have used "Select" class to select the value from drop down list of secret questions
		selectSecretQ.selectByVisibleText("what is your pet name"); 
	}

	By clickSaveButton = By.name("register"); /*I did not give public access" modifier" for this By return type, because i'm not calling 
												this variable "clickSaveButton" in any other class yet*/	
	public WebElement clickSaveButton()
	{
		return driver.findElement(clickSaveButton);
	}

	public void handlingPopUp() throws IOException
	{
		Alert alert = driver.switchTo().alert();

		String expectedSuccessfullRegistrationValidation = prop.getProperty("pTYValidation");
		String actualSuccessfullRegistrationValidation = alert.getText();
		System.out.println("Successful Registration Message: " +actualSuccessfullRegistrationValidation);

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
		DOB();
		license();
		SSN();
		state();
		city();
		address();
		zipCode();
		age();
		height();
		weight();
		pharmacy();
		pharmaAddress();
		email();
		password();
		userName();
		Thread.sleep(3000);
		confirmPassword();
		securityQuestionAnswer();
		selectSecurityQuestion();
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
			By[] values = {firstName, lastName, DOB, license, SSN, state, city, address, zipCode,
					age, height, weight, pharmacy, pharmaAddress, email, password, userName,
					confirmPassword, securityQuestionAnswer};

	/*	creating "String[]" array to call sendkeys variables / values from .properties file & random methods */
				String[] testData = {str, str, prop.getProperty("SKDOB"), licenseNumber, ssnNumber, prop.getProperty("SKState"), 
						prop.getProperty("SKCity"), prop.getProperty("SKAddress"), zipCodes,
						prop.getProperty("SKAge"), prop.getProperty("SKHeight"), prop.getProperty("SKWeight"),
						prop.getProperty("SKPharma"), prop.getProperty("SKPharmaAddress"), email1 +"@gmail.com",
						prop.getProperty("SKPassword"), str, prop.getProperty("SKConfirmPassword"),
						prop.getProperty("SKanswerOfSecretQuestion")};

				for(int i=0, j=0; i<values.length & j<testData.length; i++, j++) //Note: Created parallel for loop, not nested for loop
				{
					driver.findElement(values[i]).sendKeys(testData[j]);

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

		}
	
	
	public WebElement firstNameWay3()
	{
		return driver.findElement(firstName); 
	}
	
	public WebElement lastNameWay3()
	{
		return driver.findElement(lastName);
	}

	public WebElement DOBWay3() throws IOException
	{
		return driver.findElement(DOB);
	}

	public WebElement licenseWay3() throws IOException, InterruptedException
	{
		return driver.findElement(license);

		/*WebElement l = driver.findElement(license);	
			l.sendKeys(licenseNumber);

			String val = l.getAttribute("value");
			System.out.println(l);

//			Assert.assertEquals(licenseNumber, l);
		 */	}

	public WebElement SSNWay3() throws IOException
	{
		return driver.findElement(SSN);
	

		/*String s = driver.findElement(SSN).getText();
		System.out.println(s);
		//			Assert.assertEquals(ssnNumber, s);*/	}

	public WebElement stateWay3() throws IOException
	{
		return driver.findElement(state);
	}

	public WebElement cityWay3() throws IOException
	{
		return driver.findElement(city);
	}

	public WebElement addressWay3() throws IOException
	{
		return driver.findElement(address);
	}

	public WebElement zipCodeWay3() throws IOException
	{
		return driver.findElement(zipCode);
	}

	public WebElement ageWay3() throws IOException
	{
		return driver.findElement(age);
	}

	public WebElement heightWay3() throws IOException
	{
		return driver.findElement(height);
	}

	public WebElement weightWay3() throws IOException
	{
		return driver.findElement(weight);
	}

	public WebElement pharmacyway3() throws IOException
	{
		return driver.findElement(pharmacy);
	}

	public WebElement pharmaAddressWay() throws IOException
	{
		return driver.findElement(pharmaAddress);
	}

	//Registraion Fields / Account Details:
	public WebElement emailWay3() throws IOException
	{
		return driver.findElement(email);
	}

	public WebElement passwordWay3() throws IOException
	{
		return driver.findElement(password);
	}

	public WebElement userNameWay3() throws IOException
	{
		return driver.findElement(userName);
	}

	public WebElement confirmPasswordWay3() throws IOException
	{
		return driver.findElement(confirmPassword);
	}

	public WebElement securityQuestionAnswerWay3() throws IOException
	{
		return driver.findElement(securityQuestionAnswer);
	}

	public void selectSecurityQuestionWay3()
	{
		Select selectSecretQ = new Select(driver.findElement(securityQuestion));
		//In above line, I have used "Select" class to select the value from drop down list of secret questions
		selectSecretQ.selectByVisibleText("what is your pet name"); 
	}

	public WebElement clickSaveButtonWay3()
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

	}
	
	public void enterValidValuesWay3() throws IOException, InterruptedException
	{
		//third way!! of Entering valid values to all the mandatory fields by calling "WebElement" methods: Step6
		registrationPageTestData();
		
		firstNameWay3().sendKeys(str);
		lastNameWay3().sendKeys(str);
		DOBWay3().sendKeys(prop.getProperty("SKDOB"));
		licenseWay3().sendKeys(licenseNumber);
		SSNWay3().sendKeys(ssnNumber);
		stateWay3().sendKeys(prop.getProperty("SKState"));
		cityWay3().sendKeys(prop.getProperty("SKCity"));
		addressWay3().sendKeys(prop.getProperty("SKAddress"));
		zipCodeWay3().sendKeys(zipCodes);
		ageWay3().sendKeys(prop.getProperty("SKAge"));
		heightWay3().sendKeys(prop.getProperty("SKHeight"));
		weightWay3().sendKeys(prop.getProperty("SKWeight"));
		pharmacyway3().sendKeys(prop.getProperty("SKPharma"));
		pharmaAddressWay().sendKeys(prop.getProperty("SKPharmaAddress"));
		emailWay3().sendKeys(email1 +"@gmail.com");
		userNameWay3().sendKeys(str);
		passwordWay3().sendKeys(prop.getProperty("SKPassword"));
		confirmPasswordWay3().sendKeys(prop.getProperty("SKConfirmPassword"));
		securityQuestionAnswerWay3().sendKeys(prop.getProperty("SKanswerOfSecretQuestion"));
		selectSecurityQuestionWay3();
//		clickSaveButton().click();
//		handlingPopUpWay3();
		
	}
	
	











































	//*******************************************************************************************************************
	
		/*public Patient_NewAccountRegistration_Page(String un)
		{
			By userName = By.id("username");
			driver.findElement(userName).sendKeys(str);
			un = str;
			this.str = un;
			System.out.println("PRUN: " +str);
		}*/
		
		
		/*public By userName = By.id("username");
		public String userName() throws IOException
		{
			String un = str;
			this.un = un;
			System.out.println("PRUN: " +un);
			driver.findElement(userName).sendKeys(un);
			return userName();
			
		}*/
		
		/*public String capturePatientUserName()
		{
			String un = str;
			System.out.println(str);
			return un;
		}*/
		
		/*public void cun1()
		{
			System.out.println("Test: " +driver.findElement(By.id("username")).getAttribute("value"));
			un = driver.findElement(By.id("username")).getAttribute("value");
			System.out.println("Test X: " +un);
			this.cun(un);
		}*/
		
	/*	public void capturedPUN()
		{
			System.out.println("Test: " +driver.findElement(By.id("username")).getAttribute("value"));
			String pun = driver.findElement(By.id("username")).getAttribute("value");
			System.out.println("test: " +pun);
			this.pUN = pun;
		}*/
		
		/*public Patient_NewAccountRegistration_Page(String pUN)
		{
			pUN = driver.findElement(By.id("username")).getAttribute("value");
			
		}*/
	//*******************************************************************************************************************

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


