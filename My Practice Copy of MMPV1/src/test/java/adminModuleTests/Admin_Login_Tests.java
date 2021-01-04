package adminModuleTests;

import java.io.IOException;
import org.testng.annotations.Test;
import NAMTG.MMP.TestBase;
import adminModulePages.Admin_NewAccountRegistration_Page;
import adminModulePages.Admin_Login_Page;


public class Admin_Login_Tests extends TestBase  {
	public Admin_NewAccountRegistration_Page anar;
	public Admin_Login_Page alp;
	
	@Test
	public void adminLoginADMM003_TC001() throws InterruptedException, IOException
	{
		initiateBrowser(); //Step1
		launchApplication(); //Step2 & Step3
		
		anar = new Admin_NewAccountRegistration_Page(driver);
		/*Validating HomePage Header tabs: Step4*/
		anar.vHomePageHeaderTabsWay1();
//		anar.vHomePageHeaderTabsWay2();

		/*Patient should click on "Patient Login" tab: Step5*/
		anar.clickOfficeLogin().click(); //Step5
		anar.vLoginPageMessage();//Step6
		Thread.sleep(2000);
		anar.loginButton().click(); //Step7
		anar.vARegistraionPageURL1();//Step8

		/*driver.close();*/ /*I use this "driver.close()", whenever i want to test just one test case at a time, but if i want a flow in the 
						testing the i comment-out this "driver.close()" so that the testing flow continues to next TC*/
 					
 	}

	@Test
	public void adminLoginADMM003_TC002() throws InterruptedException, IOException
	{
		/*initiateBrowser(); //Step1
		launchApplication(); //Step2
		Thread.sleep(1000); //I know i should not use Thread.sleep, but, i used it here for me, just to see the correct flow in slow pace
		anar = new Admin_NewAccountRegistration_Page(driver);
		anar.clickOfficeLogin().click(); //Step3
		Thread.sleep(1000);
		anar.loginButton().click(); //Step4
		Thread.sleep(1000);*/
		anar = new Admin_NewAccountRegistration_Page(driver);
		alp = new Admin_Login_Page(driver);
		
		alp.vLoginPageURL();
		anar.vLabels_TextBoxes_Links_ButtonsWay1(); //Step1 - Using WebElement[]
//		anar.vLabels_TextBoxes_Links_ButtonsWay2(); //Step1 - Using By[]

//***************************************************************************************************************************************
//		this block is not working yet... will have to work on it later
		/*alp = new Admin_Login_Page(driver);
		alp.forgotUPLink().click(); //Step2
		alp.enterEmailID(); //Step3
		alp.emailSendButton().click();*/ //Step3
//***************************************************************************************************************************************
		
		alp.enterValidCredentials(); 
		anar.signInButton().click();
		alp.vAdministratorHomePageTabs();
		
		driver.close();

	}

}







/*public void dump()
 * {
 * //		*******************************************************************************************************
//	It's Not working :(
		WebElement[] result = anar.a;
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = result[i].isDisplayed();
			Assert.assertTrue(r1);
		}

		WebElement[] result = anar.headerTabs();
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = result[i].isDisplayed();
			Assert.assertTrue(r1);
		}
//		********************************************************************************************************

	}*/
