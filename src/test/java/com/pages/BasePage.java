package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.constants;

public class BasePage {

	static WebDriver driver = null;
	Properties prop = new Properties();
	WebDriverWait wait=null;
	private static BasePage instance = null;
	
	public String getProperty(String propKey) throws IOException{
		String propvalue;
		
		try {
			FileInputStream fs = new FileInputStream(constants.PROJECT_PROPERTIES);
			prop.load(fs);
			fs.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		propvalue = prop.getProperty(propKey);
		
		return propvalue;
	}
	
	
	public static BasePage getInstance(){
		instance = new BasePage();
		return instance;
		
	}
	
	public WebDriver launchBrowser(String brwName,String url){
		if(brwName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", constants.GECKO_PATH);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}else if(brwName.equals("Chrome")){
			//Chrome not implemented
			driver = new ChromeDriver();
		}else if(brwName.equals("IE")){
			System.setProperty("webdriver.ie.driver", constants.IE_PATH);
			driver = new InternetExplorerDriver();
			driver.get(url);
		}
		
		return driver;	
	}
	
	public void waitForVisibility(WebElement element){
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(WebElement element){
		waitForVisibility(element);
		element.click();
	}
	
	public void sendKeys(WebElement element,String text){
		waitForVisibility(element);
		element.sendKeys(text);
	}
	
	public boolean isPageLoaded(WebElement element){
		waitForVisibility(element);
		return element.isDisplayed();
	}
	
	public boolean isElementPresent(WebElement element){
		waitForVisibility(element);
		return element.isDisplayed();
	}
	
	public String getText(WebElement element){
		waitForVisibility(element);
		return element.getText();
	}
	
	public void quit(){
		driver.close();
	}
}
