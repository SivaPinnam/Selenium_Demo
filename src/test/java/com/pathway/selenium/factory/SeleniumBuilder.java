package com.pathway.selenium.factory;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import com.pathway.util.DFConstants;
import com.pathway.util.SFLoginUtil;

/**
 * SeleniumBuilder
 */
public class SeleniumBuilder {
	
	public static WebDriver getDriver(String browserType) {
		String testType = System.getProperty(DFConstants.INTUIT_TEST_TYPE, "local");
		if (StringUtils.equalsIgnoreCase(testType, "remote")) {
			return getRemoteDriver(browserType);
		} else {
			return getLocalDriver(browserType);
		}
	}

	private static WebDriver getRemoteDriver(String browserType) {
		String browser_Type = SFLoginUtil.getBrowserType(browserType);
		if (StringUtils.equalsIgnoreCase(browser_Type, "ie")) {
			return new SeleniumIEFactory().getRemoteWebDriver();
		} else if (StringUtils.equalsIgnoreCase(browser_Type, "chrome")) {
			return new SeleniumChromeFactory().getRemoteWebDriver();
		}
		return new SeleniumFirefoxFactory().getRemoteWebDriver();
	}

	private static WebDriver getLocalDriver(String browserType) {
		String browser_Type = SFLoginUtil.getBrowserType(browserType);
		if (StringUtils.equalsIgnoreCase(browser_Type, "ie")) {
			return new SeleniumIEFactory().getWebDriver();
		} else if (StringUtils.equalsIgnoreCase(browser_Type, "chrome")) {
			return new SeleniumChromeFactory().getWebDriver();
		}
		return new SeleniumFirefoxFactory().getWebDriver();
	}
}
