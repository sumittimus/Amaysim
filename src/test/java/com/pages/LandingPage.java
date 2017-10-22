package com.pages;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{

	WebDriver driver;
	public LandingPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		isElementPresent(UserName);
		click(UserName);
	}
	
	@FindBy (xpath="//a[@class='close-reveal-modal']")
	WebElement PopUpWelcomeToAmaysim;
	
	@FindBy (xpath="//div[@class='service-primary-heading']")
	WebElement UserName;
	
	
	
	public void verifyUserName(String userName){
		String displayName = getText(UserName);
		System.out.println("Username correct");
		Assert.assertTrue("UserName correct", userName.equals(displayName));
	}
}
