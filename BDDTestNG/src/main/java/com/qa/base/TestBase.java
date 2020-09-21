package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;




public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	

	
	public TestBase()
	{
		try 
		{
			prop =new Properties();
			FileInputStream ip=new FileInputStream(
					"D:\\FreeCRMPOMFramework"
			+ "\\src\\main\\java\\com\\qa\\config\\config.properties");
			//D:\FreeCRMPOMFramework\src\main\java\com\qa\config\config.properties
			//"user.dir")+ "/src/main/java/com/crm" + "/qa/config/config.properties"
			prop.load(ip);
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization(String browserName, String platformName, String versionName,Method name) throws IOException, InvalidFormatException
	{
		
		System.out.println("browser name is : " + browserName);
		String methodName = name.getName();

		MutableCapabilities sauceOpts = new MutableCapabilities();
		sauceOpts.setCapability("name", methodName);
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "3.11.0");
		sauceOpts.setCapability("username", "Anshul_Jain");
		sauceOpts.setCapability("accessKey", "2cf8ec4b-11d8-4ddc-974b-2a5fc6c78cf8");
		sauceOpts.setCapability("tags", "w3c-chrome-tests");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		cap.setCapability("browserVersion", versionName);
		cap.setCapability("platformName", platformName);
		
		
		
		//String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName", browserName);
			
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
			//driver=new ChromeDriver();
		}
		
		try {
			driver = new RemoteWebDriver(new URL("https://Anshul_Jain:2cf8ec4b-11d8-4ddc-974b-2a5fc6c78cf8@ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
			}


}
