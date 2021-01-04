package patientModuleTests;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import NAMTG.MMP.TestBase;
import patinetModulePages.Patient_NewAccountRegistration_Page;


public class Patient_NewAccountRegistration_Tests extends TestBase  {
	public Patient_NewAccountRegistration_Page pnar;

	@Test
	public void newAccountRegistrationPATM001_TC001() throws InterruptedException, IOException
	{
		initiateBrowser(); //Step1
		launchApplication(); //Step2 & Step3

		/*Creating object for "Patient_NewAccountRegistration_Page"  class, to access the members of the class */
		pnar = new Patient_NewAccountRegistration_Page(driver);
		
		/*	Validating HomePage Header tabs: Step4*/
		pnar.vHomePageHeaderTabsWay1();
		/*pnar.vHomePageHeaderTabsWay2();*/

		/*Patient should click on "Patient Login" tab: Step5*/
		pnar.clickPatientLogin().click();
		pnar.vLoginPageMessage(); 		//Step4
		pnar.vLoginNRegisterButtons(); //Step5
		pnar.clickUpArrow().click(); //Step6
		Thread.sleep(1000);
		pnar.clickPatientLogin().click(); 
		Thread.sleep(1000);

		/*driver.close();*/ /*I use this "driver.close()", whenever i want to test just one test case at a time, but if i want a flow in the 
						testing the i comment-out this "driver.close()" so that the testing flow continues to next TC*/
 					
 	}


	@Test
	public void newAccountRegistrationPATM001_TC002() throws Exception
	{
		/*initiateBrowser(); //Step1
		launchApplication(); //Step2
		Thread.sleep(1000); //I know i should not use Thread.sleep, but, i used it here for me, just to see the correct flow in slow pace
		Patient_NewAccountRegistration_Page pnar = new Patient_NewAccountRegistration_Page(driver);
		pnar.clickPatientLogin().click(); //Step3
		Thread.sleep(2000);
		pnar.registerButton().click(); //Step4
		Thread.sleep(2000);*/
		
		pnar = new Patient_NewAccountRegistration_Page(driver);
		pnar.registerButton().click(); //Step7
		Thread.sleep(1000);
		pnar.vPRegistrationPageURL(); //Step5
		
//		Patient_NewAccountRegistration_Page pnar = new Patient_NewAccountRegistration_Page(driver);
		pnar.enterValidValuesWay1(); //Steps6,7,8,9
//		pnar.enterValidValuesWay2();
//		pnar.enterValidValuesWay3();
		pnar.capturedPatientRegisteredUserName();
		pnar.test();
		pnar.clickSaveButton().click();
		Thread.sleep(2000);
		pnar.handlingPopUp();

		driver.close();
	}

	

}







/*public void dump()
 * {
 * //		*******************************************************************************************************
//	It's Not working :(
		WebElement[] result = pnar.a;
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = result[i].isDisplayed();
			Assert.assertTrue(r1);
		}

		WebElement[] result = pnar.headerTabs();
		for(int i=0; i<result.length;i++)
		{
			boolean r1 = result[i].isDisplayed();
			Assert.assertTrue(r1);
		}
//		********************************************************************************************************

	}*/
