package adminModuleTests;

import java.io.IOException;

import org.testng.annotations.Test;

import NAMTG.MMP.TestBase;
import adminModulePages.Admin_Home_UserTab_Page;
import adminModulePages.Admin_Login_Page;
import adminModulePages.Admin_NewAccountRegistration_Page;
import patinetModulePages.Patient_Login_Page;
import patinetModulePages.Patient_NewAccountRegistration_Page;

public class Admin_Home_UserTab_Tests extends TestBase{
	public Admin_NewAccountRegistration_Page anar;
	public Admin_Login_Page alp;
	public Admin_Home_UserTab_Page ahut;
	public Patient_NewAccountRegistration_Page pnar;
	public Patient_Login_Page plp;
	
	@Test
	public void adminHomeUserTabADMM005_TC001() throws IOException, InterruptedException
	{
		initiateBrowser(); //Step1
		launchApplication(); //Step2 & Step3
		
		anar = new Admin_NewAccountRegistration_Page(driver);
		alp = new Admin_Login_Page(driver);
		
		/*Validating HomePage Header tabs: Step4*/
		anar.vHomePageHeaderTabsWay1();
//		anar.vHomePageHeaderTabsWay2();

		/*Patient should click on "Patient Login" tab: Step5*/
		anar.clickOfficeLogin().click(); //Step5
		anar.vLoginPageMessage();//Step6
		Thread.sleep(2000);
		anar.loginButton().click(); //Step7
		alp.vLoginPageURL();

		/*driver.close();*/ /*I use this "driver.close()", whenever i want to test just one test case at a time, but if i want a flow in the 
						testing the i comment-out this "driver.close()" so that the testing flow continues to next TC*/
	}
	
	@Test
	public void adminHomeUserTabADMM005_TC002() throws IOException, InterruptedException
	{
		/*initiateBrowser(); //Step1
		launchApplication(); //Step2 & Step3
		anar = new Admin_NewAccountRegistration_Page(driver);
		anar.clickOfficeLogin().click();
		anar.loginButton().click();*/
		
		anar = new Admin_NewAccountRegistration_Page(driver);
		alp = new Admin_Login_Page(driver);
		ahut = new Admin_Home_UserTab_Page(driver);
//		Thread.sleep(2000);
		alp.enterValidCredentials(); 
		anar.signInButton().click();
		alp.UsersTab().click();
		Thread.sleep(2000);
		ahut.selectUser().click();
		ahut.selectStatus();
		Thread.sleep(3000);
		ahut.submitApprovalButton().click();
		Thread.sleep(2000);
		ahut.handlingPopUp();
		
		driver.close();
		
		initiateBrowser(); //Step1
		launchApplication(); //Step2 & Step3
		
		pnar = new Patient_NewAccountRegistration_Page(driver);
		pnar.clickPatientLogin().click();
		pnar.loginButton().click();
		
		plp = new Patient_Login_Page(driver);
		plp.enterValidPatientCredtials();
		plp.signInButton().click();
		
		
	}

}
