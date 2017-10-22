package com.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.LandingPage;
import com.pages.LoginPage;

public class LoginTest {

	WebDriver driver=null;
	BasePage basePage=null;
	LoginPage loginPage=null;
	LandingPage landingPage=null;
	
	@BeforeClass
	public void init() throws IOException{
		basePage=BasePage.getInstance();
		String brwName = basePage.getProperty("brwName");
		String url = basePage.getProperty("url");
		
		driver = basePage.launchBrowser(brwName, url);
		
		//driver = basePage.launchBrowser("IE", "https://accounts.amaysim.com.au/identity/login");
	}
	
	@Test
	public void testLogin() throws IOException{
		//String userName = basePage.getProperty("displayname");
		//basePage = new BasePage();
		//driver = basePage.launchBrowser("IE", "https://accounts.amaysim.com.au/identity/login");
		loginPage = new LoginPage(driver);
				
		loginPage.enterLogin();
		landingPage=new LandingPage(driver);
		landingPage.verifyUserName(basePage.getProperty("displayname"));
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
}
