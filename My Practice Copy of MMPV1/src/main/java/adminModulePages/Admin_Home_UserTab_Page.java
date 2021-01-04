package adminModulePages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import consolidatedPages.AllPages;
import patinetModulePages.Patient_NewAccountRegistration_Page;
import utilities.TestData;

public class Admin_Home_UserTab_Page extends TestData {
	WebDriver driver;
	
//	public String str = randomString();
	
	public Admin_Home_UserTab_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public Patient_NewAccountRegistration_Page pnar = new Patient_NewAccountRegistration_Page(driver);
	
	By selectUser = By.linkText(pnar.un);
	public WebElement selectUser() throws IOException
	{
		return driver.findElement(selectUser);
	}
	
	By statusApproval = By.id("sapproval");
	public void selectStatus()
	{
		Select selectStatus = new Select(driver.findElement(statusApproval));
		//In above line, I have used "Select" class to select the value from drop down list of secret questions
		selectStatus.selectByVisibleText("Accepted"); 
	}
	
	By submitApprovalButton = By.xpath("//tbody/tr[13]/td[1]/input[1]"); //"//input[type = 'submit']"
	public WebElement submitApprovalButton()
	{
		return driver.findElement(submitApprovalButton);
	}
	
	public void handlingPopUp() throws IOException
	{
		Alert alert = driver.switchTo().alert();

		String expectedSuccessfullAdminApproval = (" USER has been updated.");
		String actualSuccessfullAdminApproval = alert.getText();
		System.out.println("Successful Registration Message: " +expectedSuccessfullAdminApproval);

		Assert.assertEquals(actualSuccessfullAdminApproval, expectedSuccessfullAdminApproval);

		alert.accept(); //clicked "OK" button on pop-up window
	}
	
}



//************************************************************************************************************************
/*public By userName = By.id("username");
public void userName() throws IOException
{
	driver.findElement(userName).sendKeys(str);
}*/

/*public String pUN() //pUN = Patient User Name
{
	String pfn = driver.findElement(userName).getText();
	System.out.println("Captured Patient User Name" +pfn);
	return pfn;
}*/
//************************************************************************************************************************
