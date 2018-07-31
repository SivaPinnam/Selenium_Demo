package com.pathway.util;

import org.openqa.selenium.WebDriver;

public class DFConstants {
	
	public static WebDriver webDriver;
	//server ip
	public static final String LOC_SERVER="localhost";
	public static final int LOC_SERVER_PORT=4444;
	
	// browsers
	public static final String IE="*iexplore";
	public static final String FIREFOX="*firefox";
	
	// salesforce url
	public static final String SF_PROD = "https://login.salesforce.com/";
	public static final String SF_SANDBOX = "https://test.salesforce.com/";
  
	
	// salesforce test BSC User name and password
	public static final String DEMO_USER_USERNAME="madhu.sudhan@optum.com";
	public static final String DEMO_USER_PASSWORD="Sai14Sai$";
		
	// selenium wait time
	public static final String WAITING_TIME="60000";
	
	// browser type
	public static final String INTUIT_BROWSER_TYPE="pathway.browser.type";
	
	//selenium url
	public static final String INTUIT_SELENIUM_GRID_URL="intuit.selenium.grid.url";
	
	//selenium type / Local/ Remote.
	public static final String INTUIT_TEST_TYPE="intuit.selenium.test.type";
}
