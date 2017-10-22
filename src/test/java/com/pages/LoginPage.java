package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		isElementPresent(userName);
	}
	
	public LoginPage() {
		// Temporary Constructor
	}
	
	@FindBy(xpath="//*[@id='username']")
	public static WebElement userName;
	
	@FindBy(xpath="//*[@id='password']")
	public static WebElement passWord;
	
	@FindBy(xpath="//*[@id='new_session']/button")
	public static WebElement loginButton;
	
	//Action Functions
	
	public void enterLogin() throws IOException{
		String uName = getProperty("username");
		String pWd = getProperty("password");
		sendKeys(userName, uName);
		sendKeys(passWord, pWd);
		click(loginButton);
	}
	
}
