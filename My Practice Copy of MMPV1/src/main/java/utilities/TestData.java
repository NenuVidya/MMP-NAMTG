package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import NAMTG.MMP.TestBase;

public class TestData{
	
	public Properties prop = new Properties(); //we created an object of Properties class
	public Random r = new Random();
	
	public String randomString()
	{
//		Random r = new Random();
	    String str = "";
	    for(int i=0; i<10; i++)
	    {
	    	char c = (char)(r.nextInt(26) + 'a');
	    	str = str + c;
	    }
	    System.out.println("Random Generated String: " +str);
		return str;
	}
	
	public int randomNumbers()
	{
//		Random r = new Random();
		int randomNums = (int) (Math.random()*Math.pow(10,10));
		System.out.println("Random Generated Numbers: " +randomNums);
		return randomNums; //1478087677

	}
	
	public String randomLicense()
	{
		Random r = new Random();
		int randomLicenseNum = (int) (Math.random()*Math.pow(10,7));
//		System.out.println("Random Generated License Numbers: " +randomLicenseNum);
				
		/*I wrote the following block, especially as the input to the String[] Array that i have created in "PATM001_TC003_SecondWay_PO" 
		class to pass the values for sendkeys... to pass the values of sendkeys i have created a string array... and a String[] Array will
		not accept an int value... as license number is an integer, so, i had to convert int to String to be accepted as the string in 
		String[]... and will use this block only when i use the String[] to send values as sendkeys... and should remember to change the
		return type as String whenever i use the following block*/
		String s1 = "1" + Integer.toString(randomLicenseNum); 
		System.out.println(s1); //OR
//		String s2 = "1"+s1;
//		System.out.println(s2);
		return s1;
	}
	
	public String randomSSN()
	{
		Random r = new Random();
		int randomSSNNum = (int) (Math.random()*Math.pow(10,9));
//		System.out.println("Random Generated SSN Numbers: " +randomSSNNum);
		String s1 = Integer.toString(randomSSNNum); 
//		System.out.println(s1);
		return s1;
	}
	
	public String randomEmail()
	{
		Random r = new Random();
	    String str = "";
	    for(int i=0; i<10; i++)
	    {
	    	char c = (char)(r.nextInt(26) + 'a');
	    	str = str + c;
	    }
//	    System.out.println("Random Generated Email: " +str +"@gmail.com");
	    return str;
	}
	
	public String randomZipcode()
	{
		Random r = new Random();
		int randomZipcode = (int) (Math.random()*Math.pow(10,5)); /*//math.pow(10 //here 10 indicates between 0-10 numbers, 
																	5 //here 5 indicates numbers with 5 digits)*/
//		System.out.println("Random Generated Zipcodes: " +randomZipcode);
		String s1 = Integer.toString(randomZipcode); 
//		System.out.println(s1);
		return s1;
	}
	
	
	public void homePageTestData() throws IOException
	{
		//FileInputStream fis = new FileInputStream("C:\\Users\\vidya\\workspace\\MMPFwkV1\\src\\main\\java\\resources\\homePageTestData.properties"); //this is hard coding of test data file path
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\homePageTestData.properties"); //this is not hard coding of test data file path
		System.out.println(System.getProperty("user.dir")); //to get the path of "user.dir"
//		System.out.println(fis);
		prop.load(fis);	
	}

	public void loginPageTestData() throws IOException
	{
		//FileInputStream fis = new FileInputStream("C:\\Users\\vidya\\workspace\\MMPFwkV1\\src\\main\\java\\resources\\loginPageTestdata.properties"); //this is hard coding of test data file path
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\loginPageTestdata.properties"); //this is not hard coding of test data file path
		prop.load(fis);
	}

	public void registrationPageTestData() throws IOException
	{
		//FileInputStream fis = new FileInputStream("C:\\Users\\vidya\\workspace\\MMPFwkV1\\src\\main\\java\\resources\\registrationPageTestData.properties"); //this is hard coding of test data file path
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\registrationPageTestData.properties"); //this is not hard coding of test data file path
		prop.load(fis);
	}
	
//	@Test
	public void execute() throws IOException
	{
		homePageTestData();
		registrationPageTestData();
		randomString();
		randomNumbers();
		randomLicense();
		randomSSN();
		randomEmail();
		randomZipcode();
	}


}



