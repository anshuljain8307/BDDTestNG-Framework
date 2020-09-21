package com.qa.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;



public class HomePage extends TestBase {
	
		@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
		WebElement userNameLabel;

		@FindBy(xpath="//a[contains(text(),'Contacts')]")
		WebElement contactLink;

		@FindBy(xpath="//a[contains(text(),'New Contact')]")
		WebElement newContactLink;


		@FindBy(xpath="//a[@title='Deals']")
		WebElement dealsLink;

		@FindBy(xpath="//a[@title='Tasks']")
		WebElement tasksLink;

		//Initializing the page objects
			public HomePage()
			{
				PageFactory.initElements(driver, this);
			}
			
			//Actions:
			
			public String verifyHomePageTitle()
			{
				return driver.getTitle();
			}
			
			
			public boolean verifyusernamelabel()
			{
				return userNameLabel.isDisplayed();
			}

			public void clickonNewContacts()
			{
				Actions action=new Actions(driver);
				action.moveToElement(contactLink).build().perform();
				//Thread.sleep(2000);
				//action.moveToElement(newContactLink).build().perform();
				new WebDriverWait(driver,30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(newContactLink));
				newContactLink.click();	
				
			}


}
