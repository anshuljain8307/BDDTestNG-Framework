package com.qa.stepDefinition;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

import cucumber.api.Scenario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	Logger log = Logger.getLogger(LoginPageSteps.class);
	public static Scenario scenario;
	

//	@Before
//	public void setup()
//	{
//		System.out.println("Starting the test");
//	}
//
//	@After
//	public void teardown(Scenario scenario) throws IOException
//	{
//	
//		byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//	    File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	    FileUtils.copyFile(screenshot_with_scenario_name,
//	      new File("./target/test-report/" + scenario.getName() + ".png"));
//	    System.out.println(scenario.getName());
//	    scenario.embed(screenshot, "image/png");
//	}
	
	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page() throws IOException, InvalidFormatException,ClassNotFoundException  {
		log.info("I am at first step");
		
	 TestBase.initialization("chrome", "Windows 7", "85.0", null);
	 
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM()  {
		log.info("I am at second step");
	 loginpage=new LoginPage();
	 String title =loginpage.validateLoginpagetitle();
	 Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}

	@When("^logo of login page is CRMlogo$")
	public void logo_of_login_page_is_CRMlogo() {
	  boolean logo= loginpage.validateCRMlogo();
	  Assert.assertTrue(logo);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password() throws IOException, InvalidFormatException  {
	   homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	   TestUtil.takeScreenshot("FREECRM Login page");
	}

	
	@Then("^user is on home page$")
	public void user_is_on_home_page()  {
	   String homepagetitle= homepage.verifyHomePageTitle();
	   Assert.assertEquals("CRMPRO", homepagetitle);
	}

}
