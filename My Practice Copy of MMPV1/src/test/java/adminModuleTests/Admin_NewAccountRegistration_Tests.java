package adminModuleTests;

import java.io.IOException;
import org.testng.annotations.Test;
import NAMTG.MMP.TestBase;
import adminModulePages.Admin_NewAccountRegistration_Page;


public class Admin_NewAccountRegistration_Tests extends TestBase  {
	public Admin_NewAccountRegistration_Page anar; /*Creating object reference for "Admin_NewAccountRegistration_Page" class object, to 
													access members of the class */
													
	@Test
	public void newAccountRegistrationADMM001_TC001() throws InterruptedException, IOException
	{
		initiateBrowser(); //Step1
		launchApplication(); //Step2 & Step3
		
		anar = new Admin_NewAccountRegistration_Page(driver); /*Creating object of "Admin_NewAccountRegistration_Page" class, to access 
																members of the class */
		
		/*	Validating HomePage Header tabs: Step4*/
		anar.vHomePageHeaderTabsWay1();
		/*anar.vHomePageHeaderTabsWay2();*/

		/*Patient should click on "Patient Login" tab: Step5*/
		anar.clickOfficeLogin().click();

		/*driver.close();*/ /*I use this "driver.close()", whenever i want to test just one test case at a time, but if i want a flow in 
		 					the testing then i comment-out this "driver.close()" so that the testing flow continues to next TC*/
 					
 	}

	@Test
	public void newAccountRegistrationPATM001_TC002() throws InterruptedException, IOException
	{
		anar = new Admin_NewAccountRegistration_Page(driver);
		/*initiateBrowser(); //Step1
		launchApplication(); Step2
		Thread.sleep(1000); //I know i should not use Thread.sleep, but, i used it here for me, just to see the correct flow in slow pace
		anar.clickOfficeLogin().click();*/ //Step3
		
		anar.vLoginPageMessage();//Step4
		Thread.sleep(2000);
		anar.loginButton().click(); //Step5
		anar.vARegistraionPageURL1(); //Step6
		
//		anar.vLabels_TextBoxes_Links_ButtonsWay1(); //Step7 - Using WebElement[]
		anar.vLabels_TextBoxes_Links_ButtonsWay2(); //Step7 - Using By[]
		
		anar.registerButton().click(); //Step8
		
//		driver.close();

	}

	@Test
	public void newAccountRegistrationPATM001_TC003() throws Exception
	{
		anar = new Admin_NewAccountRegistration_Page(driver);
		/*initiateBrowser(); //Step1
		launchApplication(); //Step2
		Thread.sleep(1000); //I know i should not use Thread.sleep, but, i used it here for me, just to see the correct flow in slow pace
		anar.clickOfficeLogin().click(); //Step3
		Thread.sleep(2000);
		anar.loginButton().click();
		anar.vRegistraionPageURL();
		anar.registerButton().click(); */ //Step4
		
		anar.enterValidValuesWay1(); //Steps6,7,8,9
//		anar.enterValidValuesWay2();
//		anar.enterValidValuesWay3();
		
		anar.clickSaveButton().click();
		Thread.sleep(2000);
		anar.handlingPopUp();

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
