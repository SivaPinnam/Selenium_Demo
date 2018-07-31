package com.pathway.util;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pathway.selenium.factory.SeleniumBuilder;


public class SFLoginUtil {
		
	private static WebDriver webDriver;
	
	public static void userLogin(String username, String password){
		webDriver.findElement(By.id("username")).clear();
		webDriver.findElement(By.id("username")).sendKeys(username);
		webDriver.findElement(By.id("password")).clear();
		webDriver.findElement(By.id("password")).sendKeys(password);
		webDriver.findElement(By.id("Login")).click();
		webDriver.findElement(By.cssSelector("a[title=\"Code Search (New Window)\"]")).click();
	}
	
	public static WebDriver getWebDriver(String browserType){
		WebDriver webDriver = SeleniumBuilder.getDriver(browserType);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.get(DFConstants.SF_SANDBOX);
		return webDriver;
	}
	
	public static String getSeleniumURL(){
		String gridURL = System.getProperty(DFConstants.INTUIT_SELENIUM_GRID_URL,null);
		return gridURL;
	}
	
	public static String getBrowserType(String browserType){
		return System.getProperty(DFConstants.INTUIT_BROWSER_TYPE, browserType);
	}
		
}