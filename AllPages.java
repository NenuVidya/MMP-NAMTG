package consolidatedPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;

import utilities.TestData;

public class AllPages extends TestData {
	WebDriver driver;
	public String str = randomString();
	public String licenseNumber = randomLicense();
	public String ssnNumber = randomSSN();
	public String zipCodes = randomZipcode();
	public String email1 = randomEmail();
//	public String pun;
	
	public AllPages(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/*Patient New Account Registration Flow*/
	public By clickPatientLogin = By.linkText("Patient Login");
	public WebElement clickPatientLogin()
	{
		return driver.findElement(clickPatientLogin);
	}
	
	By vLoginPageMessage = By.xpath("//h1[contains(text(),'Now it is really simple to Claim your Insurance')]");
	public void vLoginPageMessage() throws IOException, InterruptedException
	{
		loginPageTestData();
		String expectedLoginPageMessage = prop.getProperty("pExpectedMessage");
		System.out.println("Expected Login Message: " +expectedLoginPageMessage);
		String actualLoginPageMessage = driver.findElement(By.xpath("//h1[contains(text(),'Now it is really simple to Claim your Insurance')]")).getText();
		System.out.println("Actual Login Message: " +actualLoginPageMessage);

		AssertJUnit.assertEquals(actualLoginPageMessage, expectedLoginPageMessage);
		Thread.sleep(1000);
	}
	
	By registerButton = By.linkText("Register");
	public WebElement registerButton()
	{
		return driver.findElement(registerButton);
	}
	
	public void validatingRegistrationPageURL() throws Exception
	{
		registrationPageTestData();
		String expectedUrl = prop.getProperty("pUrl");
		System.out.println("Expected Registration Page URL: " +expectedUrl);
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Actual Registration Page URL: " +actualUrl);

		Assert.assertEquals(actualUrl, expectedUrl);
//		Thread.sleep(7000);
	}
	
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
		Thread.sleep(2000);

		/*WebElement l = driver.findElement(license);	
			l.sendKeys(licenseNumber);

			String val = l.getAttribute("value");
			System.out.println(l);

//			Assert.assertEquals(licenseNumber, l);
		 */	}

	public By SSN = By.id("ssn");
	public void SSN() throws IOException
	{
//		driver.findElement(SSN).sendKeys(ssnNumber);
		driver.findElement(SSN).sendKeys(ssnNumber);

		String s = driver.findElement(SSN).getText();
		System.out.println(s);
		//Assert.assertEquals(ssnNumber, s);
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
	}

	public By userName = By.id("username");
	public void userName() throws IOException
	{
		driver.findElement(userName).sendKeys(str);
		System.out.println("abc: " +str);
	}
	
	/*public void pUN() //pUN = Patient User Name
	{
		System.out.println("Captured Patient User Name: " +driver.findElement(userName).getAttribute("value"));
		
		pun = driver.findElement(userName).getAttribute("value");
		System.out.println("me: " +pun);
		
//		driver.findElement(By.linkText(pun1)).click();
	}*/
	
	public By confirmPassword = By.id("confirmpassword");
	public void confirmPassword() throws IOException
	{
		registrationPageTestData();
		driver.findElement(confirmPassword).sendKeys(prop.getProperty("pSKConfirmPassword"));
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
	public WebElement clickSaveButton() throws InterruptedException
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
		Thread.sleep(2000);
		confirmPassword();
		securityQuestionAnswer();
		selectSecurityQuestion();
		/*clickSaveButton().click();
		handlingPopUp();*/
	}
//*****************************************************************************************************************************************

	/*Patient Login Flow*/
	By loginButton = By.linkText("Login"); 
	public WebElement loginButton()
	{
		return driver.findElement(loginButton);
	}
	
	public By loginUserName = By.id("username");
	public void loginUserName() throws IOException
	{
		loginPageTestData();
		driver.findElement(loginUserName).sendKeys(str); //prop.getProperty("pSKUserName")
		System.out.println(str);
	}
	
	public By loginPassword = By.id("password");
	public void loginPassword() throws IOException
	{
		loginPageTestData();
		driver.findElement(loginPassword).sendKeys(prop.getProperty("pSKPassword"));
	}
	
	public void enterPatentLoginCredentials() throws IOException
	{
		loginUserName();
		loginPassword();
		/*signInButton().click();
		handlingLoginPopUp();*/
	}
	
	
	By signInButton = By.xpath("//input[@value = 'Sign In']");
	public WebElement signInButton()
	{
		return driver.findElement(signInButton);
	}
	
	public void handlingLoginPopUp() throws IOException
	{
		Alert alert = driver.switchTo().alert();

		String expectedLoginErrorMessageValidation = prop.getProperty("pvLoginErrorMessage");
		String actualLoginErrorMessageValidation = alert.getText();
		System.out.println("Successful Registration Message: " +actualLoginErrorMessageValidation);

		Assert.assertEquals(actualLoginErrorMessageValidation, expectedLoginErrorMessageValidation);
		alert.accept(); //clicked "OK" button on pop-up window
	}
//****************************************************************************************************************************************
	
	/*Admin New Account Registration Flow*/
	public By clickOfficeLogin = By.linkText("Office Login");
	public WebElement clickOfficeLogin()
	{
		return driver.findElement(clickOfficeLogin);
	}
	
