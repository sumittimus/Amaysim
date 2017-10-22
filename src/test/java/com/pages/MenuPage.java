package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage{

	WebDriver driver;
	
	public MenuPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[contains(text(),'Settings')]")
	WebElement lnk_Settings;
	
	public void clickSettings(){
		click(lnk_Settings);
	}
}
