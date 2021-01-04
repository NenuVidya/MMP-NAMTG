package patientModuleTests;

import java.io.IOException;

import org.testng.annotations.Test;

import NAMTG.MMP.TestBase;
import patinetModulePages.Patient_Login_Page;
import patinetModulePages.Patient_NewAccountRegistration_Page;


public class Patient_Login_Tests extends TestBase  {
	public Patient_NewAccountRegistration_Page pnar;
	public Patient_Login_Page plp;
	
	
	@Test
	public void loginPATM003_TC001() throws InterruptedException, IOException
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
		pnar.vLoginPageMessage(); //Step4
//		pnar.vLoginNRegisterButtons(); //Step5: Way1 with WebElement[]
		
		plp = new Patient_Login_Page(driver); //Patient_Login_Page 
		plp.vLoginNRegisterButtons(); //Step5: Way2 with By[]
		
		/*pnar.clickUpArrow().click(); //Step6
		Thread.sleep(1000);

		pnar.clickPatientLogin().click(); 
		Thread.sleep(1000);*/

		/*driver.close();*/ /*I use this "driver.close()", whenever i want to test just one test case at a time, but if i want a flow in the 
						testing the i comment-out this "driver.close()" so that the testing flow continues to next TC*/
 					
 	}

	@Test
	public void loginPATM003_TC002() throws InterruptedException, IOException
	{
		/*initiateBrowser(); //Step1
		launchApplication(); //Step2
		Thread.sleep(1000); //I know i should not use Thread.sleep, but, i used it here for me, just to see the correct flow in slow pace
		pnar.clickPatientLogin().click(); //Step3*/	
		pnar = new Patient_NewAccountRegistration_Page(driver);
		plp = new Patient_Login_Page(driver);
		
		plp.loginButton().click();
		plp.vPLoginPageURL();
		plp.vLabels_TextBoxes_Links_ButtonsWay1();
//		plp.vLabels_TextBoxes_Links_ButtonsWay2();
//		pnar.userName();
//		pnar.cun();
		plp.enterValidPatientCredtials();
		Thread.sleep(1000);
		plp.signInButton().click();
		Thread.sleep(2000);
		plp.handlingPopUp();
		
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
