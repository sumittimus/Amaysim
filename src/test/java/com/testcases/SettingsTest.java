package com.testcases;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.LandingPage;
import com.pages.LoginPage;
import com.pages.MenuPage;
import com.pages.SettingsPage;

public class SettingsTest {

	WebDriver driver = null;
	BasePage basePage = null;
	LoginPage loginPage = null;
	LandingPage landingPage=null;
	MenuPage menuPage = null;
	SettingsPage settingsPage = null;
	
	@BeforeClass
	public void init() throws IOException{
		basePage=BasePage.getInstance();
		String brwName = basePage.getProperty("brwName");
		String url = basePage.getProperty("url");
		
		driver = basePage.launchBrowser(brwName, url);
	}
	
	@Test
	public void settingsTest() throws IOException{
		
		loginPage = new LoginPage(driver);
		
		loginPage.isPageLoaded(LoginPage.loginButton);
		loginPage.enterLogin();
		
		landingPage = new LandingPage(driver);
		landingPage.verifyUserName(basePage.getProperty("displayname"));
		
		menuPage = new MenuPage(driver);
		menuPage.clickSettings();
		
		settingsPage =new SettingsPage(driver);
		Assert.assertTrue("Nick Name not available", basePage.isElementPresent(SettingsPage.SIMnickName));
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
	
}
