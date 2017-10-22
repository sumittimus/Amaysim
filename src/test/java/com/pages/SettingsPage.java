package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BasePage{

	WebDriver driver;
	
	@FindBy(linkText="Prepaid, BPay")
	WebElement paymentType;
	
	@FindBy(xpath="//div[contains(text(),'SIM Nickname')]")
	public static WebElement SIMnickName;
	
	public SettingsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isElementPresent(SIMnickName);
	}
	
}
