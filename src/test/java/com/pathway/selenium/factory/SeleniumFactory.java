package com.pathway.selenium.factory;

import org.openqa.selenium.WebDriver;

/**
 * Selenium Factory Interface
 *
 */
public interface SeleniumFactory {
	public WebDriver getWebDriver();
	public WebDriver getRemoteWebDriver();
}
