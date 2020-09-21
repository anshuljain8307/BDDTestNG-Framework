package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;


public class LoginPage extends TestBase{

	//PageFactory - object Repository
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginbtn;
		
		@FindBy(xpath="//a[@class='navbar-brand']")
		WebElement crmlogo;
		
		//Initializing the page objects
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		
		public String validateLoginpagetitle()
		{
			System.out.println(driver.getTitle());
			return driver.getTitle();
		}
		
		public boolean validateCRMlogo()
		{
			return crmlogo.isDisplayed();
		}
		
		public HomePage login(String un,String pwd) throws IOException
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginbtn.click();
			//TestUtil.takeScreenshot("homepage");
			return new HomePage();
		}
		
		

}