	By vAdminLoginPageMessage = By.xpath("//h2[contains(text(),'If you are a doctor and looking for simple ways to')]");
	public WebElement vAdminLoginPageMessage() throws IOException
	{
		loginPageTestData();
		String expectedLoginPageMessage = prop.getProperty("aExpectedMessage");
		System.out.println("\nExpected Login Message: " +expectedLoginPageMessage);
		String actualLoginPageMessage = driver.findElement(By.xpath("//h2[contains(text(),'If you are a doctor and looking for simple ways to')]")).getText();
		System.out.println("Actual Login Message: " +actualLoginPageMessage);
		Assert.assertEquals(actualLoginPageMessage, expectedLoginPageMessage);
		return driver.findElement(vLoginPageMessage);
	}
	
	/*By loginButton = By.linkText("Login");*/ //OR
	By adminLoginButton = By.xpath("//body/section[@id='features']/div[@id='welcome']/div[1]/div[2]/a[1]"); 
	public WebElement adminLoginButton()
	{
		return driver.findElement(adminLoginButton);
	}
	
	By adminRegisterButton = By.xpath("//body[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/p[7]/a[1]/input[1]");
	public WebElement adminRegisterButton()
	{
		return driver.findElement(adminRegisterButton);
	}
	
	public void vRegistraionPageURL() throws IOException
	{
		registrationPageTestData();
		String expectedRegistraionpageURL = prop.getProperty("aUrl");
		System.out.println("\nExpected Admin Registration Page URL: " +expectedRegistraionpageURL);
		String actualRegistraionpageURL = driver.getCurrentUrl();
		System.out.println("Actual Admin Registration Page URL: " +actualRegistraionpageURL);

		Assert.assertEquals(actualRegistraionpageURL, expectedRegistraionpageURL);
	}
	
	public By aFirstName = By.id("firstname");
	public void aFirstName()
	{
		driver.findElement(aFirstName).sendKeys(str);
	}

	public By aLastName = By.id("lastname");
	public void aLastName()
	{
		driver.findElement(aLastName).sendKeys(str);
	}
	
	public By aUserName = By.id("username");
	public void aUserName() throws IOException
	{
		registrationPageTestData();
		driver.findElement(aUserName).sendKeys(str); //prop.getProperty("aSKUserName")
	}
	
	public By aPassword = By.id("password");
	public void aPassword() throws IOException
	{
		registrationPageTestData();
		driver.findElement(aPassword).sendKeys(prop.getProperty("aSKPassword"));
	}

	public By aConfirmPassword = By.id("cpassword");
	public void aConfirmPassword() throws IOException
	{
		registrationPageTestData();
		driver.findElement(aConfirmPassword).sendKeys(prop.getProperty("aSKPassword"));
	}
	
	public By aEmail = By.id("officecode");
	public void aEmail() throws IOException
	{
		driver.findElement(aEmail).sendKeys(email1 +"@gmail.com");
	}

	By aClickSaveButton = By.name("save"); /*I did not give public access" modifier" for this By return type, because i'm not calling 
												this variable "clickSaveButton" in any other class yet*/	
	public WebElement aClickSaveButton()
	{
		return driver.findElement(aClickSaveButton);
	}

	public void aHandlingPopUp() throws IOException
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

	public void enterAdminValidValues() throws IOException, InterruptedException
	{
		aFirstName();
		aLastName();
		aUserName();
		aPassword();
		aConfirmPassword();
		aEmail();
		/*aClickSaveButton().click();
		aHandlingPopUp();*/
	}
//****************************************************************************************************************************************
	/*Admin Login Flow*/
	
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
		
	public void enterValidCredentials() throws IOException, InterruptedException
	{
		loginPageTestData();
		Thread.sleep(1000);
		userNameTextBox().sendKeys(str); //prop.getProperty("aSKUserName")
		System.out.println(str);
		passwordTextBox().sendKeys(prop.getProperty("aSKPassword"));
	}
	
	By aSignInButton = By.xpath("//body/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/p[6]/input[1]"); 
	public WebElement aSignInButton()
	{
		return driver.findElement(aSignInButton);
	}
	
	By UsersTab = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]");
	public WebElement UsersTab()
	{
		return driver.findElement(UsersTab);
	}
	
	By selectPatient = By.linkText("onxskatvhb"); //pun2
	public WebElement selectPatientWay1() throws IOException
	{
		return driver.findElement(selectPatient);
	}
	
	/*By selectPatient1 = By.linkText(pun); //pun2
	public WebElement selectPatientWay2() throws IOException
	{
		return driver.findElement(selectPatient1);
	}*/
	
	public void selectPatientWay3() throws AWTException, InterruptedException
	{
		Robot rb = new Robot(); 
		String pun = "otqdwiuwae"; 
		StringSelection ss = new StringSelection(pun); 
		System.out.println("me: " +pun);
		Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard(); 
		cp.setContents(ss, null); 
		
		//ctrl+F 
		rb.keyPress(KeyEvent.VK_CONTROL); 
		rb.keyPress(KeyEvent.VK_F); 
		rb.keyRelease(KeyEvent.VK_CONTROL); 
		rb.keyRelease(KeyEvent.VK_F); 
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_CONTROL); 
		rb.keyPress(KeyEvent.VK_V); 
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	

	

	
	
	
	
	
	

}
