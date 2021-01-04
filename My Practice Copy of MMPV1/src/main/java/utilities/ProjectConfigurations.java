package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/*This class is nothing but, it's like the "TestData" Class that i have created under MMPV1 maven project*/
public class ProjectConfigurations {
	public Properties propConfig = new Properties();

	/*Created this main method just for me to see the outputs of my code, in real-time we don't have to create main method in configClass*/
	public static void main(String[] args) throws Exception {
		ProjectConfigurations pjc = new ProjectConfigurations();
		pjc.loadProjectConfigPropertyFiles();

	}

/*this method is nothing but, it's like the "registrationPageTestData()" that i have created in TestData Class, under MMPV1 maven project*/
	public Properties loadProjectConfigPropertyFiles() throws Exception{

		/*Best Way*/
		
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\config.properties";
		System.out.println("Printing the file path of config.properties file: " +filePath);
		FileInputStream fis = new FileInputStream(filePath);
		propConfig.load(fis);
		return propConfig;

		/*Ok Way*/
		/*FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\config\\config.properties");
		prop.load(fis);
		return prop;*/

		/*Not Needed Way*/
		/*Properties pro = new Properties();
		String filePath = System.getProperty("user.dir")+"\\config\\config.properties";
		System.out.println("Printing the file path from loadProperties method " +filePath);
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		pro.load(fis);
		return pro;*/
	}


}


